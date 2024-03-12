package com.CoralieP98.FlashCash.Service;

import com.CoralieP98.FlashCash.Model.Transfert;
import com.CoralieP98.FlashCash.Model.User;
import com.CoralieP98.FlashCash.Repository.TransfertRepository;
import com.CoralieP98.FlashCash.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TransfertService {

    private final TransfertRepository transfertRepository;
    private final CustomService customService;
    private final UserRepository userRepository;

    private final SocialLinkService socialLinkService;


    public TransfertService(TransfertRepository transfertRepository, CustomService customService, UserRepository userRepository, SocialLinkService socialLinkService) {
        this.transfertRepository = transfertRepository;
        this.customService = customService;
        this.userRepository = userRepository;
        this.socialLinkService = socialLinkService;
    }

    public void tranferCash(Transfert transfert){
        User user1 =userRepository.findUserByMail(transfert.getUser_from().getEmail()).get();
        User user2 =userRepository.findUserByMail(transfert.getUser_to().getEmail()).get();
        double amount_before_fee = transfert.getAmount_before_fee();
        double amount_after_fee = amount_before_fee*1.005;
        user1.getAccount().setAmount(user1.getAccount().getAmount()- amount_after_fee);
        user2.getAccount().setAmount(user2.getAccount().getAmount()+ amount_before_fee);
        userRepository.save(user1);
        userRepository.save(user2);
        Date date = new Date();

        transfert.setDate(date);
        transfert.setUser_from(user1);
        transfert.setUser_to(user2);
        transfert.setAmount_before_fee(amount_before_fee);
        transfert.setAmount_after_fee(amount_after_fee);

        transfertRepository.save(transfert);



    }
}
