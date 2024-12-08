package SNMFYM_futoverseny;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ResultRepository extends JpaRepository<Result, Long> {

    // Adott verseny összes eredménye
    List<Result> findByRaceId(Long raceId);

    // Adott futó összes eredménye
    List<Result> findByRunnerId(Long runnerId);

    // Adott verseny eredményei idő szerint rendezve
    @Query("SELECT r FROM Result r WHERE r.race.id = :raceId ORDER BY r.time ASC")
    List<Result> findRaceResultsOrderedByTime(@Param("raceId") Long raceId);

    // Átlagos futási idő adott versenyre
    @Query("SELECT AVG(r.time) FROM Result r WHERE r.race.id = :raceId")
    Double findAverageTimeByRaceId(@Param("raceId") Long raceId);

    // Futók összesített eredménye egy versenyre
    @Query("SELECT r.runner.name, r.time FROM Result r WHERE r.race.id = :raceId ORDER BY r.time ASC")
    List<Object[]> findRunnerResultsByRaceId(@Param("raceId") Long raceId);

    // Legjobb eredmény egy adott futóhoz
    @Query("SELECT MIN(r.time) FROM Result r WHERE r.runner.id = :runnerId")
    Integer findBestTimeByRunnerId(@Param("runnerId") Long runnerId);

    // Futó versenyeinek száma
    @Query("SELECT COUNT(DISTINCT r.race.id) FROM Result r WHERE r.runner.id = :runnerId")
    Long countRacesByRunnerId(@Param("runnerId") Long runnerId);

    // Összesített eredmények időintervallum szerint
    @Query("SELECT r FROM Result r WHERE r.time BETWEEN :minTime AND :maxTime")
    List<Result> findResultsByTimeRange(@Param("minTime") Integer minTime, @Param("maxTime") Integer maxTime);

    public List<Result> findByRaceIdOrderByTimeAsc(Long id);
}
