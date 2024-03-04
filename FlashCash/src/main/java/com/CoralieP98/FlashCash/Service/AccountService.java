package com.CoralieP98.FlashCash.Service;

import com.CoralieP98.FlashCash.Model.Account;
import com.CoralieP98.FlashCash.Repository.AccountRepository;
import com.CoralieP98.FlashCash.Service.Form.AddCashForm;
import com.CoralieP98.FlashCash.Service.Form.IbanForm;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    private final CustomService customService;


    public AccountService(AccountRepository accountRepository, CustomService customService) {
        this.accountRepository = accountRepository;
        this.customService = customService;
    }

    public void saveIban(IbanForm iban){
        Account curAccount = customService.actualUser().getAccount();
        curAccount.setIban1(iban.getIban1());
        accountRepository.save(curAccount);
    }

    public void addCash(AddCashForm amount){
        Account curAcccount = customService.actualUser().getAccount();
        double curAmount = curAcccount.getAmount();

        curAcccount.setAmount(curAmount + amount.getAmount());
        accountRepository.save(curAcccount);
    }
}
