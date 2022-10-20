package project.java_4.App.Controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import project.java_4.App.Models.User;

@Controller
@RequestMapping("/")
public class HomeController {
    @GetMapping
    public String index(@AuthenticationPrincipal User user, Model model){
        if (user != null){
            model.addAttribute("user",user.getUsername());
            return "index";
        }

        model.addAttribute("user","anonymous");
        return "index";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }
}
