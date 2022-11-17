package project.java_4.App.Repositories;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import project.java_4.App.Models.User;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String name);
}
