package swsales.model;

public class Total {
	private int o_qty;
	private int p_price;
	private long total;

	public Total() {
	}

	public Total(long total) {
		this.total = total;
	}

	public Total(int o_qty, int p_price, long total) {
		super();
		this.o_qty = o_qty;
		this.p_price = p_price;
		this.total = total;
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

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return String.format("%,d 원", total);
	}

	

}
