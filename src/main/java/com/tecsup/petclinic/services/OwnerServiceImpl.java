package com.tecsup.petclinic.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tecsup.petclinic.dtos.OwnerDTO;
import com.tecsup.petclinic.entities.Owner;
import com.tecsup.petclinic.exceptions.ResourceNotFoundException;
import com.tecsup.petclinic.mappers.OwnerMapper;
import com.tecsup.petclinic.repositories.OwnerRepository;

@Service
public class OwnerServiceImpl implements OwnerService {

    @Autowired
    private OwnerRepository repository;

    @Autowired
    private OwnerMapper mapper;

    @Override
    public OwnerDTO save(OwnerDTO dto) {
        Owner entity = mapper.mapToEntity(dto);
        Owner saved = repository.save(entity);

        return mapper.mapToDto(saved);
    }

    @Override
    public OwnerDTO findById(Integer id) {
        Owner entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Owner no encontrado con id: " + id));

        return mapper.mapToDto(entity);
    }

    @Override
    public List<OwnerDTO> findAll() {
        return repository.findAll().stream().map(mapper::mapToDto).collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        Owner entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Owner no encontrado con id: " + id));
        repository.delete(entity);
    }
}
