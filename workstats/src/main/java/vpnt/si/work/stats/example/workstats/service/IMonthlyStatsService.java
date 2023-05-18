package vpnt.si.work.stats.example.workstats.service;

import java.util.List;

import vpnt.si.work.stats.example.workstats.model.MonthlyStats;

public interface IMonthlyStatsService {
	List<MonthlyStats> listMonthlyStats();
	List<MonthlyStats> listMonthlyStatsSearch(String fullName, String email, String month, String year, String project);
	
}
