package com.namsalmert.enoca_challange.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Teacher extends BaseEntity{
   private String name;
   private String surname;
   @ManyToOne(fetch = FetchType.LAZY)
   private School school;

}
