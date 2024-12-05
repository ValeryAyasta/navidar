package com.red_montano.navidar.Kids.service;

import com.red_montano.navidar.Kids.domain.entity.Kid;
import com.red_montano.navidar.Kids.domain.repository.IKidRepository;
import com.red_montano.navidar.Kids.domain.service.IKidService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KidServiceImpl implements IKidService {

    private final IKidRepository kidRepository;

    public KidServiceImpl(IKidRepository kidRepository) {
        this.kidRepository = kidRepository;
    }

    @Override
    public List<Kid> getAllKids() {
        return kidRepository.findAll();
    }

    @Override
    public Kid markAssistance(Long kidId) {
        Kid kid = kidRepository.findById(kidId).orElseThrow(() -> new RuntimeException("Kid no encontrado"));
        kid.setAssistance("SÍ");
        return kidRepository.save(kid);
    }

    @Override
    public Kid markGift(Long kidId) {
        Kid kid = kidRepository.findById(kidId).orElseThrow(() -> new RuntimeException("Kid no encontrado"));
        kid.setGift("SÍ");
        return kidRepository.save(kid);
    }
}
