package com.website.managerProduct.PresentationLayer;

import com.website.managerProduct.Entity.User;
import com.website.managerProduct.Repository.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;


    @RequestMapping("/showRegister")
    public String showRegistrationPage(){
        return "login/registerUser";
    }
    @RequestMapping("/showLogin")
    public String showLoginPage(){
        return "login/login";
    }
    @RequestMapping(value = "register",method = RequestMethod.POST)
    public String register(@ModelAttribute("user") User user){
        userRepository.save(user);
        return "login/login";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(@RequestParam("userName") String userName, @RequestParam("password")String password,ModelMap map){
        User user = userRepository.findByUserName(userName);
        if(user!= null && user.getPassword().equals(password)){
            return "/findProduct";
        }else{
            map.addAttribute("msg","The password or User Name was wrong.  Please try  again ");
            return "login/login";
        }

    }


}
