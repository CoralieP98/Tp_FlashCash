package com.CoralieP98.FlashCash.Controller;

import com.CoralieP98.FlashCash.Model.User;
import com.CoralieP98.FlashCash.Repository.SocialLinkRepository;
import com.CoralieP98.FlashCash.Repository.UserRepository;
import com.CoralieP98.FlashCash.Service.CustomService;
import com.CoralieP98.FlashCash.Service.SocialLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class SocialLinkController {

    @Autowired
    private SocialLinkRepository socialLinkRepository;

    private final UserRepository userRepository;

    private  final SocialLinkService socialLinkService;

    private final CustomService customService;

    public SocialLinkController(UserRepository userRepository, SocialLinkService socialLinkService, CustomService customService) {
        this.userRepository = userRepository;
        this.socialLinkService = socialLinkService;
        this.customService = customService;
    }

//    @RequestMapping("/socialLink/contact")
//    public String listContact(Model model){
//        model.addAttribute("socialLinks", socialLinkRepository.findAll());
//        return "socialLink";
//    }

    @GetMapping("/addContact")
    public ModelAndView addContactForm(Model model){
        model.addAttribute("user", new User());
        return new ModelAndView("/user/addContact");
    }

    @GetMapping("/User/addContact")
    public String addContact(Model model){
        return "/User/addContact";
    }

    @GetMapping("/contact")
    public ModelAndView contactList(Model model){
        model.addAttribute("linkList",socialLinkService.getAllFriend());
        return new ModelAndView("/User/contact");
    }

    @PostMapping("/addContact")
    public String saveContact(@ModelAttribute("user")User link){
        socialLinkService.addLink(link);
        return "redirect:/contact";
    }

    @GetMapping("/deleteLink/{email}")
    public String deleteSocialLink(@PathVariable("email") String email, Model model){
        socialLinkService.deleteLink(email);
        model.addAttribute("linkList",socialLinkService.getAllFriend());
        return "redirect:/contact";
    }

}
