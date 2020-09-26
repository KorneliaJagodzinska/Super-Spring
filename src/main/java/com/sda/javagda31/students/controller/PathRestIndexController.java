package com.sda.javagda31.students.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api2")
public class PathRestIndexController {
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



}
