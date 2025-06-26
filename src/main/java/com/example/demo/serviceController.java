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

	@PostMapping("/Rechner")
	public String rechner(){
		return "rechner";
	}

	@GetMapping("/")
	public String landingpage() {
		return "landingpage";
	}
}

	//@PostMapping("/hello")
	//public String hello(Model model,
	//					@RequestParam(value = "zahl1") int zahl1,
	//					@RequestParam(value = "zahl2") int zahl2,
	//					@RequestParam(value = "rechenzeichen") String rechenzeichen) {
	//	double ergebnis;
//
	//	switch (rechenzeichen) {
	//		case "+":
	//			ergebnis = zahl1 + zahl2;
	//			break;
	//		case "-":
	//			ergebnis = zahl1 - zahl2;
	//			break;
	//		case "*":
	//			ergebnis = zahl1 * zahl2;
	//			break;
	//		case "/":
	//			ergebnis = (zahl2 != 0) ? zahl1 / zahl2 : Double.NaN;
	//			break;
	//		default:
	//			ergebnis = Double.NaN;
	//	}
//
	//	if (rechenzeichen.equals("/") && zahl2 == 0) {
	//		model.addAttribute("fehler", "Division durch 0 ist nicht erlaubt.");
	//		return "hello";
	//	}
	//	model.addAttribute("ergebnis", ergebnis);
//
	//	return "hello";
	//}
