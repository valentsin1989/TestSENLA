package com.gmail.valentsin1989.test.service.model;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class AddOrderDTO {
    @NotNull(message = "UserId cannot be empty.")
    private long userId;
    @NotNull(message = "Price cannot be empty.")
    private List<Long> listProductId;
}
