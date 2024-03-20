package org.example.dao;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@JsonSerialize
@JsonDeserialize
@Data
public class ProductDAO {

    @JsonProperty("product_id")
    private int productId;

    @JsonProperty("store_id")
    private int storeId;

    @JsonProperty("location_id")
    private int locationId;

    @JsonProperty("price")
    private double price;

    @JsonProperty("discount")
    private double discount;

    @JsonProperty("memo")
    private String memo;

}
