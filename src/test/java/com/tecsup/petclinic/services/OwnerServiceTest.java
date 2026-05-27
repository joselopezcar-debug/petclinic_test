package com.tecsup.petclinic.services;

import com.tecsup.petclinic.dtos.OwnerDTO;
import com.tecsup.petclinic.exceptions.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class OwnerServiceTest {

	@Autowired
	private OwnerService service;

	@Test
	void testCreateOwner() {

		OwnerDTO dto = new OwnerDTO();
		dto.setFirstName("Juan");
		dto.setLastName("Perez");
		dto.setAddress("Av Lima");
		dto.setCity("Lima");
		dto.setTelephone("999999999");

		OwnerDTO saved = service.save(dto);

		assertNotNull(saved.getId());
		assertEquals("Juan", saved.getFirstName());
	}

	@Test
	void testFindOwner() {

		OwnerDTO dto = new OwnerDTO();
		dto.setFirstName("Maria");
		dto.setLastName("Lopez");
		dto.setAddress("Av Norte");
		dto.setCity("Cusco");
		dto.setTelephone("888888888");

		OwnerDTO saved = service.save(dto);
		OwnerDTO found = service.findById(saved.getId());
		assertEquals("Maria", found.getFirstName());
	}

	@Test
	void testDeleteOwner() {

		OwnerDTO dto = new OwnerDTO();
		dto.setFirstName("Jose");
		dto.setLastName("Diaz");
		dto.setAddress("Av Sur");
		dto.setCity("Tacna");
		dto.setTelephone("777777777");

		OwnerDTO saved = service.save(dto);
		Integer id = saved.getId();

		service.delete(id);
		assertThrows(ResourceNotFoundException.class, () -> {service.findById(id);});
	}
}
