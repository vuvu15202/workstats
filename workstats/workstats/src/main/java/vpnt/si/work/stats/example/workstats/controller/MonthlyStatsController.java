package vpnt.si.work.stats.example.workstats.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import vpnt.si.work.stats.example.workstats.convert.MonthlyStatsConverter;
import vpnt.si.work.stats.example.workstats.dto.MonthlyStatsDTO;
import vpnt.si.work.stats.example.workstats.model.MonthlyStats;
import vpnt.si.work.stats.example.workstats.model.WorkData;
import vpnt.si.work.stats.example.workstats.service.IMonthlyStatsService;

@RestController
@RequestMapping("/stats")
public class MonthlyStatsController {
	@Autowired 
	private IMonthlyStatsService iMonthlyStatsService;
	@Autowired 
	private MonthlyStatsConverter monthlyStatsConverter;
	
//	@GetMapping
//	public String listMonthlyStats(Model model) {
//		List<MonthlyStats> listMonthlyStats = iMonthlyStatsService.listMonthlyStats();
//		model.addAttribute("listMonthlyStats", listMonthlyStats);
//		
//		String json = "{ 'name':'John', 'email':'john.doe@gmail.com', 'age':29, 'phone':5168161922, 'city':'NewYork', 'hasCreditCard':false }";
//
//		Gson gson = new Gson();
//		WorkData data = gson.fromJson(json, WorkData.class);
//		
//		return "workstats";
//	}

	@GetMapping
	public ResponseEntity<List<MonthlyStatsDTO>> listMonthlyStats(Model model) {
		List<MonthlyStats> listMonthlyStats = iMonthlyStatsService.listMonthlyStats();
		model.addAttribute("listMonthlyStats", listMonthlyStats);
		List<MonthlyStatsDTO> listMonthlyStatsDTO = new ArrayList<>();
		for (MonthlyStats item : listMonthlyStats) {
			listMonthlyStatsDTO.add(monthlyStatsConverter.toDTO(item));
		}

		return new ResponseEntity<>(listMonthlyStatsDTO, HttpStatus.OK);
	}
	
	@GetMapping("/workdataa")
    public ResponseEntity<List<WorkData>> getWorkDataList() {
		String jsonData = "{\"SIQLSPCVC\":{\"originalEstimated\":1440,\"workLoggedInHours\":75600,\"donePoint\":1440,\"notDonePoint\":0,\"overDuePoint\":0,\"earlyDuePoint\":0,\"overPlanPoint\":0,\"reopenPoint\":0,\"fatalBug\":0,\"seriousBug\":0,\"mediumBug\":0,\"cosmeticBug\":0,\"fatalBugReport\":0,\"seriousBugReport\":0,\"mediumBugReport\":0,\"cosmeticBugReport\":0},\"ANPHUOC\":{\"originalEstimated\":403200,\"workLoggedInHours\":385200,\"donePoint\":403200,\"notDonePoint\":0,\"overDuePoint\":0,\"earlyDuePoint\":0,\"overPlanPoint\":0,\"reopenPoint\":0,\"fatalBug\":0,\"seriousBug\":0,\"mediumBug\":0,\"cosmeticBug\":0,\"fatalBugReport\":0,\"seriousBugReport\":0,\"mediumBugReport\":0,\"cosmeticBugReport\":0},\"ONEPLACE\":{\"originalEstimated\":61080,\"workLoggedInHours\":230400,\"donePoint\":60480,\"notDonePoint\":0,\"overDuePoint\":0,\"earlyDuePoint\":600,\"overPlanPoint\":0,\"reopenPoint\":0,\"fatalBug\":0,\"seriousBug\":0,\"mediumBug\":0,\"cosmeticBug\":0,\"fatalBugReport\":0,\"seriousBugReport\":0,\"mediumBugReport\":0,\"cosmeticBugReport\":0}}";

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
        return new ResponseEntity<>(workDataList, HttpStatus.OK);
    }
	
	
}
