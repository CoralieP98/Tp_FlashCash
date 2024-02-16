package com.CoralieP98.FlashCash.Service;

import com.CoralieP98.FlashCash.Model.Account;
import com.CoralieP98.FlashCash.Model.User;
import com.CoralieP98.FlashCash.Repository.UserRepository;
import com.CoralieP98.FlashCash.Service.Form.SignUpForm;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User registration(SignUpForm form){
        User user = new User();
        Account account = new Account();
        account.setAmount(0.0);
        user.setAccount(account);
        user.setFirstName(form.getFirstName());
        user.setLastName(form.getLastName());
        user.setEmail(form.getEmail());
        user.setPassword(passwordEncoder.encode(form.getPassword()));
        return userRepository.save(user);
    }
}
