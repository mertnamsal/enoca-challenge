package com.namsalmert.enoca_challange.dto.response;

import com.namsalmert.enoca_challange.model.Teacher;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SchoolResponseDto {

    private String name;
    private String location;
}
