package swsales.model;

public class Supplier {
	private int sNo;
	private String sName;
	private String sBln;
	private String sAddress;
	private String sTel;
	private String sFax;

	public Supplier() {
		// TODO Auto-generated constructor stub
	}

	public Supplier(String sName, String sBln, String sTel) {
		this.sName = sName;
		this.sBln = sBln;
		this.sTel = sTel;
	}

	public Supplier(String sName) {
		this.sName = sName;
	}

	public Supplier(int sNo) {
		this.sNo = sNo;
	}
	
	public Supplier(int sNo, String sName) {
		this.sNo = sNo;
		this.sName = sName;
	}

	public Supplier(int sNo, String sName, String sBln, String sAddress, String sTel, String sFax) {
		this.sNo = sNo;
		this.sName = sName;
		this.sBln = sBln;
		this.sAddress = sAddress;
		this.sTel = sTel;
		this.sFax = sFax;
	}

	public int getsNo() {
		return sNo;
	}

	public void setsNo(int sNo) {
		this.sNo = sNo;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getsBln() {
		return sBln;
	}

	public void setsBln(String sBln) {
		this.sBln = sBln;
	}

	public String getsAddress() {
		return sAddress;
	}

	public void setsAddress(String sAddress) {
		this.sAddress = sAddress;
	}

	public String getsTel() {
		return sTel;
	}

	public void setsTel(String sTel) {
		this.sTel = sTel;
	}

	public String getsFax() {
		return sFax;
	}

	public void setsFax(String sFax) {
		this.sFax = sFax;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + sNo;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Supplier other = (Supplier) obj;
		if (sNo != other.sNo)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("Supplier [sNo=%s, sName=%s, sBln=%s, sAddress=%s, sTel=%s, sFax=%s]", sNo, sName, sBln,
				sAddress, sTel, sFax);
	}

}
