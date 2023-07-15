package com.website.managerProduct.Service.User;


import com.website.managerProduct.Entity.User;
import com.website.managerProduct.Repository.User.UserRepository;
import com.website.managerProduct.Security.EncodePass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserByIdUser(long id) {
        return userRepository.findById(id);
    }
    private final EncodePass encodePass = new EncodePass();
    @Override
    public void createUser(User user) {
        User userEncode = new User(user.getFirstName(),
                user.getLastName(), user.getEmail(),
                user.getPhone(),user.getUserName(),user.getPassword());
        userEncode.setPassword(encodePass.encodePassword().encode(userEncode.getPassword()));
        userRepository.save(userEncode);
    }

    @Override
    public boolean updateUser(long id, User user) {
        Optional<User> userData = userRepository.findById(id);
        if(userData.isPresent()){
            User userUpdate = userData.get();
            userUpdate.setFirstName(user.getFirstName());
            userUpdate.setLastName(user.getLastName());
            userUpdate.setEmail(user.getEmail());
            userUpdate.setPhone(user.getPhone());
            userUpdate.setUserName(user.getUserName());
            userUpdate.setPassword(user.getPassword());
            userRepository.save(userUpdate);
            return true;
        }else {
            return false;
        }

    }

    @Override
    public boolean deleteUserAll() {
        try{
            userRepository.deleteAll();
            return true;
        }catch (Exception e){
            return false;
        }

    }

    @Override
    public boolean deleteUserById(long id) {
        try{
            userRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }

    }
}
