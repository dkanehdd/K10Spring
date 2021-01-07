package di;

public class AvengersInfo {

	//멤버변수 :  
	private AvengersVO avengers;
	
	public AvengersInfo(AvengersVO avengers) {
		this.avengers = avengers;
	}

	public AvengersVO getAvengers() {
		return avengers;
	}
	public void setAvengers(AvengersVO avengers) {
		this.avengers = avengers;
	}
	//멤버메소드
	public String AvengersView() {
		
		String returnStr = "";
		if(avengers != null) {
			returnStr += String.format("본명:%s <br/>", avengers.getName());
			returnStr += String.format("히어로명:%s <br/>", avengers.getHeroName());
			returnStr += String.format("능력:%s <br/>", avengers.getAbility());
			returnStr += String.format("나이:%s <br/>", avengers.getAge());
		}
		return returnStr;
	}
}
