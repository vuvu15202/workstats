package vpnt.si.work.stats.example.workstats.dto;

import java.util.List;

import jakarta.persistence.Column;
import vpnt.si.work.stats.example.workstats.model.WorkData;

public class MonthlyStatsDTO {

	private int id;
	private String month;
	private List<WorkData> workData;
	private String userId;
	private String fullName;
	private String email;
	public MonthlyStatsDTO(int id, String month, List<WorkData> workData, String userId, String fullName,
			String email) {
		super();
		this.id = id;
		this.month = month;
		this.workData = workData;
		this.userId = userId;
		this.fullName = fullName;
		this.email = email;
	}
	public MonthlyStatsDTO() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public List<WorkData> getWorkData() {
		return workData;
	}
	public void setWorkData(List<WorkData> workData) {
		this.workData = workData;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
	
}
