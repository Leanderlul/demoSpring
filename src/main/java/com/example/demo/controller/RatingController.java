package com.example.demo.controller;

import com.example.demo.model.Login;
import com.example.demo.repositorys.LoginRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.example.demo.model.Ratings;
import com.example.demo.repositorys.RatingRepo;
import org.springframework.stereotype.Controller;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@SpringBootApplication
@Controller
public class RatingController {

    @Autowired
    private RatingRepo ratingRepo;

    @Autowired
    private LoginRepo loginRepo;

    @GetMapping("/rating")
    public String showRatings(Model model) {
        model.addAttribute("ratings", ratingRepo.findAllByOrderByIdDesc());

        return "rating";
    }

    @PostMapping("/rating/submit")
    public String submitRating(@RequestParam int stars,
                               @RequestParam String description,
                               Principal principal) {

        // Benutzer anhand seines Usernames aus DB laden
        Login user = loginRepo.findByName(principal.getName()).orElse(null);

        if (user == null) {
            return "redirect:/login"; // Falls nicht gefunden
        }

        Ratings rating = new Ratings();
        rating.setStars(stars);
        rating.setDescription(description);
        rating.setLogin(user); // Login-Objekt setzen

        ratingRepo.save(rating);

        return "redirect:/rating";
    }
}



