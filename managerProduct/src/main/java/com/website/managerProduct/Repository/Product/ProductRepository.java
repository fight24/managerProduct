package com.website.managerProduct.Repository.Product;

import com.website.managerProduct.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository(value = "ProductRepository")
public interface ProductRepository extends JpaRepository<Product,Long> {
//    @Modifying
//    @Query(value = "ALTER TABLE wemeiopet.product AUTO_INCREMENT = 1;", nativeQuery = true)
//    void resetAutoIncrement();
     Product findByProductCode(String productCode);
}
