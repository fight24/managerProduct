package com.website.managerProduct.Repository.User;

import com.website.managerProduct.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "UserRepository")
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserName(String userName);
}
