package project.java_4.App.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import project.java_4.App.Repositories.UserRepository;
import project.java_4.App.Requests.RegistrationForm;

@Controller
@RequestMapping("/registration")
public class RegistrationController {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public String registration(){
        return "registration";
    }

    @PostMapping
    public String processUser(RegistrationForm form){
        userRepository.save(form.toUser(passwordEncoder));
        return "redirect:login";
    }
}
