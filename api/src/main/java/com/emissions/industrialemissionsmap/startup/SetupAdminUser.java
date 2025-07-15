package com.emissions.industrialemissionsmap.startup;

import com.emissions.industrialemissionsmap.model.User;
import com.emissions.industrialemissionsmap.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class SetupAdminUser {
    final
    UserRepository userRepository;
    @Value("${ADMIN_USERNAME}")
    String adminUsername;
    @Value("${ADMIN_PASSWORD}")
    String adminPassword;

    public SetupAdminUser(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostConstruct
    public void init() {
        log.warn( "Users table is empty. Initializing admin user." );
        User admin = new User();
        List<User> users = userRepository.findAll();
        if(users.isEmpty()) {
            admin.setName(adminUsername);
            admin.setPassword(adminPassword);
            userRepository.save(admin);
        }
    }
}
