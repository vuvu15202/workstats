package vpnt.si.work.stats.example.workstats.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vpnt.si.work.stats.example.workstats.model.MonthlyStats;
import vpnt.si.work.stats.example.workstats.repository.MonthlyStatsRepository;

@Service
public class MonthlyStatsService implements IMonthlyStatsService {
	@Autowired 
	private MonthlyStatsRepository monthlyStatsRepository;
	@Override
	public List<MonthlyStats> listMonthlyStats() {
		return monthlyStatsRepository.findAll();
	}
}
