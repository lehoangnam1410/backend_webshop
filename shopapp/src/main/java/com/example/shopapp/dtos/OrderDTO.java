package com.example.shopapp.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import lombok.*;

@Data //ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    @JsonProperty("user_id")
    @Min(value = 1,message="min")
    private Long userId;

    @JsonProperty("fullname")
    private String fullName;

    private String email;

    @JsonProperty("phone_number")
    private String phoneNumber;

    private String note;

    @Min(value = 0,message="min")
    @JsonProperty("total_money")

    private Float totalMoney;
    @JsonProperty("shipping_method")

    private String shippingMethod;

    @JsonProperty("shipping_address")
    private String shippingAddress;

    @JsonProperty("payment_method")
    private String paymentMethod;
}
//{
// "user_id":"1",
// "fullname":"nguyenvana",
// "email":"123",
// "phone_number":"0211221",
// "note":"ádasdas",
// "total_money":"123123",
// "shipping_method":"23123",
// "shipping_address":"123123",
// "payment_method":"ádasdas"
//}