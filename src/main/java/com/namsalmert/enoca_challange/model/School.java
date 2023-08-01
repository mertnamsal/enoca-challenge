package com.namsalmert.enoca_challange.model;


import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import java.util.List;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class School extends BaseEntity{
    private String name;
    private String location;
    @OneToMany(mappedBy = "school",fetch = FetchType.LAZY)
    private List<Teacher> teachers;
}
