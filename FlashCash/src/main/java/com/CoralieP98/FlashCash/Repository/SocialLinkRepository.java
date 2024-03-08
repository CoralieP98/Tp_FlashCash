package com.CoralieP98.FlashCash.Repository;

import com.CoralieP98.FlashCash.Model.SocialLink;
import com.CoralieP98.FlashCash.Model.Transfert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SocialLinkRepository extends JpaRepository<SocialLink, Integer> {
    public List<SocialLink> findSocialLinksByUser1Email(String email);

    public SocialLink findSocialLinkByUser1EmailAndUser2Email(String email1, String email2);


}
