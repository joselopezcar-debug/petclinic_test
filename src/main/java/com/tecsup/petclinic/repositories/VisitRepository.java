package com.tecsup.petclinic.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.tecsup.petclinic.entities.Visit;

public interface VisitRepository extends JpaRepository<Visit, Integer> {
}
