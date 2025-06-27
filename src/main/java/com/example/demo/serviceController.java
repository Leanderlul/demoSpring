package com.example.demo;
import org.springframework.ui.Model;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Controller;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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


