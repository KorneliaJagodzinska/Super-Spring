package com.sda.javagda31.students.controller;

import com.sda.javagda31.students.model.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RestIndexController {

    @GetMapping("/")
    public ApiResponse index() {
        return new ApiResponse("Hello!");
    }

    @GetMapping("/welcome")
    public ApiResponse welcome(@RequestParam(name = "imieTwe") String imie) {
        return new ApiResponse("Welcome" + imie + "!");
    }
    //1.  Stwórz endpoint pod adresem /add który pobiera dwa parametry i dodaje je do siebie, po czym zwraca wynik nie opakowany w APIResponse
    //    http://localhost:8080/api/add?liczba1=100&liczba2=50
    @GetMapping("/add")
    public int addTwoValues(@RequestParam(name= "liczba1") int liczba1, @RequestParam(name="liczba2") int liczba2){
        return liczba1+liczba2;
    }

    //2.  Stwórz endpoint pod adresem /sub który pobiera dwa parametry i odejmuje ich wartości od siebie, po czym zwraca wynik opakowany w APIResponse
// http://localhost:8080/api/sub?w1=100&w2=50
    @GetMapping("/sub")
    public ApiResponse subTwoValues(@RequestParam(name = "w1") double wartosc1, @RequestParam(name = "w2") double wartosc2) {
        return new ApiResponse("Wynik = " + (wartosc1 - wartosc2));
    }
}
