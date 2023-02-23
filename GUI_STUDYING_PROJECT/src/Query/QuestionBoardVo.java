package Query;

public class QuestionBoardVo {
	private String reading1;
	private String reading2;
	private String reading3;

	public QuestionBoardVo() {

	}

	public QuestionBoardVo(String reading1, String reading2, String reading3) {
		this.reading1 = reading1;
		this.reading2 = reading2;
		this.reading3 = reading3;

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

}