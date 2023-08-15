package com.madatrans.controller;

import com.madatrans.service.VoyageService;
import com.madatrans.entity.Voyage;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/voyages")
public class VoyageController {
    private VoyageService voyageService;

    public VoyageController(VoyageService voyageService) {
        this.voyageService = voyageService;
    }

    @PostMapping
    public Voyage addVoyage(@RequestBody Voyage voyage) {
        return voyageService.insert(voyage);
    }

    @GetMapping
    public List<Voyage> getAllVoyages() {
        return voyageService.findAll();
    }

    @GetMapping("/{voyageId}")
    public Voyage getVoyageById(@PathVariable int voyageId) {
        return voyageService.getById(voyageId);
    }

    @PutMapping("/{voyageId}")
    public ResponseEntity<Voyage> updateVoyage(@PathVariable int voyageId, @RequestBody Voyage updatedVoyage) {
        try {
            Voyage updated = voyageService.update(voyageId, updatedVoyage);
            return ResponseEntity.ok(updated);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{voyageId}")
    public ResponseEntity<Map<String, String>> deleteVoyage(@PathVariable int voyageId) {
        try {
            voyageService.delete(voyageId);

            Map<String, String> response = new HashMap<>();
            response.put("success", "Voyage " + voyageId + " deleted successfully.");

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            Map<String, String> response = new HashMap<>();
            response.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}
