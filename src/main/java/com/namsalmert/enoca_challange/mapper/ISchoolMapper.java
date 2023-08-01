package com.namsalmert.enoca_challange.mapper;

import com.namsalmert.enoca_challange.dto.request.SchoolAddRequestDto;
import com.namsalmert.enoca_challange.dto.response.SchoolResponseDto;
import com.namsalmert.enoca_challange.model.School;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ISchoolMapper {
    ISchoolMapper INSTANCE = Mappers.getMapper(ISchoolMapper.class);
    SchoolResponseDto toSchoolResponseDto(School school);
    School toSchool(SchoolAddRequestDto schoolAddRequestDto);
    List<SchoolResponseDto> toSchoolResponseDtoList(List<School> schools);
}
