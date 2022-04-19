package com.example.deb_projet.Authentication;

import com.example.deb_projet.models.Role;
import com.example.deb_projet.models.User;
import com.example.deb_projet.repository.RoleRepository;
import com.example.deb_projet.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserSeeder{

    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    RoleRepository roleRepository;

    /*@Override
    public void run(String... args) throws Exception {
        Role user_role = new Role();
        user_role.setLib("user");

        Role admin_role = new Role();
        admin_role.setLib("admin");

        List<Role> roles = Arrays.asList(admin_role,user_role);
        roleRepository.saveAll(roles);

        User user = new User("user@gmail.com","User",99887744,
                "user1",'m',user_role,passwordEncoder.encode("user123"),"user");

        User admin = new User("admin@gmail.com","Admin",11223344,
                "admin1",'m',admin_role,passwordEncoder.encode("admin123"),"admin");

        List<User> users = Arrays.asList(user, admin);
        userRepository.saveAll(users);
    }*/
}
