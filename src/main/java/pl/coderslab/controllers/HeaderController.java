package pl.coderslab.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HeaderController {
	
	@GetMapping("/showUserAgent")
	
	public String showUserAgent(@RequestHeader("user-agent")String userAgent, Model model) {
		model.addAttribute("userAgent", userAgent);
		return "userAgent";
	}
	
	

}
//#### Zadanie 1
//
//1. Stwórz kontroler o nazwie `HeaderController`.
//2. Stwórz akcję dostępną pod adresem `/showUserAgent`
//3. Pobierz wartość nagłówka `userAgent`.
//4. Utwórz widok dla tej akcji o nazwie `userAgent.jsp`.
//5. Przekaż, a następnie wyświetl w widoku parametr.