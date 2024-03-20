package org.example.dao;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

@JsonSerialize
@JsonDeserialize
@Data
public class StoreDAO {

    @JsonProperty("storeId")
    private int storeId;

    @JsonProperty("locationId")
    private int locationId;

    @JsonProperty("products")
    private List<ProductDAO> products;

}
