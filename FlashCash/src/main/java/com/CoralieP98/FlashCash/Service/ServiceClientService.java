package com.CoralieP98.FlashCash.Service;

import com.CoralieP98.FlashCash.Model.User;
import com.CoralieP98.FlashCash.Repository.UserRepository;
import com.CoralieP98.FlashCash.Service.Form.ContactForm;
import org.springframework.stereotype.Service;

@Service
public class ServiceClientService {

    private final CustomService customService;


    public ServiceClientService(CustomService customService, UserRepository userRepository) {
        this.customService = customService;

    }

    public void registrationMessage(){
        User curUser= customService.actualUser();
//        c'est la que je pourrais faire le bout de code qui enregistre le message blablabla...

    }
}
