package SNMFYM_futoverseny;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Race {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Egyedi azonosító

    private String name; // Verseny neve
    private int distance; // Verseny távolsága kilométerben
    private String identifier; // Egyedi azonosító, pl. VXX

    // Konstruktorok
    public Race() {
    }

    public Race(String name, int distance, String identifier) {
        this.name = name;
        this.distance = distance;
        this.identifier = identifier;
    }

    // Getterek és Setterek
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }
}
