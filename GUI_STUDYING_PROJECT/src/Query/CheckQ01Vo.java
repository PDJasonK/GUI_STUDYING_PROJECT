package Query;

public class CheckQ01Vo {
	private String reading1;
	private String reading2;
	private String reading3;
	private String reading4;
	private String reading5;	
	
	public CheckQ01Vo() {

	}

	public CheckQ01Vo(String reading1, String reading2, String reading3 , String reading4 , String reading5) {
		this.reading1 = reading1;
		this.reading2 = reading2;
		this.reading3 = reading3;
		this.reading4 = reading4;
		this.reading5 = reading5;

		
	}

	public String getreading1() {
		return reading1;
	}

	public String getreading2() {
		return reading2;
	}

	public String getreading3() {
		return reading3;
	}
	
	public String getreading4() {
		return reading4;
	}
	public String getreading5() {
		return reading5;
	}

}