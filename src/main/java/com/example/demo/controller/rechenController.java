package com.example.demo.controller;
import com.example.demo.model.History;
import com.example.demo.repositorys.historyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController //
public class rechenController {

    @Autowired
    private historyRepo historyRepo;
    History dieHistory  = new History();

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
                if (zahl2 == 0) return "Error";
                result = zahl1 / zahl2; break;
            default: return "Ungültiger Operator";
        }

        dieHistory.setCalculation(result);
        historyRepo.save(dieHistory);

        return String.valueOf(result);
    }
}