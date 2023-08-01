package com.namsalmert.enoca_challange.dto.request;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TeacherAddRequestDto {
    private String name;
    private String surname;
    private Long schoolId;
}
