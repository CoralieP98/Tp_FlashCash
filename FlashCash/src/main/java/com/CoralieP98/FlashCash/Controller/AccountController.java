package com.CoralieP98.FlashCash.Controller;

import com.CoralieP98.FlashCash.Repository.AccountRepository;
import com.CoralieP98.FlashCash.Service.AccountService;
import com.CoralieP98.FlashCash.Service.CustomService;
import com.CoralieP98.FlashCash.Service.Form.AddCashForm;
import com.CoralieP98.FlashCash.Service.Form.IbanForm;
import com.CoralieP98.FlashCash.Service.Form.WithdrawCashForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AccountController {

    private final AccountRepository accountRepository;

    private final CustomService customService;

    private final AccountService accountService;

    public AccountController(AccountRepository accountRepository, CustomService customService, AccountService accountService) {
        this.accountRepository = accountRepository;
        this.customService = customService;
        this.accountService = accountService;
    }

    @GetMapping("/addIban")
    public ModelAndView addIbanform(Model model){
        model.addAttribute("ibanForm",customService.actualUser().getAccount());
        return new ModelAndView("/user/userIban");
    }

    @PostMapping("/addIban")
    public String saveIban(@ModelAttribute("ibanForm") IbanForm iban){
        accountService.saveIban(iban);
        return "redirect:/User/profile";
    }

    @GetMapping("/addCash")
    public ModelAndView addCashForm(Model model){
        model.addAttribute("addCashForm",customService.actualUser().getAccount());
        return new ModelAndView("/User/addCash");
    }

    @PostMapping("/addCash")
    public String addCash(@ModelAttribute("addCashForm") AddCashForm amount){
        accountService.addCash(amount);
        return "redirect:/User/profile";
    }

    @GetMapping("/withdrawCash")
    public ModelAndView withdrawCashForm(Model model){
        model.addAttribute("withdrawCashForm",customService.actualUser().getAccount());
        return new ModelAndView("/User/withdrawCash");
    }

    @PostMapping("/withdrawCash")
    public String withdrawCash(@ModelAttribute("withdrawCashForm") WithdrawCashForm amount){
        accountService.withdrawCash(amount);
        return "redirect:/User/profile";
    }

}
