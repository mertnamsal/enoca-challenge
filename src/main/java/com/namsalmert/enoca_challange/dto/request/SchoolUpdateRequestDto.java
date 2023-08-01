package com.namsalmert.enoca_challange.dto.request;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SchoolUpdateRequestDto {
    private String name;
    private String location;

}
