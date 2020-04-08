package swsales.model;

import java.sql.Date;

public class CustomerOrder {
	private String c_name;
	private int p_price;
	private Date o_date;
	private Date start_o_date;
	private Date end_o_date;

	public CustomerOrder() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomerOrder(Date start_o_date, Date end_o_date) {
		super();
		this.start_o_date = start_o_date;
		this.end_o_date = end_o_date;
	}

	public CustomerOrder(String c_name, int p_price, Date o_date, Date start_o_date, Date end_o_date) {
		super();
		this.c_name = c_name;
		this.p_price = p_price;
		this.o_date = o_date;
		this.start_o_date = start_o_date;
		this.end_o_date = end_o_date;
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
		return "CustomerOrder [c_name=" + c_name + ", p_price=" + p_price + ", o_date=" + o_date + ", start_o_date="
				+ start_o_date + ", end_o_date=" + end_o_date + "]";
	}

}
