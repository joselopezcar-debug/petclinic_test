package com.tecsup.petclinic.services;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tecsup.petclinic.dtos.VisitDTO;
import com.tecsup.petclinic.exceptions.ResourceNotFoundException;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class VisitServiceTest {

    @Autowired
    private VisitService service;

    @Test
    void testCreateVisit() {

        VisitDTO dto = new VisitDTO();

        dto.setPetId(1);
        dto.setVetId(1);
        dto.setVisitDate(LocalDate.now());
        dto.setDescription("General Checkup");
        dto.setCost(new BigDecimal("80.00"));

        VisitDTO saved = service.save(dto);

        assertNotNull(saved.getId());
    }

    @Test
    void testFindVisit() {

        VisitDTO dto = new VisitDTO();

        dto.setPetId(1);
        dto.setVetId(2);
        dto.setVisitDate(LocalDate.now());
        dto.setDescription("Vaccination");
        dto.setCost(new BigDecimal("45.00"));

        VisitDTO saved = service.save(dto);

        VisitDTO found = service.findById(saved.getId());

        assertEquals("Vaccination", found.getDescription());
    }

    @Test
    void testUpdateVisit() {

        VisitDTO dto = new VisitDTO();

        dto.setPetId(1);
        dto.setVetId(1);
        dto.setVisitDate(LocalDate.now());
        dto.setDescription("Old Description");
        dto.setCost(new BigDecimal("50.00"));

        VisitDTO saved = service.save(dto);

        saved.setDescription("Updated Description");

        VisitDTO updated = service.save(saved);

        assertEquals("Updated Description", updated.getDescription());
    }

    @Test
    void testDeleteVisit() {

        VisitDTO dto = new VisitDTO();

        dto.setPetId(1);
        dto.setVetId(1);
        dto.setVisitDate(LocalDate.now());
        dto.setDescription("Delete Test");
        dto.setCost(new BigDecimal("30.00"));

        VisitDTO saved = service.save(dto);

        Integer id = saved.getId();

        service.delete(id);

        assertThrows(ResourceNotFoundException.class, () -> {
            service.findById(id);
        });
    }
}
