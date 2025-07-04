package com.example.demo.controller;

import com.example.demo.model.History;
import com.example.demo.repositorys.HistoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HtmlController {

    @Autowired
    private HistoryRepo historyRepo;

    @GetMapping("/rechner")
    public String rechnerSeite(Model model) {
        List<History> verlauf = historyRepo.findTop10ByOrderByTimestampDesc(); // ggf. Methode ergänzen
        model.addAttribute("history", verlauf);
        return "rechner"; // Thymeleaf template rechner.html
    }
}
