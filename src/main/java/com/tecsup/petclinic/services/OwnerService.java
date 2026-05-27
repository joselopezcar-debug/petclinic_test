package com.tecsup.petclinic.services;

import java.util.List;

import com.tecsup.petclinic.dtos.OwnerDTO;

public interface OwnerService {
    OwnerDTO save(OwnerDTO ownerDTO);

    OwnerDTO findById(Integer id);

    List<OwnerDTO> findAll();

    void delete(Integer id);
}
