package swsales.model;

import java.util.Date;

public class Board {
	private int bNo;
	private String bId;
	private String bName;
	private String bTitle;
	private Date bRegDate;
	private Date bModDate;
	private int bReadCnt;
	private String bDept;
	private String content;

	public Board() {
		// TODO Auto-generated constructor stub
	}

	public Board(int bNo, String bId, String bName, String bTitle, Date bRegDate, Date bModDate, int bReadCnt,
			String bDept) {
		super();
		this.bNo = bNo;
		this.bId = bId;
		this.bName = bName;
		this.bTitle = bTitle;
		this.bRegDate = bRegDate;
		this.bModDate = bModDate;
		this.bReadCnt = bReadCnt;
		this.bDept = bDept;
	}

	public Board(int bNo, String bId, String bName, String bTitle, Date bRegDate, Date bModDate, int bReadCnt,
			String bDept, String content) {
		super();
		this.bNo = bNo;
		this.bId = bId;
		this.bName = bName;
		this.bTitle = bTitle;
		this.bRegDate = bRegDate;
		this.bModDate = bModDate;
		this.bReadCnt = bReadCnt;
		this.bDept = bDept;
		this.content = content;
	}

	public int getbNo() {
		return bNo;
	}

	public void setbNo(int bNo) {
		this.bNo = bNo;
	}

	public String getbId() {
		return bId;
	}

	public void setbId(String bId) {
		this.bId = bId;
	}

	public String getbName() {
		return bName;
	}

	public void setbName(String bName) {
		this.bName = bName;
	}

	public String getbTitle() {
		return bTitle;
	}

	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}

	public Date getbRegDate() {
		return bRegDate;
	}

	public void setbRegDate(Date bRegDate) {
		this.bRegDate = bRegDate;
	}

	public Date getbModDate() {
		return bModDate;
	}

	public void setbModDate(Date bModDate) {
		this.bModDate = bModDate;
	}

	public int getbReadCnt() {
		return bReadCnt;
	}

	public void setbReadCnt(int bReadCnt) {
		this.bReadCnt = bReadCnt;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getbDept() {
		return bDept;
	}

	public void setbDept(String bDept) {
		this.bDept = bDept;
	}

	@Override
	public String toString() {
		return "Board [bNo=" + bNo + ", bId=" + bId + ", bName=" + bName + ", bDept=" + bDept + ", bTitle=" + bTitle
				+ ", bRegDate=" + bRegDate + ", bModDate=" + bModDate + ", bReadCnt=" + bReadCnt + ", content="
				+ content + "]";
	}

}
