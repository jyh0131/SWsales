package swsales.model;

public class EmployeeChart {
	private String e_name;
	private int o_eno;
	private int salesMoney;

	public EmployeeChart() {
		// TODO Auto-generated constructor stub
	}

	public EmployeeChart(String e_name, int o_eno, int salesMoney) {
		this.e_name = e_name;
		this.o_eno = o_eno;
		this.salesMoney = salesMoney;
	}

	public String getE_name() {
		return e_name;
	}

	public void setE_name(String e_name) {
		this.e_name = e_name;
	}

	public int getO_eno() {
		return o_eno;
	}

	public void setO_eno(int o_eno) {
		this.o_eno = o_eno;
	}

	public int getSalesMoney() {
		return salesMoney;
	}

	public void setSalesMoney(int salesMoney) {
		this.salesMoney = salesMoney;
	}

	@Override
	public String toString() {
		return String.format("EmployeeChart [e_name=%s, o_eno=%s, salesMoney=%s]", e_name, o_eno, salesMoney);
	}

}
