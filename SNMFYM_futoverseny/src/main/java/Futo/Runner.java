package SNMFYM_futoverseny;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Runner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Egyedi azonosító

    private String name; // Futó neve
    private int age; // Futó életkora
    private String gender; // Futó neme
    private String identifier; // Egyedi azonosító, pl. UXXXX

    // Konstruktorok
    public Runner() {
    }

    public Runner(String name, int age, String gender, String identifier) {
        this.name = name;
        this.age = age;
        this.gender = gender;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }
}
