package com.sanjiban.restapi.dto;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SignupDto {
    private Long id;
    private String username;
}
