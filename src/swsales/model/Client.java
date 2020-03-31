package swsales.model;

public class Client {
	private int cNo;
	private String cName;
	private String cCeo;
	private String cAddress;
	private String cTel;
	private String cId;
	private String cPw;
	private String cMail;
	private String cDate;
	private int cSalesman;
	
	public Client() {
		// TODO Auto-generated constructor stub
	}

	public Client(int cNo) {
		this.cNo = cNo;
	}

	
	public Client(String cName) {
		this.cName = cName;
	}
	

	public Client(String cId, String cPw) {
		this.cId = cId;
		this.cPw = cPw;
	}

	public Client(String cName, String cCeo, String cTel) {
		this.cName = cName;
		this.cCeo = cCeo;
		this.cTel = cTel;
	}

	public Client(String cName, String cCeo, String cAddress, int cSalesman) {
		this.cName = cName;
		this.cCeo = cCeo;
		this.cAddress = cAddress;
		this.cSalesman = cSalesman;
	}

	public Client(int cNo, String cName, String cCeo, String cAddress, String cTel, int cSalesman) {
		this.cNo = cNo;
		this.cName = cName;
		this.cCeo = cCeo;
		this.cAddress = cAddress;
		this.cTel = cTel;
		this.cSalesman = cSalesman;
	}

	public Client(int cNo, String cName, String cCeo, String cAddress, String cTel, String cId, String cMail,
			String cDate, int cSalesman) {
		this.cNo = cNo;
		this.cName = cName;
		this.cCeo = cCeo;
		this.cAddress = cAddress;
		this.cTel = cTel;
		this.cId = cId;
		this.cMail = cMail;
		this.cDate = cDate;
		this.cSalesman = cSalesman;
	}
	
	public Client(int cNo, String cName, String cCeo, String cAddress, String cTel, String cId, String cPw,
			String cMail, String cDate, int cSalesman) {
		this.cNo = cNo;
		this.cName = cName;
		this.cCeo = cCeo;
		this.cAddress = cAddress;
		this.cTel = cTel;
		this.cId = cId;
		this.cPw = cPw;
		this.cMail = cMail;
		this.cDate = cDate;
		this.cSalesman = cSalesman;
	}

	
	public Client(String cName, String cCeo, String cAddress, String cTel, String cId, String cPw, String cMail,
			String cDate, int cSalesman) {
		super();
		this.cName = cName;
		this.cCeo = cCeo;
		this.cAddress = cAddress;
		this.cTel = cTel;
		this.cId = cId;
		this.cPw = cPw;
		this.cMail = cMail;
		this.cDate = cDate;
		this.cSalesman = cSalesman;
	}

	public Client(int cNo, String cName) {
		this.cNo = cNo;
		this.cName = cName;
	}
	
	

	public Client(int cNo, String cName, String cId, String cMail) {
		this.cNo = cNo;
		this.cName = cName;
		this.cId = cId;
		this.cMail = cMail;
	}
	
	

	public Client(int cNo, String cName, String cId, String cPw, String cMail) {
		super();
		this.cNo = cNo;
		this.cName = cName;
		this.cId = cId;
		this.cPw = cPw;
		this.cMail = cMail;
	}

	public int getcNo() {
		return cNo;
	}

	public void setcNo(int cNo) {
		this.cNo = cNo;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getcCeo() {
		return cCeo;
	}

	public void setcCeo(String cCeo) {
		this.cCeo = cCeo;
	}

	public String getcAddress() {
		return cAddress;
	}

	public void setcAddress(String cAddress) {
		this.cAddress = cAddress;
	}

	public String getcTel() {
		return cTel;
	}

	public void setcTel(String cTel) {
		this.cTel = cTel;
	}

	public String getcId() {
		return cId;
	}

	public void setcId(String cId) {
		this.cId = cId;
	}

	public String getcPw() {
		return cPw;
	}

	public void setcPw(String cPw) {
		this.cPw = cPw;
	}

	public String getcMail() {
		return cMail;
	}

	public void setcMail(String cMail) {
		this.cMail = cMail;
	}

	public String getcDate() {
		return cDate;
	}

	public void setcDate(String cDate) {
		this.cDate = cDate;
	}

	public int getcSalesman() {
		return cSalesman;
	}

	public void setcSalesman(int cSalesman) {
		this.cSalesman = cSalesman;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cNo;
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
		Client other = (Client) obj;
		if (cNo != other.cNo)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Client [cNo=" + cNo + ", cName=" + cName + ", cCeo=" + cCeo + ", cAddress=" + cAddress + ", cTel="
				+ cTel + ", cId=" + cId + ", cPw=" + cPw + ", cMail=" + cMail + ", cDate=" + cDate + ", cSalesman="
				+ cSalesman + "]";
	}

//	@Override
//	public String toString() {
//		return String.format(
//				"Client [cNo=%s, cName=%s, cCeo=%s, cAddress=%s, cTel=%s, cId=%s, cPw=%s, cMail=%s, cDate=%s, cSalesman=%s]",
//				cNo, cName, cCeo, cAddress, cTel, cId, cPw, cMail, cDate, cSalesman);
//	}
	
	
	
}
