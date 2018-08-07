package pl.coderslab.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RedirectController {
	@RequestMapping("/first")
	public String first() {
		return "first";
	}

	@RequestMapping("/second")
	public String second() {
		return "redirect: third";
	}

	@RequestMapping("/third")
	public String third() {
		return "third";
	}

}
// #### Zadanie 2
//
// 1. Stwórz kontroler o nazwie `RedirectController`.
// 2. Utwórz akcję dostępną pod adresem `/first`. Akcja ma ma wyświetlać widok
// `first.jsp`.
// 3. Utwórz akcję dostępną pod adresem `/third`. Akcja ma ma wyświetlać widok
// `third.jsp`.
// 4. W widoku `first.jsp` utwórz link do akcji dostępnej pod adresem `/second`,
// akcja ma przekierowywać do akcji dostępnej pod adresem `/third`