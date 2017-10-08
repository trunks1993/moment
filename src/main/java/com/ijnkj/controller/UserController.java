package com.ijnkj.controller;

import com.ijnkj.dao.domain.User;
import com.ijnkj.exception.ProductNotFoundException;
import com.ijnkj.service.UserService;
import com.ijnkj.util.ResponseBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/getUser/{id}")
    public ResponseBase<?> get(@PathVariable("id") String id) {

        ResponseBase<User> responseMessage = new ResponseBase<>();

         responseMessage.setData(userService.get(id));

         return  responseMessage;
    }

    @PutMapping("/updateUser/{id}")
    public ResponseBase<?> update(@PathVariable("id") String id, @RequestBody User newUser) {

        ResponseBase<String> responseMessage = new ResponseBase<>();

        User user = userService.get(id);

        if(user == null) throw new ProductNotFoundException(id);

        user.setOpenId(newUser.getOpenId());

        responseMessage.setData("success");

        userService.update(user);

        return responseMessage;
    }

    @PostMapping("/addUser")
    public ResponseBase<?> addUser(@RequestBody User newUser){

        ResponseBase<String> responseMessage = new ResponseBase<>();

        newUser.setCreateTime(String.valueOf(new Date().getTime()));

        int bool = userService.insert(newUser);

        if(bool !=0 ){
            return responseMessage.success("success");
        }else {
            return responseMessage.error("fail");
        }
    }

}
