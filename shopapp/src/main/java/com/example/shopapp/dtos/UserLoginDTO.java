package com.example.shopapp.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data //ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginDTO {
    @JsonProperty("phone_number")
    private String phoneNumber;
    private String password;
}
