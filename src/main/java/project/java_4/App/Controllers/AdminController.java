package project.java_4.App.Controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;

public class AdminController {

    @PreAuthorize(value = "hasAuthority(ADMIN)")
    @GetMapping("/list")
    public String userList(){
        return "admin.user.index";
    }
}
