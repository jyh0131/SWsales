package swsales.model;

import java.util.Date;



public class Order {
	private int oNo;
	private Date oDate;
	private Client oCname;
	private Product oPname;
	private int oQty;
	private String oMemo;
	private int oDps;
	private int oOk;
	private Employee oEname;
	private Employee oEno;
	private Product oPic;


	public Order() {
		// TODO Auto-generated constructor stub
	}


	public Order(int oNo) {
		this.oNo = oNo;
	}
	
	public Order(int oNo, Date oDate, Client oCname, Product oPname, int oQty, String oMemo) {
		this.oNo = oNo;
		this.oDate = oDate;
		this.oCname = oCname;
		this.oPname = oPname;
		this.oQty = oQty;
		this.oMemo = oMemo;
	}

	public Order(int oNo, Date oDate, Client oCname, Product oPname, int oQty, String oMemo, int oDps, int oOk,
			Employee oEname, Employee oEno) {
		this.oNo = oNo;
		this.oDate = oDate;
		this.oCname = oCname;
		this.oPname = oPname;
		this.oQty = oQty;
		this.oMemo = oMemo;
		this.oDps = oDps;
		this.oOk = oOk;
		this.oEname = oEname;
		this.oEno = oEno;
	}


	public Order(int oNo, Date oDate, Client oCname, Product oPname, int oQty, String oMemo, int oDps, int oOk) {
		this.oNo = oNo;
		this.oDate = oDate;
		this.oCname = oCname;
		this.oPname = oPname;
		this.oQty = oQty;
		this.oMemo = oMemo;
		this.oDps = oDps;
		this.oOk = oOk;
	}

	public Order(int oNo, Date oDate, Client oCname, Product oPname, int oQty, String oMemo, int oDps, int oOk,
			Employee oEname) {
		this.oNo = oNo;
		this.oDate = oDate;
		this.oCname = oCname;
		this.oPname = oPname;
		this.oQty = oQty;
		this.oMemo = oMemo;
		this.oDps = oDps;
		this.oOk = oOk;
		this.oEname = oEname;
	}

	public Order(int oNo, Date oDate, Client oCname, Product oPname, int oQty, String oMemo, Employee oEname,
			Product oPic) {
		this.oNo = oNo;
		this.oDate = oDate;
		this.oCname = oCname;
		this.oPname = oPname;
		this.oQty = oQty;
		this.oMemo = oMemo;
		this.oEname = oEname;
		this.oPic = oPic;
	}

	public Order(int oNo, Date oDate, Client oCname, Product oPname, int oQty, String oMemo, int oDps, int oOk,
			Employee oEname, Product oPic) {
		this.oNo = oNo;
		this.oDate = oDate;
		this.oCname = oCname;
		this.oPname = oPname;
		this.oQty = oQty;
		this.oMemo = oMemo;
		this.oDps = oDps;
		this.oOk = oOk;
		this.oEname = oEname;
		this.oPic = oPic;
	}

	public Order(int oNo, Client oCname , int oQty) {
		this.oNo = oNo;
		this.oCname = oCname;
		this.oQty = oQty;
	}


	public Employee getoEno() {
		return oEno;
	}

	public void setoEno(Employee oEno) {
		this.oEno = oEno;
	}

	public int getoNo() {
		return oNo;
	}

	public void setoNo(int oNo) {
		this.oNo = oNo;
	}

	public Date getoDate() {
		return oDate;
	}

	public void setoDate(Date oDate) {
		this.oDate = oDate;
	}

	public Client getoCname() {
		return oCname;
	}

	public void setoCname(Client oCname) {
		this.oCname = oCname;
	}

	public Product getoPname() {
		return oPname;
	}

	public void setoPname(Product oPname) {
		this.oPname = oPname;
	}

	public int getoQty() {
		return oQty;
	}

	public void setoQty(int oQty) {
		this.oQty = oQty;
	}

	public String getoMemo() {
		return oMemo;
	}

	public void setoMemo(String oMemo) {
		this.oMemo = oMemo;
	}

	public int getoDps() {
		return oDps;
	}

	public void setoDps(int oDps) {
		this.oDps = oDps;
	}

	public int getoOk() {
		return oOk;
	}

	public void setoOk(int oOk) {
		this.oOk = oOk;
	}

	public Employee getoEname() {
		return oEname;
	}

	public void setoEname(Employee oEname) {
		this.oEname = oEname;
	}

	public Product getoPic() {
		return oPic;
	}

	public void setoPic(Product oPic) {
		this.oPic = oPic;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + oNo;
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
		Order other = (Order) obj;
		if (oNo != other.oNo)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format(
				"Order [oNo=%s, oDate=%s, oCname=%s, oPname=%s, oQty=%s, oMemo=%s, oDps=%s, oOk=%s, oEname=%s, oEno=%s]",
				oNo, oDate, oCname, oPname, oQty, oMemo, oDps, oOk, oEname, oEno);
	}
	
	public String toStringModify() {
		return String.format(
				"Order [oNo=%s, oDate=%s, oCname=%s, oPname=%s, oQty=%s, oMemo=%s]",
				oNo, oDate, oCname, oPname, oQty, oMemo);
	}
}
