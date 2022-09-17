package com.gmail.valentsin1989.test.service.model;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class AddProductDTO {
    @NotNull(message = "Name cannot be empty.")
    private String name;
    @NotNull(message = "Price cannot be empty.")
    private double price;

}
