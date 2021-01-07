package di;

public class BMICalResult {

	private double lowWeight;	//저체중
	private double normal; 		//정상체중
	private double overWeight;  //과체중
	private double obesity; 	//비만	
	//setter만 정의
	public void setLowWeight(double lowWeight) {
		this.lowWeight = lowWeight;
	}
	public void setNormal(double normal) {
		this.normal = normal;
	}
	public void setOverWeight(double overWeight) {
		this.overWeight = overWeight;
	}
	public void setObesity(double obesity) {
		this.obesity = obesity;
	}
	
	//체질량지수 계산을 위한 메소드
	public String bmiCalculation(double weight, double height) {
		//지수를 계산한후...
		double h = height * 0.01;
		double result = weight/(h*h);
		
		String resultStr = "당신의 BMI지수는? "+ (int)result;
		//결과를 String으로 반환한다.
		if(result>obesity) {
			resultStr += "<br/>비만입니다 ㅜㅜ";
		}
		else if(result>overWeight) {
			resultStr += "<br/>과체중입니다 ㅜ";
		}
		else if(result>normal) {
			resultStr += "<br/>정상입니다 ^^";
		}
		else{
			resultStr += "<br/>저체중입니다 -_-";
		}
		return resultStr;
	}
}
