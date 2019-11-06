package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.H2jdbcReadDemo;
import com.example.demo.dao.RuntimeTable;
import com.example.demo.model.Product;
import com.example.demo.service.intf.ProductService;

@RestController
public class ProductServiceController {
	@Autowired
	ProductService productService;

	@RequestMapping(value = "/products")
	public ResponseEntity<Object> getProduct() {
		return new ResponseEntity<>(productService.getProducts(), HttpStatus.OK);
	}

	@RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateProduct(@PathVariable("id") String id, @RequestBody Product product) {
		productService.updateProduct(id, product);
		return new ResponseEntity<>("Product is updated successsfully", HttpStatus.OK);
	}

	@RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> delete(@PathVariable("id") String id) {
		productService.deleteProduct(id);
		return new ResponseEntity<>("Product is deleted successsfully", HttpStatus.OK);
	}

	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public ResponseEntity<Object> createProduct(@RequestBody Product product) {
		productService.createProduct(product);
		return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
	}

	@RequestMapping(value = "/newModel/{attr1}/{attr2}", method = RequestMethod.POST)
	public ResponseEntity<Object> createNewModel(@PathVariable("attr1") String attr1,
			@PathVariable("attr2") String attr2) {
		productService.createNewModel(attr1, attr2);
		return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
	}

	@RequestMapping(value = "/records")
	public ResponseEntity<Object> getRecords() {
		productService.getRecords();
		return new ResponseEntity<>("Records read successfully, Refer console for more details! ", HttpStatus.OK);
	}
}
