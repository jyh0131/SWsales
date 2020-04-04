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
	private String content;

	public Board() {
		// TODO Auto-generated constructor stub
	}

	public Board(int bNo, String bId, String bName, String bTitle, Date bRegDate, Date bModDate, int bReadCnt) {
		super();
		this.bNo = bNo;
		this.bId = bId;
		this.bName = bName;
		this.bTitle = bTitle;
		this.bRegDate = bRegDate;
		this.bModDate = bModDate;
		this.bReadCnt = bReadCnt;
	}

	public Board(int bNo, String bId, String bName, String bTitle, Date bRegDate, Date bModDate, int bReadCnt,
			String content) {
		super();
		this.bNo = bNo;
		this.bId = bId;
		this.bName = bName;
		this.bTitle = bTitle;
		this.bRegDate = bRegDate;
		this.bModDate = bModDate;
		this.bReadCnt = bReadCnt;
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

	@Override
	public String toString() {
		return "Board [bNo=" + bNo + ", bId=" + bId + ", bName=" + bName + ", bTitle=" + bTitle + ", bRegDate="
				+ bRegDate + ", bModDate=" + bModDate + ", bReadCnt=" + bReadCnt + ", content=" + content + "]";
	}

}
