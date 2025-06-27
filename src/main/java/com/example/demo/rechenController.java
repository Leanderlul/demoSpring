package com.example.demo;
import org.springframework.ui.Model;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Controller;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController //
public class rechenController {

    @PostMapping("/Rechner")
    public String rechne(
            @RequestParam String previousInput,
            @RequestParam String currentInput,
            @RequestParam String op) {

        double zahl1 = Integer.parseInt(previousInput);
        double zahl2 = Integer.parseInt(currentInput);

        double result;

        switch (op) {
            case "+": result = zahl1+zahl2; break;
            case "-": result = zahl1-zahl2; break;
            case "*": result = zahl1*zahl2; break;
            case "/":
                if (zahl2 == 0) return "Fehler: Division durch 0";
                result = zahl1 / zahl2; break;
            default: return "Ungültiger Operator";
        }

        return String.valueOf(result);
    }
}