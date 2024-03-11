package com.CoralieP98.FlashCash.Controller;

import com.CoralieP98.FlashCash.Service.CustomService;
import com.CoralieP98.FlashCash.Service.Form.ContactForm;
import com.CoralieP98.FlashCash.Service.ServiceClientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ServiceClientController {

    private final ServiceClientService serviceClientService;
    private final CustomService customService;


    public ServiceClientController(ServiceClientService serviceClientService, CustomService customService) {
        this.serviceClientService = serviceClientService;
        this.customService = customService;
    }

    @GetMapping("/serviceClient")
    public ModelAndView serviceClient(Model model){
        model.addAttribute("contactForm");
        return new ModelAndView("/User/contactForm");
    }

    @PostMapping("/serviceClient")
    public String registerMessage(@ModelAttribute("contactForm") ContactForm form){
        serviceClientService.registrationMessage();
        return "redirect:/User/profile";
    }
}
