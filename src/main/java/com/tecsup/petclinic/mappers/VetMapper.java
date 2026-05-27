package com.tecsup.petclinic.mappers;

import org.mapstruct.Mapper;

import com.tecsup.petclinic.dtos.VetDTO;
import com.tecsup.petclinic.entities.Vet;

@Mapper(componentModel = "spring")
public interface VetMapper {

    Vet mapToEntity(VetDTO dto);

    VetDTO mapToDto(Vet entity);
}
