package swsales.model;

public class IQEvaluation {
	private String p_name;
	private String s_name;
	private int iq_qty;
	private int p_price;
	private int p_cost;
	private String evaluation;

	public IQEvaluation() {
		// TODO Auto-generated constructor stub
	}

	public IQEvaluation(String p_name) {
		super();
		this.p_name = p_name;
	}

	public IQEvaluation(String p_name, String s_name, int iq_qty, int p_price, int p_cost, String evaluation) {
		super();
		this.p_name = p_name;
		this.s_name = s_name;
		this.iq_qty = iq_qty;
		this.p_price = p_price;
		this.p_cost = p_cost;
		this.evaluation = evaluation;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public String getS_name() {
		return s_name;
	}

	public void setS_name(String s_name) {
		this.s_name = s_name;
	}

	public int getIq_qty() {
		return iq_qty;
	}

	public void setIq_qty(int iq_qty) {
		this.iq_qty = iq_qty;
	}

	public int getP_price() {
		return p_price;
	}

	public void setP_price(int p_price) {
		this.p_price = p_price;
	}

	public int getP_cost() {
		return p_cost;
	}

	public void setP_cost(int p_cost) {
		this.p_cost = p_cost;
	}

	public String getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(String evaluation) {
		this.evaluation = evaluation;
	}

	@Override
	public String toString() {
		return "IQEvaluation [p_name=" + p_name + ", s_name=" + s_name + ", iq_qty=" + iq_qty + ", p_price=" + p_price
				+ ", p_cost=" + p_cost + ", evaluation=" + evaluation + "]";
	}

}
