package com.CoralieP98.FlashCash.Controller;

import com.CoralieP98.FlashCash.Model.SocialLink;
import com.CoralieP98.FlashCash.Repository.SocialLinkRepository;
import com.CoralieP98.FlashCash.Service.CustomService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
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
public class SocialLinkController {

    @Autowired
    private SocialLinkRepository socialLinkRepository;

    private final CustomService customService;

    public SocialLinkController(CustomService customService) {
        this.customService = customService;
    }

    @RequestMapping("/socialLink/contact")
    public String listContact(Model model){
        model.addAttribute("socialLinks", socialLinkRepository.findAll());
        return "socialLink";
    }

    @GetMapping("/socialLink/addContact")
    public String addContact(SocialLink link){
        return "socialLink/addContact";
    }

    @PostMapping("/socialLink/validate")
    public String validate(@Valid SocialLink link, BindingResult result, Model model){
        if (!result.hasErrors()){
            socialLinkRepository.save(link);
            model.addAttribute("socialLinks", socialLinkRepository.findAll());
            return "redirect:/socialLink/contact";
        }
        return "socialLink/addContact";
    }

    @GetMapping("/socialLink/delete/")
}
