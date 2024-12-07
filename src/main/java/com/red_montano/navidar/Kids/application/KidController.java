package com.red_montano.navidar.Kids.application;

import com.red_montano.navidar.Kids.domain.dto.KidRequest;
import com.red_montano.navidar.Kids.domain.entity.Kid;
import com.red_montano.navidar.Kids.domain.service.IKidService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/kids")
public class KidController {

    private final IKidService kidService;

    public KidController(IKidService kidService) {
        this.kidService = kidService;
    }

    @GetMapping
    public ResponseEntity<List<Kid>> getAllKids() {
        return ResponseEntity.ok(kidService.getAllKids());
    }

    @PutMapping("/{id}/assistance")
    public ResponseEntity<Kid> markAssistance(@PathVariable Long id) {
        return ResponseEntity.ok(kidService.markAssistance(id));
    }

    @PutMapping("/{id}/gift")
    public ResponseEntity<Kid> markGift(@PathVariable Long id) {
        return ResponseEntity.ok(kidService.markGift(id));
    }

    @PutMapping("/{id}/dismark")
    public ResponseEntity<Kid> dismark(@PathVariable Long id){
        return ResponseEntity.ok(kidService.dismark(id));
    }

    @PostMapping
    public ResponseEntity<Kid> createKid(@RequestBody KidRequest kidRequest){
        return ResponseEntity.ok(kidService.createKid(kidRequest));
    }
}
