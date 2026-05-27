package com.tecsup.petclinic.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tecsup.petclinic.dtos.VetDTO;
import com.tecsup.petclinic.entities.Vet;
import com.tecsup.petclinic.exceptions.ResourceNotFoundException;
import com.tecsup.petclinic.mappers.VetMapper;
import com.tecsup.petclinic.repositories.VetRepository;

@Service
public class VetServiceImpl implements VetService {

    @Autowired
    private VetRepository repository;

    @Autowired
    private VetMapper mapper;

    @Override
    public VetDTO save(VetDTO dto) {
        Vet entity = mapper.mapToEntity(dto);
        Vet saved = repository.save(entity);

        return mapper.mapToDto(saved);
    }

    @Override
    public VetDTO findById(Integer id) {
        Vet entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Vet no encontrado con id: " + id));

        return mapper.mapToDto(entity);
    }

    @Override
    public List<VetDTO> findAll() {
        return repository.findAll().stream().map(mapper::mapToDto).collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        Vet entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Vet no encontrado con id: " + id));

        repository.delete(entity);
    }
}
