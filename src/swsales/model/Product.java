package swsales.model;

import java.util.Date;

public class Product {
	private int pNo;
	private Category pCate;
	private String pName;
	private int pCost;
	private int pPrice;
	private Supplier pSno;
	private int pQty;
	private Date pDate;
	private byte[] pPic;
	private String pPicPath;

	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(int pNo) {
		this.pNo = pNo;
	}
	
	public Product(byte[] pPic) {
		this.pPic = pPic;
	}

	public Product(Category pCate) {
		this.pCate = pCate;
	}
	
	
	public Product(String pName) {
		this.pName = pName;
	}

	public Product(String pName, int pCost) {
		this.pName = pName;
		this.pCost = pCost;
	}

	public Product(int pNo, String pName) {
		this.pNo = pNo;
		this.pName = pName;
	}

	public Product(String pName, int pCost, int pPrice) {
		this.pName = pName;
		this.pCost = pCost;
		this.pPrice = pPrice;
	}

	public Product(Category pCate, String pName, Supplier pSno) {
		this.pCate = pCate;
		this.pName = pName;
		this.pSno = pSno;
	}

	public Product(int pNo, String pName, int pCost, int pPrice, int pQty) {
		this.pNo = pNo;
		this.pName = pName;
		this.pCost = pCost;
		this.pPrice = pPrice;
		this.pQty = pQty;
	}

	public Product(int pNo, Category pCate, String pName, int pCost, int pPrice, Supplier pSno, int pQty, Date pDate,
			String pPicPath) {
		this.pNo = pNo;
		this.pCate = pCate;
		this.pName = pName;
		this.pCost = pCost;
		this.pPrice = pPrice;
		this.pSno = pSno;
		this.pQty = pQty;
		this.pDate = pDate;
		this.pPicPath = pPicPath;
	}

	public Product(int pNo, Category pCate, String pName, int pCost, int pPrice, Supplier pSno, int pQty, Date pDate,
			byte[] pPic, String pPicPath) {
		this.pNo = pNo;
		this.pCate = pCate;
		this.pName = pName;
		this.pCost = pCost;
		this.pPrice = pPrice;
		this.pSno = pSno;
		this.pQty = pQty;
		this.pDate = pDate;
		this.pPic = pPic;
		this.pPicPath = pPicPath;
	}

	public int getpNo() {
		return pNo;
	}

	public void setpNo(int pNo) {
		this.pNo = pNo;
	}

	public Category getpCate() {
		return pCate;
	}

	public void setpCate(Category pCate) {
		this.pCate = pCate;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public int getpCost() {
		return pCost;
	}

	public void setpCost(int pCost) {
		this.pCost = pCost;
	}

	public int getpPrice() {
		return pPrice;
	}

	public void setpPrice(int pPrice) {
		this.pPrice = pPrice;
	}

	public Supplier getpSno() {
		return pSno;
	}

	public void setpSno(Supplier pSno) {
		this.pSno = pSno;
	}

	public int getpQty() {
		return pQty;
	}

	public void setpQty(int pQty) {
		this.pQty = pQty;
	}

	public Date getpDate() {
		return pDate;
	}

	public void setpDate(Date pDate) {
		this.pDate = pDate;
	}

	public byte[] getpPic() {
		return pPic;
	}

	public void setpPic(byte[] pPic) {
		this.pPic = pPic;
	}

	public String getpPicPath() {
		return pPicPath;
	}

	public void setpPicPath(String pPicPath) {
		this.pPicPath = pPicPath;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + pNo;
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
		Product other = (Product) obj;
		if (pNo != other.pNo)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return String.format("%s", pName);
	}

	
	public String toString1() {
		return String.format(
				"%s %s %s %s %s %s %s %s", pNo,
				pCate, pName, pCost, pPrice, pSno, pQty, String.format("%1$tF %1$tT", pDate));
	}
	
	

}
