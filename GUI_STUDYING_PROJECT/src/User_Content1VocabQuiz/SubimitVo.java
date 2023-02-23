package User_Content1VocabQuiz;

public class SubimitVo {
	private String contentsA;
	private String contentsB;
	private String contentsC;
	private String contentsAr;
	private String contentsBr;
	private String contentsCr;


	public SubimitVo(String contentsA, String contentsB, String contentsC,
			String contentsAr ,String contentsBr , String contentsCr) {
		this.contentsA = contentsA;
		this.contentsB = contentsB;
		this.contentsC = contentsC;
		this.contentsAr = contentsAr;
		this.contentsBr = contentsB;
		this.contentsCr = contentsCr;
		
	}

	public String getcontentsA() {
		return contentsA;
	}

	public String getcontentsB() {
		return contentsB;
	}

	public String getcontentsC() {
		return contentsC;
	}
	
	public String getcontentsAr() {
		return contentsAr;
	}

	public String getcontentsBr() {
		return contentsBr;
	}

	public String getcontentsCr() {
		return contentsCr;
	}

}
