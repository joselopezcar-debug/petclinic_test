package com.tecsup.petclinic.services;

import java.util.List;
import com.tecsup.petclinic.dtos.SpecialityDTO;

public interface SpecialityService {

    SpecialityDTO save(SpecialityDTO specialityDTO);

    SpecialityDTO findById(Integer id);

    List<SpecialityDTO> findAll();

    void delete(Integer id);
}
