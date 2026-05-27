package com.tecsup.petclinic.mappers;

import org.mapstruct.Mapper;

import com.tecsup.petclinic.dtos.SpecialityDTO;
import com.tecsup.petclinic.entities.Speciality;

@Mapper(componentModel = "spring")
public interface SpecialityMapper {

    Speciality mapToEntity(SpecialityDTO dto);

    SpecialityDTO mapToDto(Speciality entity);
}
