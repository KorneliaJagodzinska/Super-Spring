package com.sda.javagda31.students.controller;

import com.sda.javagda31.students.model.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RestIndexController {

    @GetMapping("/")
    public ApiResponse index(){
        return new ApiResponse("Hello!");
    }
}
