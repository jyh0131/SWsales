package swsales.model;

public class OrderRanking {
	private int orNo;
	private String orName;
	private int orMoney;
	

	public OrderRanking() {
		// TODO Auto-generated constructor stub
	}

	public OrderRanking(int orNo, String orName, int orMoney) {
		this.orNo = orNo;
		this.orName = orName;
		this.orMoney = orMoney;
	}

	public int getOrNo() {
		return orNo;
	}

	public void setOrNo(int orNo) {
		this.orNo = orNo;
	}

	public int getOrMoney() {
		return orMoney;
	}

	public void setOrMoney(int orMoney) {
		this.orMoney = orMoney;
	}

	public String getOrName() {
		return orName;
	}

	public void setOrName(String orName) {
		this.orName = orName;
	}

	@Override
	public String toString() {
		return String.format("OrderRanking [orNo=%s, orName=%s, orMoney=%s]", orNo, orName, orMoney);
	}

}
