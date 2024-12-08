package SNMFYM_futoverseny;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RunnerRepository extends JpaRepository<Runner, Long> {

    // Nemek szerinti szűrés
    List<Runner> findByGender(String gender);

    // Adott életkor feletti futók
    List<Runner> findByAgeGreaterThan(int age);

    // Egyedi azonosító alapján keresés
    Runner findByIdentifier(String identifier);
}
