package project.java_4.App.Models;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public enum Role implements GrantedAuthority {
    USER,ADMIN,EMPLOYEE;

    @Override
    public String getAuthority() {
        return name();
    }
}
