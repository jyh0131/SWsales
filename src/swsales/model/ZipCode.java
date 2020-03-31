package swsales.model;

public class ZipCode {
	private String zCode;
	private String zSido;
	private String zSigungu;
	private String zDoro;
	private int zNum1;
	private int zNum2;
	private String address;

	public ZipCode() {
		// TODO Auto-generated constructor stub
	}

	public ZipCode(String address) {
		this.address = address;
	}

	public ZipCode(String zSido, String zDoro, int zNum1) {
		this.zSido = zSido;
		this.zDoro = zDoro;
		this.zNum1 = zNum1;
	}

	public ZipCode(String zSido, String zDoro, int zNum1, int zNum2) {
		this.zSido = zSido;
		this.zDoro = zDoro;
		this.zNum1 = zNum1;
		this.zNum2 = zNum2;
	}

	public ZipCode(String zCode, String zSido, String zSigungu, String zDoro, int zNum1, int zNum2) {
		this.zCode = zCode;
		this.zSido = zSido;
		this.zSigungu = zSigungu;
		this.zDoro = zDoro;
		this.zNum1 = zNum1;
		this.zNum2 = zNum2;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getzCode() {
		return zCode;
	}

	public void setzCode(String zCode) {
		this.zCode = zCode;
	}

	public String getzSido() {
		return zSido;
	}

	public void setzSido(String zSido) {
		this.zSido = zSido;
	}

	public String getzSigungu() {
		return zSigungu;
	}

	public void setzSigungu(String zSigungu) {
		this.zSigungu = zSigungu;
	}

	public String getzDoro() {
		return zDoro;
	}

	public void setzDoro(String zDoro) {
		this.zDoro = zDoro;
	}

	public int getzNum1() {
		return zNum1;
	}

	public void setzNum1(int zNum1) {
		this.zNum1 = zNum1;
	}

	public int getzNum2() {
		return zNum2;
	}

	public void setzNum2(int zNum2) {
		this.zNum2 = zNum2;
	}

	@Override
	public String toString() {
		return String.format("%s %s %s %s", zSido,
				zSigungu, zDoro, zNum1);
	}
	
	public String toStringAll() {
		return String.format("%s %s %s %s-%s", zSido,
				zSigungu, zDoro, zNum1, zNum2);
	}
	
	public String toStringAddress() {
		return String.format("%s", address);
	}

}
