package com.tecsup.petclinic.services;

import com.tecsup.petclinic.dtos.SpecialityDTO;
import com.tecsup.petclinic.exceptions.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class SpecialityServiceTest {

    @Autowired
    private SpecialityService service;

    @Test
    void testCreateSpeciality() {

        SpecialityDTO dto = new SpecialityDTO();
        dto.setName("Cardiologia");

        SpecialityDTO saved = service.save(dto);

        assertNotNull(saved.getId());
        assertEquals("Cardiologia", saved.getName());
    }

    @Test
    void testFindSpeciality() {

        SpecialityDTO dto = new SpecialityDTO();
        dto.setName("Neurologia");

        SpecialityDTO saved = service.save(dto);
        SpecialityDTO found = service.findById(saved.getId());
        assertEquals("Neurologia", found.getName());
    }

    @Test
    void testDeleteSpeciality() {

        SpecialityDTO dto = new SpecialityDTO();
        dto.setName("Dermatologia");

        SpecialityDTO saved = service.save(dto);
        Integer id = saved.getId();

        service.delete(id);
        assertThrows(ResourceNotFoundException.class, () -> {service.findById(id);});
    }
}
