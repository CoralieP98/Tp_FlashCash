package com.CoralieP98.FlashCash.Service;

import com.CoralieP98.FlashCash.Repository.SocialLinkRepository;
import com.CoralieP98.FlashCash.Repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class SocialLinkService {
    private final SocialLinkRepository socialLinkRepository;
    private final UserRepository userRepository;


    public SocialLinkService(SocialLinkRepository socialLinkRepository, UserRepository userRepository) {
        this.socialLinkRepository = socialLinkRepository;
        this.userRepository = userRepository;
    }
}
