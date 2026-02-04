package com.student.controller;

import com.student.dao.entity.FruitEntity;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("fruits")
public class FruitController {
//    private final FruitRepository fruitRepository;
//    ArrayList<String> fruits = new ArrayList<>();
//
//    @PostMapping("/add-fruit")
//    public void addFruit(@RequestBody FruitEntity fruit){
//        fruitRepository.save(fruit);
//    }
//
//    @GetMapping("get")
//    public List<FruitEntity> getFruits(){
//        return fruitRepository.findAll();
//    }
//
//    @DeleteMapping("delete-fruit")
//    public void deleteFruit(Long id){
//        fruitRepository.deleteById(id);
//    }
}
