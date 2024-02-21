package com.CoralieP98.FlashCash.Service;

import com.CoralieP98.FlashCash.Model.User;
import com.CoralieP98.FlashCash.Repository.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class CustomService {

  private final UserRepository userRepository;

    public CustomService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User actualUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String actualUserName = authentication.getName();
        User user= userRepository.findUserByMail(actualUserName).get();
        return user;
    }
}
