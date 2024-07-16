package com.example.shopapp.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.Date;

@Data //ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    @JsonProperty("fullname")
    private String fullName;
    @JsonProperty("phone_number")
    private String phoneNumber;
    private String address;
    private String password;
    @JsonProperty("date_of_birth")
    private Date dateOfBirth;
    @JsonProperty("facebook_account_id")
    private int facebookAccountID;
    @JsonProperty("google_account_id")
    private int googleAccountID;
    @JsonProperty("role_id")
    private Long roleId;
}
//{
//    "fullname":"nguyen van a",
//    "phone_number":"0124555",
//    "address":"02121",
//    "password":"0212211",
//    "date_of_birth":"12/12/2011",
//    "facebool_account_id":"1",
//    "google_account_id":"1",
//    "role_id":"1"
//}