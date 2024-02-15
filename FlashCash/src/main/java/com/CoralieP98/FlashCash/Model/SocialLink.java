package com.CoralieP98.FlashCash.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class SocialLink {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private User user1;

    @ManyToOne
    private User user2;

}
