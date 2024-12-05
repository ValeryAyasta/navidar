package com.red_montano.navidar.Kids.domain.repository;

import com.red_montano.navidar.Kids.domain.entity.Kid;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IKidRepository extends JpaRepository<Kid, Long> {

}
