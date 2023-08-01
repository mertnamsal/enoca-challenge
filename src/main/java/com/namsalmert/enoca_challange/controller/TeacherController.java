package com.namsalmert.enoca_challange.controller;

import com.namsalmert.enoca_challange.dto.request.TeacherAddRequestDto;
import com.namsalmert.enoca_challange.dto.request.TeacherUpdateRequestDto;
import com.namsalmert.enoca_challange.dto.response.TeacherResponseDto;
import com.namsalmert.enoca_challange.service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/teacher")
public class TeacherController {
    private final TeacherService teacherService;

    @PostMapping()
    public ResponseEntity<TeacherResponseDto> addTeacher(@RequestBody @Valid TeacherAddRequestDto dto){
        return ResponseEntity.ok(teacherService.addTeacher(dto));
    }
    @GetMapping()
    public ResponseEntity<List<TeacherResponseDto>> findAllTeachers(){
        return ResponseEntity.ok(teacherService.findAllTeachers());
    }
    @GetMapping("/{id}")
    public ResponseEntity<TeacherResponseDto> findTeacherById(@PathVariable Long id){
        return ResponseEntity.ok(teacherService.findTeacherById(id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeacher(@PathVariable Long id){
        teacherService.deleteTeacherById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<TeacherResponseDto> updateTeacherById(@PathVariable Long id,@RequestBody TeacherUpdateRequestDto dto){
        return ResponseEntity.ok(teacherService.updateTeacherById(id,dto));
    }
}
