package com.tecsup.petclinic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tecsup.petclinic.entities.Speciality;

public interface SpecialityRepository extends JpaRepository<Speciality, Integer> {
}
