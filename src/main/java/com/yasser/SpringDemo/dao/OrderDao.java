package com.yasser.SpringDemo.dao;

import com.yasser.SpringDemo.dto.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderDao extends CrudRepository<Order, Integer>{

}
