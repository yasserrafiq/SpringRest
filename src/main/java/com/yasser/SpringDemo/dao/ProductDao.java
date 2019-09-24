package com.yasser.SpringDemo.dao;

import org.springframework.data.repository.CrudRepository;

import com.yasser.SpringDemo.dto.Product;

public interface ProductDao extends CrudRepository<Product, Integer>{

}
