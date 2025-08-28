package com.sanjiban.restapi.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudentDto {
    private String id;
    private String name;
    private String course;
    private String email;
}
