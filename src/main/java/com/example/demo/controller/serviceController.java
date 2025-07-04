package com.example.demo.controller;
import org.springframework.stereotype.Controller;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@SpringBootApplication
@Controller
public class serviceController {

	@GetMapping({"/", "/home"})
	public String landingpage() {
		return "landingpage";
	}

	@GetMapping("/bmi")
	public String bmi(){
		return "bmi";
	}

	@GetMapping("/map")
	public String map(){
		return "map";
	}

}


