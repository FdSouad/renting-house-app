package com.example.backend.controller;


import com.example.backend.entities.House;
import com.example.backend.services.HouseService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/houses")
@CrossOrigin(origins = "http://localhost:3000")
public class HouseController {

    private final HouseService houseService;

    public HouseController(HouseService houseService) {
        this.houseService = houseService;
    }

    @GetMapping
    public List<House> getAllHouses() {
        return houseService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<House> getHouseById(@PathVariable Long id) {
        return houseService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<House> createHouse(@Valid @RequestBody House house) {
        House saved = houseService.save(house);
        return ResponseEntity.ok(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<House> updateHouse(@PathVariable Long id, @Valid @RequestBody House house) {
        return houseService.findById(id)
                .map(existing -> {
                    existing.setTitle(house.getTitle());
                    existing.setDescription(house.getDescription());
                    existing.setPrice(house.getPrice());
                    existing.setLocation(house.getLocation());
                    existing.setAvailable(house.isAvailable());
                    houseService.save(existing);
                    return ResponseEntity.ok(existing);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHouse(@PathVariable Long id) {
        if (houseService.findById(id).isPresent()) {
            houseService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

