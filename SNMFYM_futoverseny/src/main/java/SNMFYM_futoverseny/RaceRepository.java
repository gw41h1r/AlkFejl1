package SNMFYM_futoverseny;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RaceRepository extends JpaRepository<Race, Long> {

    // Név alapján keresés
    List<Race> findByName(String name);

    // Adott távolság feletti versenyek
    List<Race> findByDistanceGreaterThan(int distance);

    // Egyedi azonosító alapján keresés
    Race findByIdentifier(String identifier);
}
