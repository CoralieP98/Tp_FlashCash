package com.CoralieP98.FlashCash.Repository;

import com.CoralieP98.FlashCash.Model.Transfert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransfertRepository extends JpaRepository<Transfert, Integer> {
}
