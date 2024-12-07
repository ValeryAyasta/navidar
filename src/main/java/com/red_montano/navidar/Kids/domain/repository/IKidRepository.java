package com.red_montano.navidar.Kids.domain.repository;

import com.red_montano.navidar.Kids.domain.entity.Kid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface IKidRepository extends JpaRepository<Kid, Long> {

    @Query("SELECT MAX(k.number) FROM Kid k")
    Optional<Integer> findMaxNumber();
}
