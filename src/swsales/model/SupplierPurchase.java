package swsales.model;

import java.util.Date;

public class SupplierPurchase {
	private int spNo;
	private Product spPno;
	private Product spPname;
	private Supplier spSname;
	private Product spPcost;
	private int spQty;
	private Date spDate;

	public SupplierPurchase() {
		// TODO Auto-generated constructor stub
	}

	public SupplierPurchase(int spNo) {
		this.spNo = spNo;
	}

	public SupplierPurchase(int spNo, Product spPno, int spQty, Date spDate) {
		this.spNo = spNo;
		this.spPno = spPno;
		this.spQty = spQty;
		this.spDate = spDate;
	}

	public SupplierPurchase(int spNo, Product spPname, Supplier spSname, Product spPcost, int spQty, Date spDate) {
		this.spNo = spNo;
		this.spPname = spPname;
		this.spSname = spSname;
		this.spPcost = spPcost;
		this.spQty = spQty;
		this.spDate = spDate;
	}

	public SupplierPurchase(int spNo, Product spPno, Product spPname, Supplier spSname, Product spPcost, int spQty,
			Date spDate) {
		this.spNo = spNo;
		this.spPno = spPno;
		this.spPname = spPname;
		this.spSname = spSname;
		this.spPcost = spPcost;
		this.spQty = spQty;
		this.spDate = spDate;
	}

	public int getSpNo() {
		return spNo;
	}

	public void setSpNo(int spNo) {
		this.spNo = spNo;
	}

	public Product getSpPno() {
		return spPno;
	}

	public void setSpPno(Product spPno) {
		this.spPno = spPno;
	}

	public Product getSpPname() {
		return spPname;
	}

	public void setSpPname(Product spPname) {
		this.spPname = spPname;
	}

	public Supplier getSpSname() {
		return spSname;
	}

	public void setSpSname(Supplier spSname) {
		this.spSname = spSname;
	}

	public Product getSpPcost() {
		return spPcost;
	}

	public void setSpPcost(Product spPcost) {
		this.spPcost = spPcost;
	}

	public int getSpQty() {
		return spQty;
	}

	public void setSpQty(int spQty) {
		this.spQty = spQty;
	}

	public Date getSpDate() {
		return spDate;
	}

	public void setSpDate(Date spDate) {
		this.spDate = spDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + spNo;
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
		SupplierPurchase other = (SupplierPurchase) obj;
		if (spNo != other.spNo)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format(
				"SupplierPurchase [spNo=%s, spPno=%s, spPname=%s, spSname=%s, spPcost=%s, spQty=%s, spDate=%s]", spNo,
				spPno, spPname, spSname, spPcost, spQty, spDate);
	}
	
}
