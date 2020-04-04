package swsales.model;

public class BoardContent {
	private int bcNo;
	private String bcContent;

	public BoardContent() {
		// TODO Auto-generated constructor stub
	}

	public BoardContent(int bcNo, String bcContent) {
		super();
		this.bcNo = bcNo;
		this.bcContent = bcContent;
	}

	public int getBcNo() {
		return bcNo;
	}

	public void setBcNo(int bcNo) {
		this.bcNo = bcNo;
	}

	public String getBcContent() {
		return bcContent;
	}

	public void setBcContent(String bcContent) {
		this.bcContent = bcContent;
	}

	@Override
	public String toString() {
		return "BoardContent [bcNo=" + bcNo + ", bcContent=" + bcContent + "]";
	}

}
