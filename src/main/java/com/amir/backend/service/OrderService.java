package com.amir.backend.service;

import java.time.LocalDate;
import java.util.List;

import javax.security.auth.login.LoginException;

import com.amir.backend.dto.OrderDTO;
import com.amir.backend.exception.OrderException;
import com.amir.backend.model.Customer;
import com.amir.backend.model.Order;

public interface OrderService {
    Order saveOrder(OrderDTO ordto, String token) throws LoginException, OrderException;

    Order getOrderByOrderId(Integer orderId) throws OrderException;

    Order cancelOrderByOrderId(Integer orderId, String token) throws OrderException, LoginException;

    Order updateOrderByOrder(OrderDTO order, Integer orderId, String token) throws OrderException, LoginException;

    List<Order> getAllOrdersByDate(LocalDate date) throws OrderException;

    Customer getCustomerByOrderid(Integer orderId) throws OrderException;
}