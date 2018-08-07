package pl.coderslab.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	private static final Path filePahts = Paths
			.get("/home/tj/workspace/SpringHomework_02/src/main/java/pl/coderslab/Workers.txt");

	@RequestMapping("/workers")
	public String workersAction(Model model) throws IOException {
		ArrayList<String> workerList = new ArrayList<>();
		Random r = new Random();
		for (String worker : Files.readAllLines(filePahts)) {
			String[] workerLine = worker.split(",");
			workerList.add(workerLine[1]);
		}
		String workerName = workerList.get(r.nextInt(workerList.size()));
		model.addAttribute("worker", workerName);
		return "workers";
	}

}
// #### Zadanie 4
//
// 1. Utwórz widok o nazwie `workers.jsp`.
// 2. W kontrolerze `HelloController` utwórz akcję `workersAction`, dostępną pod
// adresem `/workers`,
// która wyświetli ten widok.
// 3. Dodaj do projektu plik o nazwie `Workers.txt`.
// 4. Plik `Workers.txt` wypełnij listą pracowników (wpisz je samodzielnie):
// ```
// 01, Jan Kowalski
// 05, Jan Wiśniewski
// 10, Jan Marek
// 29, Jan Janecki
// 30, Jan Nowak
// ```
//
// 5. W metodzie kontrolera napisz kod który:
// * Wylosuje liczbę od 1 do 30.
// * Otworzy plik `Workers.txt` i znajdzie w nim osobę odpowiadającą wylosowanej
// liczbie.
// * Przekaże wylosowaną wartość do widoku, np `Jan Kowalski`
// 6. Wyświetl zawartość w widoku `workers.jsp`.
