package com.namsalmert.enoca_challange.service;

import com.namsalmert.enoca_challange.dto.request.SchoolAddRequestDto;
import com.namsalmert.enoca_challange.dto.request.SchoolUpdateRequestDto;
import com.namsalmert.enoca_challange.dto.response.SchoolResponseDto;
import com.namsalmert.enoca_challange.exception.EErrorType;
import com.namsalmert.enoca_challange.exception.EnocaException;
import com.namsalmert.enoca_challange.mapper.ISchoolMapper;
import com.namsalmert.enoca_challange.model.School;
import com.namsalmert.enoca_challange.repository.ISchoolRepository;
import com.namsalmert.enoca_challange.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolService extends ServiceManager<School,Long> {

    private final ISchoolRepository repository;
    private final ISchoolMapper schoolMapper;

    public SchoolService(ISchoolRepository repository, ISchoolMapper schoolMapper) {
        super(repository);
        this.repository = repository;
        this.schoolMapper = schoolMapper;
    }

    public SchoolResponseDto addSchool(SchoolAddRequestDto dto) {
        validateSchoolName(dto.getName());
        School school = save(schoolMapper.toSchool(dto));
        return schoolMapper.toSchoolResponseDto(school);
    }

    public List<SchoolResponseDto> findAllSchools() {
        List<School> schools = findAll();
        return schoolMapper.toSchoolResponseDtoList(schools);
    }

    public SchoolResponseDto findSchoolById(Long id) {
        School school = getSchoolById(id);
        return schoolMapper.toSchoolResponseDto(school);
    }

    public void deleteSchoolById(Long id) {
        School school = getSchoolById(id);
        if(school.getTeachers().size()>0){
            throw new EnocaException(EErrorType.SCHOOL_HAS_TEACHERS);
        }
        delete(school);
    }
    private void validateSchoolName(String name) {
        if(repository.findByName(name).isPresent()){
            throw new EnocaException(EErrorType.SCHOOL_ALREADY_EXISTS);
        }
    }
    private School getSchoolById(Long id) {
        return findById(id).orElseThrow(() -> new EnocaException(EErrorType.SCHOOL_NOT_FOUND, "School not found"));
    }

    public SchoolResponseDto updateById(Long id, SchoolUpdateRequestDto dto) {
        School school = getSchoolById(id);
        if(!dto.getName().equals("")){
            school.setName(dto.getName());
        }
        if(!dto.getLocation().equals("")){
            school.setLocation(dto.getLocation());
        }
        update(school);
        return schoolMapper.toSchoolResponseDto(school);
    }
}
