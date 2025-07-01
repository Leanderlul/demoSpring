package com.example.demo.controller;
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

    @GetMapping("/rating")
    public String showRatings(Model model) {
        model.addAttribute("ratings", ratingRepo.findAllByOrderByIdDesc());

        return "rating";
    }

    @PostMapping("/rating/submit")
    public String submitRating(@RequestParam int stars,
                               @RequestParam String description,
                               Principal principal) {
        Ratings rating = new Ratings();
        rating.setName(principal.getName());
        rating.setStars(stars);
        rating.setDescription(description);
        ratingRepo.save(rating);
        return "redirect:/rating";
    }
}



