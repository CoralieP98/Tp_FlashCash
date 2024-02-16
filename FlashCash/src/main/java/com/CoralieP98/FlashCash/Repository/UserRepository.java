package com.CoralieP98.FlashCash.Repository;

import com.CoralieP98.FlashCash.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {}
