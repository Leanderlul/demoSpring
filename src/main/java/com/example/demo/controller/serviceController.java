package com.example.demo.controller;
import org.springframework.stereotype.Controller;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@SpringBootApplication
@Controller
public class serviceController {



	    @GetMapping("/Rechner")
		public String zeigeRechnerSeite() {
			return "rechner"; //
		}


	@GetMapping("/")
	public String landingpage() {
		return "landingpage";
	}

	@PostMapping("/BMI")
	public String bmi(){
		return "bmi";
	}
}


