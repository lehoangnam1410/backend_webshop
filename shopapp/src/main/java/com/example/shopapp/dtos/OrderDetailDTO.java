package com.example.shopapp.dtos;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderDetailDTO {

    @JsonProperty("order_id")
    private Integer orderId;

    @JsonProperty("product_id")
    private Integer productId;

    @JsonProperty("number_of_products")
    private Integer numberOfProducts;

    private Float price;

    @JsonProperty("total_money")
    private Float totalMoney;
}
