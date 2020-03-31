package swsales.model;

public class Employee {
	private int empNo; // 1
	private String empName; // 현재승
	private Department dNo; // 1 -> 기획총무부
	private String empTitle; // 대표이사
	private int empManager; // 책임관리자(1) / 관리자(2)
	private String empId; // hceo1004
	private String empPass; // Jason1234!@
	private String empMail; // airplant@naver.com

	public Employee() {
	}

	public Employee(int empNo) {
		this.empNo = empNo;
	}
	
	public Employee(Department dNo) {
		this.dNo = dNo;
	}
	
	public Employee(String empId) {
		this.empId = empId;
	}
	
	public Employee(String empId, String empPass) {
		this.empId = empId;
		this.empPass = empPass;
	}

	public Employee(int empNo, String empName) {
		this.empNo = empNo;
		this.empName = empName;
	}
	
	public Employee(int empNo, Department dNo, String empTitle) {
		this.empNo = empNo;
		this.dNo = dNo;
		this.empTitle = empTitle;
	}
	
	public Employee(int empNo, String empName, String empId, String empMail) {
		this.empNo = empNo;
		this.empName = empName;
		this.empId = empId;
		this.empMail = empMail;
	}

	public Employee(int empNo, String empName, String empId, String empPass, String empMail) {
		this.empNo = empNo;
		this.empName = empName;
		this.empId = empId;
		this.empPass = empPass;
		this.empMail = empMail;
	}

	public Employee(int empNo, String empName, String empTitle, int empManager, String empMail) {
		this.empNo = empNo;
		this.empName = empName;
		this.empTitle = empTitle;
		this.empManager = empManager;
		this.empMail = empMail;
	}
	
	public Employee(String empName, Department dNo, String empTitle, int empManager, String empId, String empPass, String empMail) {
		this.empName = empName;
		this.dNo = dNo;
		this.empTitle = empTitle;
		this.empManager = empManager;
		this.empId = empId;
		this.empPass = empPass;
		this.empMail = empMail;
	}

	public Employee(int empNo, String empName, Department dNo, String empTitle, int empManager, String empId, String empPass, String empMail) {
		this.empNo = empNo;
		this.empName = empName;
		this.dNo = dNo;
		this.empTitle = empTitle;
		this.empManager = empManager;
		this.empId = empId;
		this.empPass = empPass;
		this.empMail = empMail;
	}

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Department getdNo() {
		return dNo;
	}

	public void setdNo(Department dNo) {
		this.dNo = dNo;
	}

	public String getEmpTitle() {
		return empTitle;
	}

	public void setEmpTitle(String empTitle) {
		this.empTitle = empTitle;
	}

	public int getEmpManager() {
		return empManager;
	}

	public void setEmpManager(int empManager) {
		this.empManager = empManager;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmpPass() {
		return empPass;
	}

	public void setEmpPass(String empPass) {
		this.empPass = empPass;
	}

	public String getEmpMail() {
		return empMail;
	}

	public void setEmpMail(String empMail) {
		this.empMail = empMail;
	}

	@Override
	public String toString() {
		return "Employee [empNo=" + empNo + ", empName=" + empName + ", dNo=" + dNo + ", empTitle=" + empTitle
				+ ", empManager=" + empManager + ", empId=" + empId + ", empPass=" + empPass + ", empMail=" + empMail
				+ "]";
	}

}
