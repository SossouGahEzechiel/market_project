package com.example.deb_projet.service;

import com.example.deb_projet.models.User;
import com.example.deb_projet.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> all(){
        return userRepository.findAll();
    }

    public void insert(User sale){
        userRepository.save(sale);
    }

    public User get(int id){
        Optional<User> userOptional = userRepository.findById(id);
        if(userOptional.isPresent()){
            User user;
            user = userOptional.get();
            return user;
        }

        throw new RuntimeException("An error occurred");
    }

    public void destroy(int id){
        Optional<User> saleOptional = userRepository.findById(id);
        if(saleOptional.isPresent())
            userRepository.deleteById(id);
    }
}
