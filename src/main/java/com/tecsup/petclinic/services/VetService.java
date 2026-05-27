package com.tecsup.petclinic.services;

import java.util.List;
import com.tecsup.petclinic.dtos.VetDTO;

public interface VetService {

    VetDTO save(VetDTO vetDTO);

    VetDTO findById(Integer id);

    List<VetDTO> findAll();

    void delete(Integer id);
}
