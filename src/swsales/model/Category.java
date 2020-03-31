package swsales.model;

public class Category {
	private int cateNo;
	private String cateName;

	public Category() {
		// TODO Auto-generated constructor stub
	}

	public Category(int cateNo) {
		this.cateNo = cateNo;
	}

	public Category(String cateName) {
		this.cateName = cateName;
	}

	public Category(int cateNo, String cateName) {
		this.cateNo = cateNo;
		this.cateName = cateName;
	}

	public int getCateNo() {
		return cateNo;
	}

	public void setCateNo(int cateNo) {
		this.cateNo = cateNo;
	}

	public String getCateName() {
		return cateName;
	}

	public void setCateName(String cateName) {
		this.cateName = cateName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cateNo;
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
		Category other = (Category) obj;
		if (cateNo != other.cateNo)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("%s",cateName);
	}

}
