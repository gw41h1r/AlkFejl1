package SNMFYM_futoverseny;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/results")
public class ResultController {

    private final ResultRepository resultRepository;
    private final RaceRepository raceRepository;
    private final RunnerRepository runnerRepository;

    public ResultController(ResultRepository resultRepository, RaceRepository raceRepository, RunnerRepository runnerRepository) {
        this.resultRepository = resultRepository;
        this.raceRepository = raceRepository;
        this.runnerRepository = runnerRepository;
    }

    // Add a new result
    @PostMapping("/addResult")
    public ResponseEntity<String> addResult(@RequestBody Result result) {
        if (!raceRepository.existsById(result.getRace().getId()) || !runnerRepository.existsById(result.getRunner().getId())) {
            return ResponseEntity.badRequest().body("Invalid race or runner ID.");
        }
        resultRepository.save(result);
        return ResponseEntity.ok("Result added successfully!");
    }

    // Get average time for a race
    @GetMapping("/getAverageTime/{raceId}")
    public double getAverageTime(@PathVariable Long raceId) {
        return resultRepository.findByRaceId(raceId)
                .stream()
                .mapToInt(Result::getTime)
                .average()
                .orElse(0.0);
    }
}
