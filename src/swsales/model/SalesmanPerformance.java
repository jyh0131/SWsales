package swsales.model;

import java.sql.Date;

public class SalesmanPerformance {
	private String e_name;
	private int o_eno;
	private double salesMoney;
	private Date start_o_date;
	private Date end_o_date;

	public SalesmanPerformance() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SalesmanPerformance(Date start_o_date, Date end_o_date) {
		super();
		this.start_o_date = start_o_date;
		this.end_o_date = end_o_date;
	}

	public SalesmanPerformance(String e_name, int o_eno, double salesMoney, Date start_o_date, Date end_o_date) {
		super();
		this.e_name = e_name;
		this.o_eno = o_eno;
		this.salesMoney = salesMoney;
		this.start_o_date = start_o_date;
		this.end_o_date = end_o_date;
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

	public double getSalesMoney() {
		return salesMoney;
	}

	public void setSalesMoney(double salesMoney) {
		this.salesMoney = salesMoney;
	}

	public Date getStart_o_date() {
		return start_o_date;
	}

	public void setStart_o_date(Date start_o_date) {
		this.start_o_date = start_o_date;
	}

	public Date getEnd_o_date() {
		return end_o_date;
	}

	public void setEnd_o_date(Date end_o_date) {
		this.end_o_date = end_o_date;
	}

	@Override
	public String toString() {
		return "SalesmanPerformance [e_name=" + e_name + ", o_eno=" + o_eno + ", salesMoney=" + salesMoney
				+ ", start_o_date=" + start_o_date + ", end_o_date=" + end_o_date + "]";
	}

}
