package com.namsalmert.enoca_challange.dto.response;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TeacherResponseDto {
    private String name;
    private String surname;
    private String school;
}
