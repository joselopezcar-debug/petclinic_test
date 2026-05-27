package com.tecsup.petclinic.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tecsup.petclinic.dtos.VisitDTO;
import com.tecsup.petclinic.entities.Visit;
import com.tecsup.petclinic.exceptions.ResourceNotFoundException;
import com.tecsup.petclinic.mappers.VisitMapper;
import com.tecsup.petclinic.repositories.VisitRepository;

@Service
public class VisitServiceImpl implements VisitService {

    @Autowired
    private VisitRepository repository;

    @Autowired
    private VisitMapper mapper;

    @Override
    public VisitDTO save(VisitDTO dto) {

        Visit entity = mapper.mapToEntity(dto);

        Visit saved = repository.save(entity);

        return mapper.mapToDto(saved);
    }

    @Override
    public VisitDTO findById(Integer id) {

        Visit entity = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Visit no encontrado con id: " + id));

        return mapper.mapToDto(entity);
    }

    @Override
    public List<VisitDTO> findAll() {

        return repository.findAll()
                .stream()
                .map(mapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {

        Visit entity = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Visit no encontrado con id: " + id));

        repository.delete(entity);
    }
}
