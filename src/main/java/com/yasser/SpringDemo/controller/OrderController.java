package com.yasser.SpringDemo.controller;


import com.yasser.SpringDemo.dao.OrderDao;
import com.yasser.SpringDemo.dto.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
@Slf4j
public class OrderController {

	@Autowired
	private OrderDao orderDao;
	
	@GetMapping("/")
	public List<Order> getUsers(){
		List<Order> list = (List)orderDao.findAll();
        log.info("Message is " + list.toString());
	    return list;
	}

    @GetMapping("/{id}")
    public Optional<Order> getUser(@PathVariable(value = "id") int id){
        Optional<Order> order = orderDao.findById(id);
        return order;
    }
	
	@PostMapping("/")
	public String saveOrder(@RequestBody List<Order> orders) {
		orderDao.saveAll(orders);
		return orders.size() + " Order(s) Saved";
	}

    @DeleteMapping("/{id}")
    public String deleteOrder(@PathVariable(value = "id") int id) {
        orderDao.deleteById(id);
        return "Order Deleted";
    }

    @PutMapping("/")
    public String updateOrder(@org.jetbrains.annotations.NotNull @RequestBody Order order) {
            Optional<Order> order1 = orderDao.findById(order.getOrder_id());
        if(order1.isPresent()){
            orderDao.save(order);
            return "Order Updated";
        }
        else{
            return "Order not found";
        }

    }
}
