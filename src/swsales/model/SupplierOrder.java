package swsales.model;

import java.util.Date;

public class SupplierOrder {
	private int soNo; //발주번호
	private Product soPno; //품목번호
	private Product soPname;
	private Supplier soSname; // 공급회사
	private Product soPcost;
	private int soQty; //발주수량
	private Date soDate; 

	public SupplierOrder() {
		// TODO Auto-generated constructor stub
	}

	public SupplierOrder(int soNo) {
		this.soNo = soNo;
	}
	
	

	public SupplierOrder(int soNo, Product soPno, int soQty, Date soDate) {
		super();
		this.soNo = soNo;
		this.soPno = soPno;
		this.soQty = soQty;
		this.soDate = soDate;
	}

	public SupplierOrder(int soNo, Product soPname, Supplier soSname, Product soPcost, int soQty, Date soDate) {
		this.soNo = soNo;
		this.soPname = soPname;
		this.soSname = soSname;
		this.soPcost = soPcost;
		this.soQty = soQty;
		this.soDate = soDate;
	}

	public SupplierOrder(int soNo, Product soPno, Product soPname, Supplier soSname, Product soPcost, int soQty,
			Date soDate) {
		this.soNo = soNo;
		this.soPno = soPno;
		this.soPname = soPname;
		this.soSname = soSname;
		this.soPcost = soPcost;
		this.soQty = soQty;
		this.soDate = soDate;
	}

	public int getSoNo() {
		return soNo;
	}

	public void setSoNo(int soNo) {
		this.soNo = soNo;
	}

	public Product getSoPno() {
		return soPno;
	}

	public void setSoPno(Product soPno) {
		this.soPno = soPno;
	}

	public Product getSoPname() {
		return soPname;
	}

	public void setSoPname(Product soPname) {
		this.soPname = soPname;
	}

	public Supplier getSoSname() {
		return soSname;
	}

	public void setSoSname(Supplier soSname) {
		this.soSname = soSname;
	}

	public Product getSoPcost() {
		return soPcost;
	}

	public void setSoPcost(Product soPcost) {
		this.soPcost = soPcost;
	}

	public int getSoQty() {
		return soQty;
	}

	public void setSoQty(int soQty) {
		this.soQty = soQty;
	}

	public Date getSoDate() {
		return soDate;
	}

	public void setSoDate(Date soDate) {
		this.soDate = soDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + soNo;
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
		SupplierOrder other = (SupplierOrder) obj;
		if (soNo != other.soNo)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format(
				"SupplierOrder [soNo=%s, soPno=%s, soPname=%s, soSname=%s, soPcost=%s, soQty=%s, soDate=%s]", soNo,
				soPno, soPname, soSname, soPcost, soQty, soDate);
	}
	
}