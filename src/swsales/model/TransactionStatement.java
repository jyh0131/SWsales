package swsales.model;

import java.sql.Date;

public class TransactionStatement {
	private String s_name;
	private Date o_date;
	private String c_name;
	private String p_name;
	private int o_qty;
	private int p_price;
	private int salesAmount;
	private int tax;
	private int TotalDA;

	public TransactionStatement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TransactionStatement(String p_name) {
		super();
		this.p_name = p_name;
	}

	public TransactionStatement(String s_name, Date o_date, String c_name, String p_name, int o_qty, int p_price,
			int salesAmount, int tax, int totalDA) {
		super();
		this.s_name = s_name;
		this.o_date = o_date;
		this.c_name = c_name;
		this.p_name = p_name;
		this.o_qty = o_qty;
		this.p_price = p_price;
		this.salesAmount = salesAmount;
		this.tax = tax;
		this.TotalDA = totalDA;
	}

	public String getS_name() {
		return s_name;
	}

	public void setS_name(String s_name) {
		this.s_name = s_name;
	}

	public Date getO_date() {
		return o_date;
	}

	public void setO_date(Date o_date) {
		this.o_date = o_date;
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

	public int getP_price() {
		return p_price;
	}

	public void setP_price(int p_price) {
		this.p_price = p_price;
	}

	public int getSalesAmount() {
		return salesAmount;
	}

	public void setSalesAmount(int salesAmount) {
		this.salesAmount = salesAmount;
	}

	public int getTax() {
		return tax;
	}

	public void setTax(int tax) {
		this.tax = tax;
	}

	public int getTotalDA() {
		return TotalDA;
	}

	public void setTotalDA(int totalDA) {
		this.TotalDA = totalDA;
	}

	@Override
	public String toString() {
		return "TransactionStatement [s_name=" + s_name + ", o_date=" + o_date + ", c_name=" + c_name + ", p_name="
				+ p_name + ", o_qty=" + o_qty + ", p_price=" + p_price + ", salesAmount=" + salesAmount + ", tax=" + tax
				+ ", TotalDA=" + TotalDA + "]";
	}

}
