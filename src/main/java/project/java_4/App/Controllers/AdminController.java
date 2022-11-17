package project.java_4.App.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;
import project.java_4.App.Models.User;
import project.java_4.App.Requests.UserEditForm;
import project.java_4.App.Services.UserService;

import java.util.List;

@Controller
@PreAuthorize(value = "hasAuthority('ADMIN')")
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/users")
    public String userList(Model model){
        List<User> users = userService.findAll();
        model.addAttribute("users",users);
        return "admin/user/index";
    }

    @GetMapping("/user/{id}/edit")
    public String userList(@PathVariable("id") Long id, Model model){
        User user = userService.findById(id);
        model.addAttribute("user",user);
        return "admin/user/edit";
    }

    @PostMapping(value = "/user/edit")
    public RedirectView editUser(UserEditForm form){
        userService.saveUser(form.toUser(passwordEncoder));

        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/admin/users");

        return redirectView;
    }

    @GetMapping("/user/{id}/delete")
    public RedirectView userDelete(@PathVariable("id") Long id, Model model){
        userService.deleteById(id);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/admin/users");

        return redirectView;
    }
}
