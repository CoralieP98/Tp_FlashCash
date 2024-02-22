package com.CoralieP98.FlashCash.Controller;

import com.CoralieP98.FlashCash.Service.CustomService;
import com.CoralieP98.FlashCash.Service.Form.SignUpForm;
import com.CoralieP98.FlashCash.Service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    private final UserService userService;

    private final CustomService customService;


    public UserController(UserService userService, CustomService customService) {
        this.userService = userService;
        this.customService = customService;
    }

    @GetMapping("/")
    public String home(Model model){
        return "redirect:/home";
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

    @GetMapping("/User/profile")
    public ModelAndView userProfil(Model model){
        model.addAttribute("user",customService.actualUser());
        return new ModelAndView("/User/user-profil");
    }





}
