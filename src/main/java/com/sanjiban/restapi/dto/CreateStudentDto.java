package com.sanjiban.restapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
@Getter
@Setter
public class CreateStudentDto {
    private String name;
    private String course;
    private String email;
}
