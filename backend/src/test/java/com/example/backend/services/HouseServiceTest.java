package com.example.backend.services;

import static org.junit.jupiter.api.Assertions.*;

import com.example.backend.entities.House;
import com.example.backend.repositories.HouseRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.*;

import static org.mockito.Mockito.*;

class HouseServiceTest {

    @Mock
    private HouseRepository houseRepository;

    private HouseService houseService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        houseService = new HouseService(houseRepository);
    }

    @Test
    void testFindAll() {
        House h1 = new House();
        h1.setId(1L);
        h1.setTitle("Title1");
        h1.setDescription("Desc1");
        h1.setPrice(100.0);
        h1.setLocation("Loc1");
        h1.setAvailable(true);

        House h2 = new House();
        h2.setId(2L);
        h2.setTitle("Title2");
        h2.setDescription("Desc2");
        h2.setPrice(200.0);
        h2.setLocation("Loc2");
        h2.setAvailable(false);

        List<House> mockHouses = Arrays.asList(h1, h2);

        when(houseRepository.findAll()).thenReturn(mockHouses);

        List<House> result = houseService.findAll();

        assertEquals(2, result.size());
        verify(houseRepository, times(1)).findAll();
    }

    @Test
    void testFindByIdFound() {
        House house = new House();
        house.setId(1L);
        house.setTitle("Title");
        house.setDescription("Desc");
        house.setPrice(100.0);
        house.setLocation("Loc");
        house.setAvailable(true);

        when(houseRepository.findById(1L)).thenReturn(Optional.of(house));

        Optional<House> result = houseService.findById(1L);

        assertTrue(result.isPresent());
        assertEquals("Title", result.get().getTitle());
    }

    @Test
    void testFindByIdNotFound() {
        when(houseRepository.findById(1L)).thenReturn(Optional.empty());

        Optional<House> result = houseService.findById(1L);

        assertFalse(result.isPresent());
    }

    @Test
    void testSave() {
        House house = new House();
        house.setTitle("Title");
        house.setDescription("Desc");
        house.setPrice(100.0);
        house.setLocation("Loc");
        house.setAvailable(true);

        House savedHouse = new House();
        savedHouse.setId(1L);
        savedHouse.setTitle("Title");
        savedHouse.setDescription("Desc");
        savedHouse.setPrice(100.0);
        savedHouse.setLocation("Loc");
        savedHouse.setAvailable(true);

        when(houseRepository.save(house)).thenReturn(savedHouse);

        House result = houseService.save(house);

        assertNotNull(result.getId());
        assertEquals(1L, result.getId());
        verify(houseRepository, times(1)).save(house);
    }

    @Test
    void testDeleteById() {
        doNothing().when(houseRepository).deleteById(1L);

        houseService.deleteById(1L);

        verify(houseRepository, times(1)).deleteById(1L);
    }
}
