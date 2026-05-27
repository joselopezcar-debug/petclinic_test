package com.tecsup.petclinic.services;

import java.util.List;
import com.tecsup.petclinic.dtos.VisitDTO;

public interface VisitService {

    VisitDTO save(VisitDTO visitDTO);

    VisitDTO findById(Integer id);

    List<VisitDTO> findAll();

    void delete(Integer id);
}
