package com.website.managerProduct.Service.Product;

import com.website.managerProduct.Entity.Product;
import com.website.managerProduct.Repository.Product.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductRepository productRepository;
    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> getProductByIdProduct(long id) {

        return productRepository.findById(id);
    }

    @Override
    public void createProduct(Product product) {
        productRepository.save(new Product(product.getProductCode(), product.isStatus()));
    }

    @Override
    public boolean updateProduct(long id, Product product) {
        Optional<Product> productData = productRepository.findById(id);
        if(productData.isPresent()){
            Product productUpdate = productData.get();
            productUpdate.setProductCode(product.getProductCode());
            productUpdate.setStatus(product.isStatus());
            return true;
        }else{
            return false;
        }

    }

    @Override
    public boolean deleteProductAll() {
        try {
            productRepository.deleteAll();
//            productRepository.resetAutoIncrement();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean deleteProductById(long id) {
        try {
            productRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

}
