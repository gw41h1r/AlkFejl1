package SNMFYM_futoverseny;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final RunnerRepository runnerRepository;
    private final RaceRepository raceRepository;
    private final ResultRepository resultRepository;

    public DataLoader(RunnerRepository runnerRepository, RaceRepository raceRepository, ResultRepository resultRepository) {
        this.runnerRepository = runnerRepository;
        this.raceRepository = raceRepository;
        this.resultRepository = resultRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Futók hozzáadása
        Runner runner1 = new Runner("János", 25, "férfi", "U0001");
        Runner runner2 = new Runner("Anna", 30, "nő", "U0002");
        Runner runner3 = new Runner("Péter", 20, "férfi", "U0003");
        Runner runner4 = new Runner("Kata", 22, "nő", "U0004");

        runnerRepository.save(runner1);
        runnerRepository.save(runner2);
        runnerRepository.save(runner3);
        runnerRepository.save(runner4);

        // Versenyek hozzáadása
        Race race1 = new Race("Tavaszi Futás", 10, "V01");
        Race race2 = new Race("Nyári Maraton", 42, "V02");

        raceRepository.save(race1);
        raceRepository.save(race2);

        // Eredmények hozzáadása
        Result result1 = new Result(runner1, race1, 50);
        Result result2 = new Result(runner2, race1, 55);
        Result result3 = new Result(runner3, race1, 48);
        Result result4 = new Result(runner4, race2, 180);

        resultRepository.save(result1);
        resultRepository.save(result2);
        resultRepository.save(result3);
        resultRepository.save(result4);
    }
}
