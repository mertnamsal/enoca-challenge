package com.namsalmert.enoca_challange.controller;

import com.namsalmert.enoca_challange.dto.request.SchoolAddRequestDto;
import com.namsalmert.enoca_challange.dto.request.SchoolUpdateRequestDto;
import com.namsalmert.enoca_challange.dto.response.SchoolResponseDto;
import com.namsalmert.enoca_challange.model.School;
import com.namsalmert.enoca_challange.service.SchoolService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/school")
public class SchoolController {
    private final SchoolService schoolService;

    @PostMapping()
    public ResponseEntity<SchoolResponseDto> addSchool(@RequestBody @Valid SchoolAddRequestDto dto){
        return ResponseEntity.ok(schoolService.addSchool(dto));
    }
    @GetMapping()
    public ResponseEntity<List<SchoolResponseDto>> findAllSchools(){
        return ResponseEntity.ok(schoolService.findAllSchools());
    }
    @GetMapping("/{id}")
    public ResponseEntity<SchoolResponseDto> findSchoolById(@PathVariable Long id){
        return ResponseEntity.ok(schoolService.findSchoolById(id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSchool(@PathVariable Long id){
        schoolService.deleteSchoolById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<SchoolResponseDto> updateSchoolById(@PathVariable Long id, @RequestBody SchoolUpdateRequestDto dto){
        return ResponseEntity.ok(schoolService.updateById(id,dto));
    }

}
