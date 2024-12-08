package SNMFYM_futoverseny;


import jakarta.persistence.*;

// Result entitás az adatbázisban tárolt eredményekhez
@Entity
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Egyedi azonosító

    @ManyToOne
    @JoinColumn(name = "runner_id", nullable = false) // Kapcsolat a Runner osztállyal
    private Runner runner; // Futó, akihez az eredmény tartozik

    @ManyToOne
    @JoinColumn(name = "race_id", nullable = false) // Kapcsolat a Race osztállyal
    private Race race; // Verseny, amelyhez az eredmény tartozik

    private int time; // Időeredmény percben

    // Alapértelmezett konstruktor (kötelező JPA esetén)
    public Result() {
    }

    // Paraméteres konstruktor
    public Result(Runner runner, Race race, int time) {
        this.runner = runner;
        this.race = race;
        this.time = time;
    }

    // Getterek és Setterek
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Runner getRunner() {
        return runner;
    }

    public void setRunner(Runner runner) {
        this.runner = runner;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
