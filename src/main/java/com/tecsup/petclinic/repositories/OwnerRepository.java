package com.tecsup.petclinic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tecsup.petclinic.entities.Owner;

public interface OwnerRepository extends JpaRepository<Owner, Integer> {
}
