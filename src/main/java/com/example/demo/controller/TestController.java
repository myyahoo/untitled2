package com.example.demo.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class TestController {

    @GetMapping("/board/list")
    public String hello(){

        return String.format("d %s","Ddddd");
    }

    @GetMapping("/aaa")
    public String xxx(){
        return "ddddd";
    }

    @GetMapping("/bbb")
    public ResponseEntity bbb(@RequestParam(value="name",required = false) String Name){
        System.out.println(Name);
        return ResponseEntity.status(HttpStatus.CREATED).body(Name);
        //return new ResponseEntity(Name,new HttpHeaders(),HttpStatus.valueOf(200));

    }

    @GetMapping("/ccc/{name}")
    public ResponseEntity ccc(@PathVariable("name") String name){

        return new ResponseEntity(name,new HttpHeaders(),HttpStatus.valueOf(200));
    }





}
