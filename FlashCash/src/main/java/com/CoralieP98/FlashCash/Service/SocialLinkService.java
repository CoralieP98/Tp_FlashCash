package com.CoralieP98.FlashCash.Service;

import com.CoralieP98.FlashCash.Model.SocialLink;
import com.CoralieP98.FlashCash.Model.User;
import com.CoralieP98.FlashCash.Repository.SocialLinkRepository;
import com.CoralieP98.FlashCash.Repository.UserRepository;
import com.CoralieP98.FlashCash.Service.Form.SocialLinkForm;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SocialLinkService {
    private final SocialLinkRepository socialLinkRepository;
    private final UserRepository userRepository;
    private final CustomService customService;



    public SocialLinkService(SocialLinkRepository socialLinkRepository, UserRepository userRepository, CustomService customService) {
        this.socialLinkRepository = socialLinkRepository;
        this.userRepository = userRepository;
        this.customService = customService;
    }

//    public void addLink(final SocialLinkForm form) {
//        User user = userRepository
//                .findUserByMail(form.getEmail())
//                .orElseThrow(() -> new RuntimeException("user with email " + form.getEmail() + " not found"));
//        User connectedUser = userRepository.findUserByMail(customService.actualUser().getEmail())
//                .orElseThrow(() -> new RuntimeException("user with email  not found"));
//        SocialLink link = new SocialLink();
//
//        link.setUser1(connectedUser);
//        link.setUser2(user);
//        socialLinkRepository.save(link);
//    }

    public void addLink(User link){
        SocialLink newlink = new SocialLink();
        User connectedUser = customService.actualUser();

        User friend = userRepository.findUserByMail(link.getEmail()).get();

        newlink.setUser1(connectedUser);
        newlink.setUser2(friend);
        socialLinkRepository.save(newlink);
    }

    public List<String> getAllFriend(){
        User curUser = customService.actualUser();
        return socialLinkRepository.findSocialLinksByUser1Email(curUser.getEmail())
                .stream().map(SocialLink::getUser2)
                .map(User::getEmail)
                .collect(Collectors.toList());
    }


}
