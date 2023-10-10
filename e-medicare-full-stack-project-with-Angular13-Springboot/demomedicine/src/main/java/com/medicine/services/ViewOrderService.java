package com.medicine.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import com.medicine.repository.OrderRepository;
import com.medicine.model.Orders;

public class ViewOrderService {
    @Autowired
    private OrderRepository orderRep;

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public List<Orders> fetchorders() {
        return orderRep.findAll();
    }

    @Transactional
    public Orders saveorder(Orders view) {
        return orderRep.save(view);
    }

    @Transactional
    public void updateorder(Orders view) {
        orderRep.save(view);
    }

    @Transactional
    public void deleteorder(int orderid) {
        orderRep.deleteById(orderid);
    }

    @Transactional
    public Orders getorder(int orderid) {
        return orderRep.findById(orderid).orElse(null);
    }
}
