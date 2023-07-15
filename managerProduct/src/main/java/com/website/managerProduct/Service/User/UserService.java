package com.website.managerProduct.Service.User;


import com.website.managerProduct.Entity.User;

import java.util.List;
import java.util.Optional;


public interface UserService {

    List<User> getAllUser();
    Optional<User> getUserByIdUser(long id);
    void createUser(User user);
    boolean updateUser(long id, User user);
    boolean deleteUserAll();
    boolean deleteUserById(long id);
}
