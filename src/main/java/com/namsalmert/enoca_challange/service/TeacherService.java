package com.namsalmert.enoca_challange.service;

import com.namsalmert.enoca_challange.dto.request.TeacherAddRequestDto;
import com.namsalmert.enoca_challange.dto.request.TeacherUpdateRequestDto;
import com.namsalmert.enoca_challange.dto.response.TeacherResponseDto;
import com.namsalmert.enoca_challange.exception.EErrorType;
import com.namsalmert.enoca_challange.exception.EnocaException;
import com.namsalmert.enoca_challange.mapper.ITeacherMapper;
import com.namsalmert.enoca_challange.model.School;
import com.namsalmert.enoca_challange.model.Teacher;
import com.namsalmert.enoca_challange.repository.ITeacherRepository;
import com.namsalmert.enoca_challange.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TeacherService extends ServiceManager<Teacher,Long> {
    private final ITeacherRepository repository;
    private final ITeacherMapper teacherMapper;
    private final SchoolService schoolService;
    public TeacherService(ITeacherRepository repository, ITeacherMapper teacherMapper, SchoolService schoolService) {
        super(repository);
        this.repository = repository;
        this.teacherMapper = teacherMapper;
        this.schoolService = schoolService;
    }

    public TeacherResponseDto addTeacher(TeacherAddRequestDto dto) {
        validateTeacher(dto.getName(),dto.getSurname());
        Optional<School> school = schoolService.findById(dto.getSchoolId());
        if(school.isEmpty()){
            throw new EnocaException(EErrorType.SCHOOL_NOT_FOUND);
        }
        Teacher teacher = teacherMapper.toTeacher(dto);
        teacher.setSchool(school.get());
        save(teacher);

        return TeacherResponseDto.builder()
                .name(dto.getName())
                .surname(dto.getSurname())
                .school(school.get().getName())
                .build();
    }

    public List<TeacherResponseDto> findAllTeachers() {
        List<TeacherResponseDto> dtoList = new ArrayList<>();
        findAll().stream().forEach(x->{
            dtoList.add(TeacherResponseDto.builder()
                            .name(x.getName())
                            .surname(x.getSurname())
                            .school(x.getSchool().getName())
                    .build());
        });
         return dtoList;

    }

    public TeacherResponseDto findTeacherById(Long id) {
        Teacher teacher = getTeacherById(id);
        return TeacherResponseDto.builder()
                .name(teacher.getName())
                .surname(teacher.getSurname())
                .school(teacher.getSchool().getName())
                .build();

    }

    public void deleteTeacherById(Long id) {
        Teacher teacher = getTeacherById(id);
        delete(teacher);
    }
    private void validateTeacher(String name, String surname) {
        Optional<Teacher> teacher = repository.findByNameAndSurname(name,surname);
        if(teacher.isPresent()){
            throw new EnocaException(EErrorType.TEACHER_ALREADY_EXISTS);
        }
    }
    private Teacher getTeacherById(Long id){
        return findById(id).orElseThrow(()-> new EnocaException(EErrorType.TEACHER_NOT_FOUND));
    }

    public TeacherResponseDto updateTeacherById(Long id, TeacherUpdateRequestDto dto) {
        Teacher teacher = getTeacherById(id);
        if(!dto.getName().equals("")){
            teacher.setName(dto.getName());
        }
        if(!dto.getSurname().equals("")){
            teacher.setSurname(dto.getSurname());
        }
        Optional<School> school =schoolService.findById(dto.getSchoolId());
        if(school.isEmpty()){
            throw new EnocaException(EErrorType.SCHOOL_NOT_FOUND);
        }
        teacher.setSchool(school.get());
        save(teacher);
        return TeacherResponseDto.builder()
                .name(teacher.getName())
                .surname(teacher.getSurname())
                .school(teacher.getSchool().getName())
                .build();
    }
}
