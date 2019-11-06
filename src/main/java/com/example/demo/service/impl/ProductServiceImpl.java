package com.example.demo.service.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

import com.example.demo.controller.ProductNotfoundException;
import com.example.demo.dao.H2jdbcReadDemo;
import com.example.demo.dao.RuntimeTable;
import com.example.demo.model.Product;
import com.example.demo.service.intf.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	private static Map<String, Product> productRepo = new HashMap<>();
	RuntimeTable runTimeTable = new RuntimeTable();
	static {
		Product honey = new Product();
		honey.setId("1");
		honey.setName("Honey");
		productRepo.put(honey.getId(), honey);

		Product almond = new Product();
		almond.setId("2");
		almond.setName("Almond");
		productRepo.put(almond.getId(), almond);
	}

	@Override
	public void createProduct(Product product) {
		productRepo.put(product.getId(), product);
	}

	@Override
	public void updateProduct(String id, Product product) {
		if (!productRepo.containsKey(id))
			throw new ProductNotfoundException();
		productRepo.remove(id);
		product.setId(id);
		productRepo.put(id, product);
	}

	@Override
	public void deleteProduct(String id) {
		productRepo.remove(id);

	}

	@Override
	public Collection<Product> getProducts() {
		return productRepo.values();
	}
	
	@Override
	public void createNewModel(String attr1, String attr2) {
		StringBuffer arrtibutes = new StringBuffer();
		arrtibutes = arrtibutes.append(attr1).append(",").append(attr2);
		runTimeTable.createNewModel(arrtibutes.toString());
	}
	
	@Override
	public void getRecords() {
		H2jdbcReadDemo.getRecords();
	}
}