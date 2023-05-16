package vpnt.si.work.stats.example.workstats.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class MonthlyStats {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="month")
	private String month;
	@Column(name="work_data")
	private String workData;
	@Column(name="user_id")
	private String userId;
	@Column(name="full_name")
	private String fullName;
	@Column(name="email")
	private String email;

	public MonthlyStats() {
		// TODO Auto-generated constructor stub
	}

	public MonthlyStats(int id, String month, String workData, String userId, String fullName, String email) {
		super();
		this.id = id;
		this.month = month;
		this.workData = workData;
		this.userId = userId;
		this.fullName = fullName;
		this.email = email;
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

	public String getWorkData() {
		return workData;
	}

	public void setWorkData(String workData) {
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
