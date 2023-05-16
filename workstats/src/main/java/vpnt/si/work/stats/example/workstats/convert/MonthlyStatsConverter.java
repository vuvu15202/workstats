package vpnt.si.work.stats.example.workstats.convert;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import vpnt.si.work.stats.example.workstats.dto.MonthlyStatsDTO;
import vpnt.si.work.stats.example.workstats.model.MonthlyStats;
import vpnt.si.work.stats.example.workstats.model.WorkData;

@Component
public class MonthlyStatsConverter {

	public MonthlyStatsDTO toDTO(MonthlyStats entity) {
		MonthlyStatsDTO dto = new MonthlyStatsDTO();
		dto.setId(entity.getId());
		dto.setFullName(entity.getFullName());
		dto.setEmail(entity.getEmail());
		dto.setMonth(entity.getMonth());
		dto.setUserId(entity.getUserId());
		dto.setWorkData(convertJson(entity.getWorkData()));
		return dto;
	}
	
	public List<WorkData> convertJson(String jsonData) {

        List<WorkData> workDataList = new ArrayList<WorkData>();
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, Map<String, Integer>> projectDataMap = objectMapper.readValue(jsonData, Map.class);
            for (String projectName : projectDataMap.keySet()) {
                Map<String, Integer> projectData = projectDataMap.get(projectName);
                WorkData workData = new WorkData(projectName, 
                		projectData.get("originalEstimated"), projectData.get("workLoggedInHours"), 
                		projectData.get("donePoint"), projectData.get("notDonePoint"), projectData.get("overDuePoint"),
                		projectData.get("earlyDuePoint"), projectData.get("overPlanPoint"), projectData.get("reopenPoint"), 
                		projectData.get("fatalBug"), projectData.get("seriousBug"), projectData.get("mediumBug"), 
                		projectData.get("cosmeticBug"), projectData.get("fatalBugReport"), projectData.get("seriousBugReport"), 
                		projectData.get("mediumBugReport"), projectData.get("cosmeticBugReport"));
                workDataList.add(workData);
            }
        } catch (Exception e) {
            // handle exception
        }
        return workDataList;
    }
}
