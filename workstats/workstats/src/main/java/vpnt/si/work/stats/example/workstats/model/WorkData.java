package vpnt.si.work.stats.example.workstats.model;

public class WorkData {
	private String projectName;
	private int originalEstimated;
	private int workLoggedInHours;
	private int donePoint;
	private int notDonePoint;
	private int overDuePoint;
	private int earlyDuePoint;
	private int overPlanPoint;
	private int reopenPoint;
	private int fatalBug;
	private int seriousBug;
	private int mediumBug;
	private int cosmeticBug;
	private int fatalBugReport;
	private int seriousBugReport;
	private int mediumBugReport;
	private int cosmeticBugReport;
	
	public WorkData() {
		// TODO Auto-generated constructor stub
	}

	public WorkData(String projectName, int originalEstimated, int workLoggedInHours, int donePoint, int notDonePoint, int overDuePoint,
			int earlyDuePoint, int overPlanPoint, int reopenPoint, int fatalBug, int seriousBug, int mediumBug,
			int cosmeticBug, int fatalBugReport, int seriousBugReport, int mediumBugReport, int cosmeticBugReport) {
		super();
		this.projectName = projectName;
		this.originalEstimated = originalEstimated;
		this.workLoggedInHours = workLoggedInHours;
		this.donePoint = donePoint;
		this.notDonePoint = notDonePoint;
		this.overDuePoint = overDuePoint;
		this.earlyDuePoint = earlyDuePoint;
		this.overPlanPoint = overPlanPoint;
		this.reopenPoint = reopenPoint;
		this.fatalBug = fatalBug;
		this.seriousBug = seriousBug;
		this.mediumBug = mediumBug;
		this.cosmeticBug = cosmeticBug;
		this.fatalBugReport = fatalBugReport;
		this.seriousBugReport = seriousBugReport;
		this.mediumBugReport = mediumBugReport;
		this.cosmeticBugReport = cosmeticBugReport;
	}
	

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public int getOriginalEstimated() {
		return originalEstimated;
	}

	public void setOriginalEstimated(int originalEstimated) {
		this.originalEstimated = originalEstimated;
	}

	public int getWorkLoggedInHours() {
		return workLoggedInHours;
	}

	public void setWorkLoggedInHours(int workLoggedInHours) {
		this.workLoggedInHours = workLoggedInHours;
	}

	public int getDonePoint() {
		return donePoint;
	}

	public void setDonePoint(int donePoint) {
		this.donePoint = donePoint;
	}

	public int getNotDonePoint() {
		return notDonePoint;
	}

	public void setNotDonePoint(int notDonePoint) {
		this.notDonePoint = notDonePoint;
	}

	public int getOverDuePoint() {
		return overDuePoint;
	}

	public void setOverDuePoint(int overDuePoint) {
		this.overDuePoint = overDuePoint;
	}

	public int getEarlyDuePoint() {
		return earlyDuePoint;
	}

	public void setEarlyDuePoint(int earlyDuePoint) {
		this.earlyDuePoint = earlyDuePoint;
	}

	public int getOverPlanPoint() {
		return overPlanPoint;
	}

	public void setOverPlanPoint(int overPlanPoint) {
		this.overPlanPoint = overPlanPoint;
	}

	public int getReopenPoint() {
		return reopenPoint;
	}

	public void setReopenPoint(int reopenPoint) {
		this.reopenPoint = reopenPoint;
	}

	public int getFatalBug() {
		return fatalBug;
	}

	public void setFatalBug(int fatalBug) {
		this.fatalBug = fatalBug;
	}

	public int getSeriousBug() {
		return seriousBug;
	}

	public void setSeriousBug(int seriousBug) {
		this.seriousBug = seriousBug;
	}

	public int getMediumBug() {
		return mediumBug;
	}

	public void setMediumBug(int mediumBug) {
		this.mediumBug = mediumBug;
	}

	public int getCosmeticBug() {
		return cosmeticBug;
	}

	public void setCosmeticBug(int cosmeticBug) {
		this.cosmeticBug = cosmeticBug;
	}

	public int getFatalBugReport() {
		return fatalBugReport;
	}

	public void setFatalBugReport(int fatalBugReport) {
		this.fatalBugReport = fatalBugReport;
	}

	public int getSeriousBugReport() {
		return seriousBugReport;
	}

	public void setSeriousBugReport(int seriousBugReport) {
		this.seriousBugReport = seriousBugReport;
	}

	public int getMediumBugReport() {
		return mediumBugReport;
	}

	public void setMediumBugReport(int mediumBugReport) {
		this.mediumBugReport = mediumBugReport;
	}

	public int getCosmeticBugReport() {
		return cosmeticBugReport;
	}

	public void setCosmeticBugReport(int cosmeticBugReport) {
		this.cosmeticBugReport = cosmeticBugReport;
	}
	
	
}
