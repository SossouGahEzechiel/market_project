package com.example.deb_projet.Authentication;

import com.example.deb_projet.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserSeeder {

    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    /*@Override
    public void run(String... args) throws Exception {
        Role role = new Role();
        role.setId(2);
        role.setLib("user");
        User user = new User("user@gmail.com","User",99887744,
                "user1",'m',role,passwordEncoder.encode("user123"),"user");
        role.setId(1);
        role.setLib("admin");
        User admin = new User("admin@gmail.com","Admin",11223344,
                "admin1",'m',role,passwordEncoder.encode("admin123"),"admin");

        List<User> users = Arrays.asList(user, admin);
        userRepository.saveAll(users);
    }*/
}
