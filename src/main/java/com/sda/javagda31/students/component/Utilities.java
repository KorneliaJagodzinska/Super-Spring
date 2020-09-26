package com.sda.javagda31.students.component;

import org.springframework.stereotype.Component;

@Component
public class Utilities {
    public boolean isPrime(int value) {
        if (value < 2) {
            return false;
        }
        double limit = Math.sqrt(value);
        for (int i = 2; i <= limit; i++) {
            if (value % i == 0) {
                return false;
            }
        }
        return true;
    }
}
