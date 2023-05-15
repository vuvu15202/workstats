package vpnt.si.work.stats.example.workstats.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vpnt.si.work.stats.example.workstats.model.MonthlyStats;

@Repository
public interface MonthlyStatsRepository extends JpaRepository<MonthlyStats, Integer> {

}
