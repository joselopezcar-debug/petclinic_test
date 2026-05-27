package com.tecsup.petclinic.services;

import com.tecsup.petclinic.dtos.VetDTO;
import com.tecsup.petclinic.exceptions.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class VetServiceTest {

    @Autowired
    private VetService service;

    @Test
    void testCreateVet() {

        VetDTO dto = new VetDTO();
        dto.setFirstName("Carlos");
        dto.setLastName("Perez");

        VetDTO saved = service.save(dto);

        assertNotNull(saved.getId());
    }

    @Test
    void testFindVet() {

        VetDTO dto = new VetDTO();
        dto.setFirstName("Luis");
        dto.setLastName("Torres");

        VetDTO saved = service.save(dto);
        VetDTO found = service.findById(saved.getId());
        assertEquals("Luis", found.getFirstName());
    }

    @Test
    void testDeleteVet() {

        VetDTO dto = new VetDTO();
        dto.setFirstName("Mario");
        dto.setLastName("Diaz");

        VetDTO saved = service.save(dto);
        Integer id = saved.getId();

        service.delete(id);
        assertThrows(ResourceNotFoundException.class, () -> {service.findById(id);});
    }
}
