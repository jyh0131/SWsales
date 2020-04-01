package swsales.model;

import java.sql.Date;

public class DateSale {
	private int o_no;
	private String c_name;
	private String p_name;
	private int o_qty;
	private String o_dps;
	private Date o_date;
	private Date start_o_date;
	private Date end_o_date;

	public DateSale() {
		// TODO Auto-generated constructor stub
	}

	public DateSale(Date sDate, Date eDate) {
		this.start_o_date = sDate;
		this.end_o_date = eDate;
	}

	public DateSale(int o_no, String c_name, String p_name, int o_qty, String o_dps, Date o_date) {
		super();
		this.o_no = o_no;
		this.c_name = c_name;
		this.p_name = p_name;
		this.o_qty = o_qty;
		this.o_dps = o_dps;
		this.o_date = o_date;
	}

	public int getO_no() {
		return o_no;
	}

	public void setO_no(int o_no) {
		this.o_no = o_no;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public int getO_qty() {
		return o_qty;
	}

	public void setO_qty(int o_qty) {
		this.o_qty = o_qty;
	}

	public String getO_dps() {
		return o_dps;
	}

	public void setO_dps(String o_dps) {
		this.o_dps = o_dps;
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
		return "DateSale [o_no=" + o_no + ", c_name=" + c_name + ", p_name=" + p_name + ", o_qty=" + o_qty + ", o_dps="
				+ o_dps + ", o_date=" + o_date + "]";
	}

}
