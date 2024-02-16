package com.CoralieP98.FlashCash.Controller;

import ch.qos.logback.core.model.Model;
import com.CoralieP98.FlashCash.Service.Form.SignUpForm;
import com.CoralieP98.FlashCash.Service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public ModelAndView home(Model model){
        return new ModelAndView("home");
    }

    @PostMapping("/signUp")
    public ModelAndView processRequest(@ModelAttribute("signUpForm") SignUpForm form){
        userService.registration(form);
        return new ModelAndView("signIn");
    }

    @GetMapping("/signUp")
    public ModelAndView showRegisterForm(){
        return new ModelAndView("signUp", "signUpForm",new SignUpForm());
    }

    @GetMapping("/home")
    public String logOff(Model model){
        return "home";
    }
}
