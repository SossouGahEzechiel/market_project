package com.example.deb_projet.repository;

import com.example.deb_projet.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    User findUserByPseudo(String pseudo);
}
