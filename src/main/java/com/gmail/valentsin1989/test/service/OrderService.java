package com.gmail.valentsin1989.test.service;

import com.gmail.valentsin1989.test.service.model.AddOrderDTO;
import com.gmail.valentsin1989.test.service.model.AddedOrderDTO;

public interface OrderService {
    AddedOrderDTO addOrder(AddOrderDTO addOrderDTO);
}
