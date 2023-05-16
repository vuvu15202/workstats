package vpnt.si.work.stats.example.workstats.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import vpnt.si.work.stats.example.workstats.model.MonthlyStats;

@Repository
public interface MonthlyStatsRepository extends JpaRepository<MonthlyStats, Integer> {
	List<MonthlyStats> findByFullNameContainingIgnoreCase(String name);
	@Query(value = "SELECT * FROM Monthly_Stats WHERE full_name LIKE %:fullName% AND email LIKE %:email% AND month LIKE %:month% AND month LIKE %:year%", nativeQuery = true)
	List<MonthlyStats> searchByAll(@Param("fullName") String fullName, @Param("email") String email, @Param("month") String month, @Param("year") String year);
}
