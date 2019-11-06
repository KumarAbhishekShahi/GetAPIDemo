package com.example.demo.service.intf;

import java.util.Collection;
import com.example.demo.model.Product;

public interface ProductService {
   public abstract void createProduct(Product product);
   public abstract void updateProduct(String id, Product product);
   public abstract void deleteProduct(String id);
   public abstract Collection<Product> getProducts();
   public abstract void createNewModel(String attr1, String attr2);
   public abstract void getRecords();
}