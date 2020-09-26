package com.sda.javagda31.students.controller;

import com.sda.javagda31.students.component.Utilities;
import com.sda.javagda31.students.model.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api2")
public class PathRestIndexController {

    private final Utilities utilities;

    public PathRestIndexController(Utilities utilities) {
        this.utilities = utilities;
    }

    // PathVariable
    private static int[] array = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

    // http://localhost:8080/api/tablica/3
    // http://localhost:8080/student?studentId=3 => // http://localhost:8080/student/3
    @GetMapping("/tablica/{indeks}")
    public ResponseEntity<Object> zwrocZTablicy(@PathVariable(name = "indeks") int index) {
        if (index < 0 || index > array.length) {
//            return ResponseEntity.badRequest().build();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
//        return ResponseEntity.ok(array[index]);
        return ResponseEntity.status(HttpStatus.OK).body(array[index]);
    }

    // Wykorzystując PATH VARIABLE:
//1.  Stwórz endpoint pod adresem /add który pobiera dwa parametry i dodaje je do siebie, po czym zwraca wynik nie opakowany w APIResponse
    //    http://localhost:8080/api/add/100/50
    @GetMapping("/add/{w1}/{w2}")
    public double addTwoValues(@PathVariable(name = "w1") double wartosc1, @PathVariable(name = "w2") double wartosc2) {
        return wartosc1 + wartosc2;
    }


    @GetMapping("/sub/{w1}/{w2}")
    public ApiResponse subTwoValues(@PathVariable(name = "w1") double wartosc1, @PathVariable(name = "w2") double wartosc2) {
        return new ApiResponse("Wynik = " + (wartosc1 - wartosc2));
    }


    @GetMapping("/prime/{check}")
    public ApiResponse prime(@PathVariable(name = "check") int value) {
        return new ApiResponse(utilities.isPrime(value) ? "YES" : "NO");
    }


    @GetMapping("/sum/{tablica}")
    public double sum(@PathVariable(name = "tablica") List<Double> tablica) {
        return tablica.stream().mapToDouble(Double::doubleValue).sum();
    }

    // 4. Stwórz endpoint pod adresem /check który sprawdza czy pierwsza liczba jest większa od drugiej. Wynik zwróć opakowany w APIResponse
    @GetMapping("/check/{liczba1}/{liczba2}")
    public ApiResponse check(@PathVariable(name = "liczba1") int liczba1, @PathVariable(name = "liczba2") int liczba2) {
        if (liczba1 > liczba2) {
            return new ApiResponse("true");
        }
        return new ApiResponse("false");
    }

// 5. Stwórz endpoint pod adresem /compare ktory zwraca wieksza liczbe. Wynik zwróć nieopakowany.

    @GetMapping("/compare/{liczba1}/{liczba2}")
    public int compare(@PathVariable(name = "liczba1") int liczba1, @PathVariable(name = "liczba2") int liczba2) {
        if (liczba1 > liczba2) {
            return liczba1;
        }
        return liczba2;
    }

    // 6. Stworz endpoint pod adresem /div który dzieli liczby. Jeśli dzielnik = 0, to zwróć kod błędu 400 - bez ciała odpowiedzi
    @GetMapping("/div/{liczba1}/{liczba2}")
    public ResponseEntity<Object> div(@PathVariable(name = "liczba1") int liczba1, @PathVariable(name = "liczba2") int liczba2) {
        if (liczba1 / liczba2 == 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(liczba1 / liczba2);
    }

}
