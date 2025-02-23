package com.ht.controller;

import com.ht.model.UserDomain;
import com.ht.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by  ice
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @PostMapping("/add")
    public int addUser(@RequestBody UserDomain user){
        return userService.addUser(user);
    }

    @ResponseBody
    @GetMapping("/all")
    public Object findAllUser(
            @RequestParam(name = "pageNum", required = false, defaultValue = "1")
                    int pageNum,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10")
                    int pageSize){
        return userService.findAllUser(pageNum,pageSize);
    }
    @ResponseBody
    @PostMapping("/del")
    public int delUser(@RequestParam(name="userId")Integer userId){
        return userService.delUser(userId);
    }
    @ResponseBody
    @PutMapping("/update")
    public int updateUser(UserDomain user){
        return userService.updateUser(user);
    }
}
