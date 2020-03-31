package swsales.model;



public class MajorClient {
	private Client cName;
	private int totalMoney;

	public MajorClient() {
		// TODO Auto-generated constructor stub
	}

	public MajorClient(Client cName, int totalMoney) {
		this.cName = cName;
		this.totalMoney = totalMoney;
	}

	public Client getcName() {
		return cName;
	}

	public void setcName(Client cName) {
		this.cName = cName;
	}

	public int getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(int totalMoney) {
		this.totalMoney = totalMoney;
	}

	@Override
	public String toString() {
		return String.format("MajorClient [cName=%s, totalMoney=%s]", cName, totalMoney);
	}

}
