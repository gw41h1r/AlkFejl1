package SNMFYM_futoverseny;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/races") // Egyedi útvonal a RaceController számára
public class RaceController {

    private final RaceRepository raceRepository;
    private final ResultRepository resultRepository;

    public RaceController(RaceRepository raceRepository, ResultRepository resultRepository) {
        this.raceRepository = raceRepository;
        this.resultRepository = resultRepository;
    }

    @GetMapping
    public String listRaces(Model model) {
        List<Race> races = raceRepository.findAll();
        model.addAttribute("races", races);
        return "list-races"; // Thymeleaf sablon neve
    }

    @GetMapping("/add")
    public String showAddRaceForm() {
        return "add-race"; // Thymeleaf sablon neve
    }

    @PostMapping("/add")
    public String addRace(@RequestParam String name, @RequestParam int distance) {
        Race race = new Race(name, distance, null); // Identifier automatikusan generálódhat
        raceRepository.save(race);
        return "redirect:/races"; // A versenyek listázó oldalára irányít
    }

    @GetMapping("/{id}")
    public String raceDetails(@PathVariable Long id, Model model) {
        Race race = raceRepository.findById(id).orElseThrow(() -> new RuntimeException("Race not found"));
        List<Result> results = resultRepository.findByRaceIdOrderByTimeAsc(id);
        model.addAttribute("race", race);
        model.addAttribute("results", results);
        return "race-details"; // Thymeleaf sablon neve
    }
}
