package com.example.shopapp.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import javax.swing.*;
import java.util.List;

@Data //ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    @NotEmpty(message = "Name cannot be empty")
    private String name;
    @Min(value = 0,message = "price>0")
    @Max(value = 1000000000,message ="price<1000000000" )
    private String price;
    private String thumbnail;
    private String description;

     @JsonProperty("category_id")
     private String categoryId;
     private List<MultipartFile> files;
}
