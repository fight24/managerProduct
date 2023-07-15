package com.website.managerProduct.Service.Product;

import com.website.managerProduct.Entity.Product;


import java.util.List;
import java.util.Optional;

public interface ProductService {
     List<Product> getAllProduct();
     Optional<Product> getProductByIdProduct(long id);
     void createProduct(Product product);
     boolean updateProduct(long id, Product product);
     boolean deleteProductAll();
     boolean deleteProductById(long id);

}
