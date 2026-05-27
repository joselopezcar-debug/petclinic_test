package com.tecsup.petclinic.services;

import com.tecsup.petclinic.dtos.VisitDTO;
import com.tecsup.petclinic.exceptions.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class VisitServiceTest {

    @Autowired
    private VisitService service;

    @Test
    void testCreateVisit() {

        VisitDTO dto = new VisitDTO();
        dto.setDescription("Control general");

        VisitDTO saved = service.save(dto);

        assertNotNull(saved.getId());
        assertEquals("Control general", saved.getDescription());
    }

    @Test
    void testFindVisit() {

        VisitDTO dto = new VisitDTO();
        dto.setDescription("Vacunacion");

        VisitDTO saved = service.save(dto);
        VisitDTO found = service.findById(saved.getId());
        assertEquals("Vacunacion", found.getDescription());
    }

    @Test
    void testDeleteVisit() {

        VisitDTO dto = new VisitDTO();
        dto.setDescription("Emergencia");

        VisitDTO saved = service.save(dto);
        Integer id = saved.getId();

        service.delete(id);
        assertThrows(ResourceNotFoundException.class, () -> {service.findById(id);});
    }
}
