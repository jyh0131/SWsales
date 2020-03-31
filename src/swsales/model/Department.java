package swsales.model;

public class Department {
	private int deptNo; // 1
	private String deptName; // 기획총무부
	private int floor; // 15

	public Department() {
	}

	public Department(int deptNo) {
		this.deptNo = deptNo;
	}

	public Department(String deptName) {
		this.deptName = deptName;
	}

	public Department(int deptNo, String deptName) {
		this.deptNo = deptNo;
		this.deptName = deptName;
	}

	public Department(String deptName, int floor) {
		this.deptName = deptName;
		this.floor = floor;
	}

	public Department(int deptNo, String deptName, int floor) {
		this.deptNo = deptNo;
		this.deptName = deptName;
		this.floor = floor;
	}

	public int getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	@Override
	public String toString() {
		// return "Department [deptNo=" + deptNo + ", deptName=" + deptName + ", floor="
		// + floor + "]";
		return String.format("%s %s %s", deptNo, deptName, floor);
	}

}
