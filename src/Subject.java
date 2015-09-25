
public class Subject {
	private String subjectID;
	private String subjectName;
	private int quota;
	private int currentEnrolment;
	
	/*************Contructor******/
	public Subject(){
		this.quota = 0;
	}

	public Subject(String subjectID, String subjectName, int quota,	int currentEnrolment) {
		this.subjectID = subjectID;
		this.subjectName = subjectName;
		this.quota = quota;
		this.currentEnrolment = currentEnrolment;
	}
	
	/*****Getter and setter*********/ 
	public String getSubjectID() {
		return subjectID;
	}

	public void setSubjectID(String subjectID) {
		this.subjectID = subjectID;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public int getQuota() {
		return quota;
	}

	public void setQuota(int quota) {
		this.quota = quota;
	}

	public int getCurrentEnrolment() {
		return currentEnrolment;
	}

	public void setCurrentEnrolment(int currentEnrolment) {
		this.currentEnrolment = currentEnrolment;
	}
	
	/*****Dang ky 1 sinh vien*****/
	public void enrolStudent(){
		System.out.print("Enrolling student… ");
		if (currentEnrolment < quota){ 
			currentEnrolment++;
			System.out.println("Student enrolled in " + subjectName);
		}
		else
			System.out.println("Quota reached, enrolment failed");
	}
	
	/****Huy dang ky 1 sinh vien****/
	public void unEnrolStudent(){
		System.out.print("Un-enrolling student… ");
		if (currentEnrolment <= 0) 
			System.out.println("No students to un-enrol");
		else{
			currentEnrolment--;
			System.out.println("Student un-enrolled from " + subjectName);
		}
	}
	
	/*******Hien thi thong tin***********/
	public void displaySubjectInfo(){
		System.out.println("Subject ID: " + subjectID);
		System.out.println("Subject name: " + subjectName);
		System.out.println("Quota: " + quota);
		System.out.println("Currently enrolled: " + currentEnrolment);
		int availablePlaces = quota - currentEnrolment;
		System.out.println("Can accept " + availablePlaces +" more students");
	}
}
