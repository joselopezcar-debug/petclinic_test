package com.tecsup.petclinic.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tecsup.petclinic.dtos.SpecialityDTO;
import com.tecsup.petclinic.entities.Speciality;
import com.tecsup.petclinic.exceptions.ResourceNotFoundException;
import com.tecsup.petclinic.mappers.SpecialityMapper;
import com.tecsup.petclinic.repositories.SpecialityRepository;

@Service
public class SpecialityServiceImpl implements SpecialityService {

    @Autowired
    private SpecialityRepository repository;

    @Autowired
    private SpecialityMapper mapper;

    @Override
    public SpecialityDTO save(SpecialityDTO dto) {
        Speciality entity = mapper.mapToEntity(dto);
        Speciality saved = repository.save(entity);

        return mapper.mapToDto(saved);
    }

    @Override
    public SpecialityDTO findById(Integer id) {

        Speciality entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Speciality no encontrada con id: " + id));

        return mapper.mapToDto(entity);
    }

    @Override
    public List<SpecialityDTO> findAll() {

        return repository.findAll().stream().map(mapper::mapToDto).collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {

        Speciality entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Speciality no encontrada con id: " + id));

        repository.delete(entity);
    }
}
