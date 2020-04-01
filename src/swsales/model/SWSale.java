package swsales.model;

public class SWSale {
	private String p_name;
	private String cate_name;
	private String s_name;
	private int supplyAmount;
	private int salesAmount;
	private int discount;
	private int salesProfit;

	public SWSale() {
		// TODO Auto-generated constructor stub
	}

	public SWSale(String p_name) {
		super();
		this.p_name = p_name;
	}

	public SWSale(String p_name, String cate_name, String s_name, int supplyAmount, int salesAmount, int discount,
			int salesProfit) {
		super();
		this.p_name = p_name;
		this.cate_name = cate_name;
		this.s_name = s_name;
		this.supplyAmount = supplyAmount;
		this.salesAmount = salesAmount;
		this.discount = discount;
		this.salesProfit = salesProfit;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public String getCate_name() {
		return cate_name;
	}

	public void setCate_name(String cate_name) {
		this.cate_name = cate_name;
	}

	public String getS_name() {
		return s_name;
	}

	public void setS_name(String s_name) {
		this.s_name = s_name;
	}

	public int getSupplyAmount() {
		return supplyAmount;
	}

	public void setSupplyAmount(int supplyAmount) {
		this.supplyAmount = supplyAmount;
	}

	public int getSalesAmount() {
		return salesAmount;
	}

	public void setSalesAmount(int salesAmount) {
		this.salesAmount = salesAmount;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public int getSalesProfit() {
		return salesProfit;
	}

	public void setSalesProfit(int salesProfit) {
		this.salesProfit = salesProfit;
	}

	@Override
	public String toString() {
		return "SWSale [p_name=" + p_name + ", cate_name=" + cate_name + ", s_name=" + s_name + ", supplyAmount="
				+ supplyAmount + ", salesAmount=" + salesAmount + ", discount=" + discount + ", salesProfit="
				+ salesProfit + "]";
	}

}
