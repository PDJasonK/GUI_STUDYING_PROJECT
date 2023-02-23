package User_ToeicReadingContent;

public class ReadingMain3Vo {
	private String  GainC1 ;
	private String  GainC2;
	private String  GainC3;
	private String  SendC1;
	private String  SendC2;
	private String  SendC3 ;



public ReadingMain3Vo(String SendC1, String SendC2, String SendC3,
		String GainC1,String GainC2, String GainC3) {
	this.SendC1= SendC1;
	this.SendC2 = SendC2;
	this.SendC3 = SendC3;
	this.GainC1 = GainC1;
	this.GainC2 = GainC2;
	this.GainC3 = GainC3;
	
}

public String getSendC1() {
	return SendC1;
}

public String getSendC2() {
	return SendC2;
}

public String getSendC3() {
	return SendC3;
}

public String getGainC1() {
	return GainC1;
}

public String getGainC2() {
	return GainC2;
}

public String getGainC3() {
	return GainC3;
}

}