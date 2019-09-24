package com.yasser.SpringDemo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.yasser.SpringDemo.dao.ProductDao;
import com.yasser.SpringDemo.dto.Product;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductDao productDao;
	
	@GetMapping("/allProducts")
	public List<Product> getProducts(){
		return (List<Product>)productDao.findAll();
	}

    @GetMapping("/{id}")
    public Optional<Product> getProducts(@PathVariable(value = "id") int id){
        Optional<Product> product = productDao.findById(id);
        return product;
    }
	
	@PostMapping("/")
	public String saveProduct(@RequestBody List<Product> product) {
		productDao.saveAll(product);
		return product.size() + " Product(s) Saved";
	}

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable(value = "id") int id) {
        productDao.deleteById(id);
        return "Product Deleted";
    }

    @PutMapping("/")
    public String updateProduct(@RequestBody Product product) {
            Optional<Product> product1 = productDao.findById(product.getId());
        if(product1.isPresent()){
            productDao.save(product);
            return "Product Updated";
        }
        else{
            return "Product not found";
        }

    }
}
