package swsales.model;

import java.util.Date;

public class ClientDelivery {
	private int cdNo;//출고번호
	private Order cdSno; //주문번호
	private Client cName; // 고객상호명
	private Product pName; //품목명
	private Date cdDate;//출고일자
	
	public ClientDelivery() {
		
	}

	public ClientDelivery(int cdNo) {
		this.cdNo = cdNo;
	}

	public ClientDelivery(Order cdSno) {
		this.cdSno = cdSno;
	}

	public ClientDelivery(Date cdDate) {
		this.cdDate = cdDate;
	}

	public ClientDelivery(int cdNo, Order cdSno, Date cdDate) {
		this.cdNo = cdNo;
		this.cdSno = cdSno;
		this.cdDate = cdDate;
	}
	
	public ClientDelivery(Order cdSno, Date cdDate) {
		this.cdSno = cdSno;
		this.cdDate = cdDate;
	}

	public ClientDelivery(int cdNo, Order cdSno, Client cName, Product pName, Date cdDate) {
		this.cdNo = cdNo;
		this.cdSno = cdSno;
		this.cName = cName;
		this.pName = pName;
		this.cdDate = cdDate;
	}

	public int getCdNo() {
		return cdNo;
	}

	public void setCdNo(int cdNo) {
		this.cdNo = cdNo;
	}

	public Order getCdSno() {
		return cdSno;
	}

	public void setCdSno(Order cdSno) {
		this.cdSno = cdSno;
	}

	public Client getcName() {
		return cName;
	}

	public void setcName(Client cName) {
		this.cName = cName;
	}

	public Product getpName() {
		return pName;
	}

	public void setpName(Product pName) {
		this.pName = pName;
	}

	public Date getCdDate() {
		return cdDate;
	}

	public void setCdDate(Date cdDate) {
		this.cdDate = cdDate;
	}

	@Override
	public String toString() {
		return "ClientDelivery [cdNo=" + cdNo + ", cdSno=" + cdSno + ", cName=" + cName + ", pName=" + pName.getpName()
				+ ", cdDate=" + cdDate + "]";
	}	
	
	public String toStringCD() {
		return "ClientDelivery [cdNo=" + cdNo + ", cdSno=" + cdSno + ", cdDate=" + cdDate + "]";
	}	
	
}
