package com.example.shopapp.dtos;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.springframework.stereotype.Controller;

@Data //ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {
    @NotEmpty(message = "Fuck off" )
    private String name;
}
