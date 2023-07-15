package com.website.managerProduct.PresentationLayer;


import com.website.managerProduct.Entity.Product;
import com.website.managerProduct.Service.Product.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class RroductRestController {
    @Autowired
    ProductService productService;

    @GetMapping("/apiProduct")
    public ResponseEntity<List<Product>> getMethodAllProduct(){
        return (productService.getAllProduct().isEmpty())?new ResponseEntity<>(HttpStatus.NO_CONTENT)
                : new ResponseEntity<>(productService.getAllProduct(), HttpStatus.OK);
    }
    @GetMapping("/apiProduct/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") long id){
        return (productService.getProductByIdProduct(id).isPresent()) ? new ResponseEntity<>(
                productService.getProductByIdProduct(id).get()
                ,HttpStatus.OK): new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PostMapping("/apiProduct")
    public ResponseEntity<Product> createNewProduct(@RequestBody Product product){
        try{
            productService.createProduct(product);
            return new ResponseEntity<>( HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @PutMapping("/apiProduct/{id}")
    public ResponseEntity<Boolean> editProduct(@PathVariable("id") long id,@RequestBody Product product){
         try{
             if(productService.updateProduct(id,product)) {
                return new ResponseEntity<>(HttpStatus.OK);
             }
               else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
         } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @DeleteMapping("/apiProduct/{id}")
    public ResponseEntity<Boolean> deleteProductById(@PathVariable("id") long id){
        return (productService.deleteProductById(id)) ? new ResponseEntity<>(HttpStatus.NO_CONTENT):
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/apiProduct")
    public ResponseEntity<Boolean> deleteAllOfProduct(){
        return (productService.deleteProductAll()) ? new ResponseEntity<>(HttpStatus.NO_CONTENT):
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
