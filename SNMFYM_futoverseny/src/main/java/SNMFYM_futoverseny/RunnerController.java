package SNMFYM_futoverseny;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/runners")
public class RunnerController {

    private final RunnerRepository runnerRepository;

    public RunnerController(RunnerRepository runnerRepository) {
        this.runnerRepository = runnerRepository;
    }

    // Get all runners
    @GetMapping("/getRunners")
    public List<Runner> getRunners() {
        return runnerRepository.findAll();
    }

    // Add a new runner
    @PostMapping("/addRunner")
    public ResponseEntity<String> addRunner(@RequestBody Runner runner) {
        runnerRepository.save(runner);
        return ResponseEntity.ok("Runner added successfully!");
    }
}
