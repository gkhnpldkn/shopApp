package com.gokhan.myshops.requests;

import com.gokhan.myshops.model.Category;
import lombok.Data;

import java.math.BigDecimal;
@Data

public class AddProductRequests {
    private Long id;
    private String name;
    private String brand;
    private String description;
    private BigDecimal price;
    private int inventory;

    private Category category;
}
