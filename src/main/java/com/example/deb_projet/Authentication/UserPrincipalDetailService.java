package com.example.deb_projet.Authentication;

import com.example.deb_projet.models.User;
import com.example.deb_projet.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserPrincipalDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String pseudo) throws UsernameNotFoundException {
        User user = userRepository.findUserByPseudo(pseudo);
        UserPrincipal userPrincipal = new UserPrincipal(user);
        return userPrincipal;
    }
}
