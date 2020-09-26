package com.sda.javagda31.students.controller;

import com.sda.javagda31.students.component.Utilities;
import com.sda.javagda31.students.model.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RestIndexController {

    private final Utilities utilities;

    public RestIndexController(Utilities utilities) {
        this.utilities = utilities;
    }

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
    public int addTwoValues(@RequestParam(name = "liczba1") int liczba1, @RequestParam(name = "liczba2") int liczba2) {
        return liczba1 + liczba2;
    }

    //2.  Stwórz endpoint pod adresem /sub który pobiera dwa parametry i odejmuje ich wartości od siebie, po czym zwraca wynik opakowany w APIResponse
// http://localhost:8080/api/sub?w1=100&w2=50
    @GetMapping("/sub")
    public ApiResponse subTwoValues(@RequestParam(name = "w1") double wartosc1, @RequestParam(name = "w2") double wartosc2) {
        return new ApiResponse("Wynik = " + (wartosc1 - wartosc2));
    }

    // 3. Stwórz endpoint pod adresem /prime który sprawdza czy liczba jest pierwsza i w odpowiedzi zwraca "Yes" lub "No" wewenątrz APIResponse.
    //http://localhost:8080/api/prime?check=7
    @GetMapping("/prime")
    public ApiResponse prime(@RequestParam(name = "check") int value) {
        return new ApiResponse(utilities.isPrime(value) ? "YES" : "NO");
    }

    //4.Funkcja do sumowania wartości
    //http:localhost:8080/api/sum?tablica=3.0,4.0,5.0
    @GetMapping("/sum")
    public double sum(@RequestParam(name="tablica") List<Double> tablica){
        return tablica.stream().mapToDouble(Double::doubleValue).sum();
    }
}
