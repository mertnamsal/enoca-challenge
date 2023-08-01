package com.namsalmert.enoca_challange.mapper;

import com.namsalmert.enoca_challange.dto.request.TeacherAddRequestDto;
import com.namsalmert.enoca_challange.dto.response.TeacherResponseDto;
import com.namsalmert.enoca_challange.model.Teacher;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,componentModel = "spring")
public interface ITeacherMapper {
    ITeacherMapper INSTANCE = Mappers.getMapper(ITeacherMapper.class);
    Teacher toTeacher(TeacherAddRequestDto teacherAddRequestDto);

}
