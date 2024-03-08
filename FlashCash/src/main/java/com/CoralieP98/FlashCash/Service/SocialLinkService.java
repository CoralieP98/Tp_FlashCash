package com.CoralieP98.FlashCash.Service;

import com.CoralieP98.FlashCash.Model.SocialLink;
import com.CoralieP98.FlashCash.Model.User;
import com.CoralieP98.FlashCash.Repository.SocialLinkRepository;
import com.CoralieP98.FlashCash.Repository.UserRepository;
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

    public void deleteLink(String email){
        socialLinkRepository.delete(socialLinkRepository.
                findSocialLinkByUser1EmailAndUser2Email(customService.actualUser().getEmail(),email));
    }


}
