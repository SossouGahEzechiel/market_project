package com.example.deb_projet.service;

import com.example.deb_projet.models.Role;
import com.example.deb_projet.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    RoleRepository roleRepository;

    public List<Role> all(){
        return roleRepository.findAll();
    }

    public void insert(Role role){
        roleRepository.save(role);
    }

    public Role get(int id){
        Optional<Role> optionalRole = roleRepository.findById(id);
        if(optionalRole.isPresent()){
            Role role;
            role = optionalRole.get();
            return role;
        }
        throw new RuntimeException("An error occurred");
    }

    public void destroy(int id){
        Optional<Role> optionalRole = roleRepository.findById(id);
        if(optionalRole.isPresent())
            roleRepository.deleteById(id);
    }
}
