package com.CoralieP98.FlashCash.Controller;

import com.CoralieP98.FlashCash.Model.Transfert;
import com.CoralieP98.FlashCash.Repository.UserRepository;
import com.CoralieP98.FlashCash.Service.CustomService;
import com.CoralieP98.FlashCash.Service.TransfertService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TransfertController {

    private final TransfertService transfertService;
    private final CustomService customService;
    private final UserRepository userRepository;


    public TransfertController(TransfertService transfertService, CustomService customService, UserRepository userRepository) {
        this.transfertService = transfertService;
        this.customService = customService;
        this.userRepository = userRepository;
    }

    @GetMapping("/transferCash/{email}")
    public ModelAndView transferCashForm(@PathVariable("email") String email,Model model){
        Transfert transfert= new Transfert();
        transfert.setUser_from(customService.actualUser());
        transfert.setUser_to(userRepository.findUserByMail(email).get());
        model.addAttribute("transferCashForm",transfert);
        return new ModelAndView("/User/transferCash");
    }

    @PostMapping("/transferCash")
    public String transferCashToContact(@ModelAttribute("transferCashForm")Transfert transfert){
        transfertService.tranferCash(transfert);
        return "redirect:/contact";
    }
}
