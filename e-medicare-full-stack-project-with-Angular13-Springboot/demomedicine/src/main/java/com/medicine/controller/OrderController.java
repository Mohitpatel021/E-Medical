package com.medicine.controller;

import com.medicine.exception.ResourceNotFoundException;
import com.medicine.model.Orders;
import com.medicine.services.ViewOrderService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v4")
@RestController
public class OrderController {

  @Autowired
  private ViewOrderService vieworderService;

  @GetMapping("/orders")
  public List<Orders> getViewOrders() {
    List<Orders> orderList = vieworderService.fetchorders();
    return orderList;
  }

  // http://localhost:8080/api/v1/getorder/1
  @GetMapping("/order/{orderid}")
  public ResponseEntity<Orders> getorder(@PathVariable("orderid") int orderid)
    throws ResourceNotFoundException {
    Orders vieworder = vieworderService.getorder(orderid);
    return ResponseEntity.ok().body(vieworder);
  }

  // http://localhost:8080/api/v1/addorder
  @PostMapping("/order")
  public Orders addorder(@RequestBody Orders view) {
    Orders vieworder = vieworderService.saveorder(view);

    return vieworder;
  }

  // http://localhost:8080/api/v1/updateorder/2
  @PutMapping("/order/{orderid}")
  public ResponseEntity<Orders> updateorder(
    @PathVariable("orderid") int orderid,
    @RequestBody Orders orderDetails
  ) throws ResourceNotFoundException {
    Orders view = vieworderService.getorder(orderid);

    view.setOrderid(orderDetails.getOrderid());
    view.setUserid(orderDetails.getUserid());
    view.setOrderdate(orderDetails.getOrderdate());
    view.setTotalprice(orderDetails.getTotalprice());
    final Orders updateorder = vieworderService.saveorder(view);
    return ResponseEntity.ok(updateorder);
  }

  @DeleteMapping(value = "/order/{orderid}")
  public ResponseEntity<Object> deleteorder(
    @PathVariable("orderid") int orderid
  ) {
    vieworderService.deleteorder(orderid);
    return new ResponseEntity<>("order deleted successsfully", HttpStatus.OK);
  }
}
