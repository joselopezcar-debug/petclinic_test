package com.tecsup.petclinic.mappers;

import org.mapstruct.Mapper;

import com.tecsup.petclinic.dtos.VisitDTO;
import com.tecsup.petclinic.entities.Visit;

@Mapper(componentModel = "spring")
public interface VisitMapper {

    Visit mapToEntity(VisitDTO dto);

    VisitDTO mapToDto(Visit entity);
}
