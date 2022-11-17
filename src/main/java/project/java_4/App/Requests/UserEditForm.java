package project.java_4.App.Requests;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import project.java_4.App.Models.Role;
import project.java_4.App.Models.User;
import project.java_4.App.Services.UserService;

import java.util.Collections;

@Data
public class UserEditForm {
    private long user_id;
    private String username;
    private String password;
    private String email;
    private String phone;

    public User toUser(PasswordEncoder passwordEncoder){
        User user = new User();
        user.setId(user_id);
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        user.setPhone(phone);
        user.setUsername(username);
        user.setRoles(Collections.singleton(Role.USER));

        return user;
    }
}
