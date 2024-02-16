package com.CoralieP98.FlashCash.Repository;

import com.CoralieP98.FlashCash.Model.Account;
import com.CoralieP98.FlashCash.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {}
