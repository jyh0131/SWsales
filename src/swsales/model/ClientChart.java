package swsales.model;

import java.sql.Date;

public class ClientChart {
	private String c_name;
	private int p_price;
	private Date o_date;

	public ClientChart() {
		// TODO Auto-generated constructor stub
	}

	public ClientChart(Date o_date) {
		this.o_date = o_date;
	}

	public ClientChart(String c_name, int p_price) {
		this.c_name = c_name;
		this.p_price = p_price;
	}

	public ClientChart(String c_name, int p_price, Date o_date) {
		this.c_name = c_name;
		this.p_price = p_price;
		this.o_date = o_date;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public int getP_price() {
		return p_price;
	}

	public void setP_price(int p_price) {
		this.p_price = p_price;
	}

	public Date getO_date() {
		return o_date;
	}

	public void setO_date(Date o_date) {
		this.o_date = o_date;
	}

	@Override
	public String toString() {
		return String.format("ClientOrder [c_name=%s, p_price=%s, o_date=%s]", c_name, p_price, o_date);
	}

}
