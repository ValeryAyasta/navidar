package com.red_montano.navidar.Kids.domain.service;

import com.red_montano.navidar.Kids.domain.entity.Kid;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IKidService {

    public abstract List<Kid> getAllKids();

    public abstract Kid markAssistance(Long kidId);

    public abstract Kid markGift(Long kidId);
}
