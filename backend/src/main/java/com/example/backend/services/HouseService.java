package com.example.backend.services;

import com.example.backend.entities.House;
import com.example.backend.repositories.HouseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HouseService {

    private final HouseRepository houseRepository;

    public HouseService(HouseRepository houseRepository) {
        this.houseRepository = houseRepository;
    }

    public List<House> findAll() {
        return houseRepository.findAll();
    }

    public Optional<House> findById(Long id) {
        return houseRepository.findById(id);
    }

    public House save(House house) {
        return houseRepository.save(house);
    }

    public void deleteById(Long id) {
        houseRepository.deleteById(id);
    }
}

