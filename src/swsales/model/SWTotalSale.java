package swsales.model;

public class SWTotalSale {
	private String o_date;
	private String cate_name;
	private String p_name;
	private int o_qty;
	private int salesAmount;

	public SWTotalSale() {
		// TODO Auto-generated constructor stub
	}

	public SWTotalSale(String p_name) {
		super();
		this.p_name = p_name;
	}

	public SWTotalSale(String o_date, String cate_name, String p_name, int o_qty, int salesAmount) {
		super();
		this.o_date = o_date;
		this.cate_name = cate_name;
		this.p_name = p_name;
		this.o_qty = o_qty;
		this.salesAmount = salesAmount;
	}

	public String getO_date() {
		return o_date;
	}

	public void setO_date(String o_date) {
		this.o_date = o_date;
	}

	public String getCate_name() {
		return cate_name;
	}

	public void setCate_name(String cate_name) {
		this.cate_name = cate_name;
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

	public int getSalesAmount() {
		return salesAmount;
	}

	public void setSalesAmount(int salesAmount) {
		this.salesAmount = salesAmount;
	}

	@Override
	public String toString() {
		return "SWTotalSale [o_date=" + o_date + ", cate_name=" + cate_name + ", p_name=" + p_name + ", o_qty=" + o_qty
				+ ", salesAmount=" + salesAmount + "]";
	}

}
