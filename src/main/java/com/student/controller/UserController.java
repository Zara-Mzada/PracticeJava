package com.student.controller;

import com.student.dao.entity.UserEntity;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("user")
public class UserController {
    Map<Long, UserEntity> userMap = new HashMap<>();
    private final AtomicLong keyGenerator = new AtomicLong(1);

    @PostMapping("add")
    public void addUser(@RequestBody UserEntity user){
       userMap.put(user.getId(), user);
    }


    @PostMapping("add/bulk")
    public void addListUser(@RequestBody List<UserEntity> users){
        for(UserEntity user : users){
            long key = keyGenerator.getAndIncrement();
            userMap.put(key, user);
        };
    }

    @GetMapping("get")
    public Map<Long, UserEntity> getUsers(){
        return userMap;
    }

    @DeleteMapping("delete")
    public void deleteUser(Long id){
        Long user =userMap.entrySet()
                .stream()
                .filter(u->u.getValue().getId().equals(id))
//                .map(Map.Entry::getKey)
                .findFirst().get().getKey();

        userMap.remove(user);
    }

}
