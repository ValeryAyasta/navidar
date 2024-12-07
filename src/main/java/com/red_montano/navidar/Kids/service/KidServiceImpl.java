package com.red_montano.navidar.Kids.service;

import com.red_montano.navidar.Kids.domain.dto.KidRequest;
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
        kid.setAssistance("SI");
        return kidRepository.save(kid);
    }

    @Override
    public Kid markGift(Long kidId) {
        Kid kid = kidRepository.findById(kidId).orElseThrow(() -> new RuntimeException("Kid no encontrado"));
        kid.setGift("SI");
        return kidRepository.save(kid);
    }

    @Override
    public Kid dismark(Long kidId) {
        Kid kid = kidRepository.findById(kidId).orElseThrow(() -> new RuntimeException("Kid no encontrado"));
        kid.setGift("NO");
        kid.setAssistance("NO");
        return kidRepository.save(kid);
    }

    @Override
    public Kid createKid(KidRequest kidRequest) {

        Integer highestNumber = kidRepository.findMaxNumber().orElse(0);
        Integer newNumber = highestNumber + 1;

        String ageGroup = determineAgeGroup(kidRequest.getAge());

        Kid kid = new Kid();
        kid.setNumber(newNumber);
        kid.setName(kidRequest.getName());
        kid.setLastName(kidRequest.getLastName());
        kid.setAge(kidRequest.getAge());
        kid.setAgeGroup(ageGroup);
        kid.setGender(kidRequest.getGender());
        kid.setParent(kidRequest.getParent());
        kid.setPage(9);
        kid.setAssistance(kidRequest.getAssistance());
        kid.setGift("NO");


        return kidRepository.save(kid);
    }

    private String determineAgeGroup(Integer age) {
        if (age >= 1 && age <= 3) {
            return "1 a 3";
        } else if (age >= 4 && age <= 7) {
            return "4 a 7";
        } else if (age >= 8 && age <= 10) {
            return "8 a 10";
        } else if (age >= 11 && age <= 12) {
            return "11 a 12";
        } else {
            throw new IllegalArgumentException("La edad no está en un rango válido");
        }
    }
}
