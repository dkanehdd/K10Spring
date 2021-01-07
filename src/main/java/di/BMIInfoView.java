package di;

import java.util.ArrayList;

public class BMIInfoView {

	private String name;
	private double height;
	private double weight;
	private ArrayList<String> hobbys;
	private BMICalResult bmiCalResult;
	
	public String bmiCalculation() {
		
		String bmiResult = bmiCalResult.bmiCalculation(weight, height);
		return bmiResult;
	}
	
	public String getInfo() {
		
		return String.format("이름:%s<br/>"
				+"키:%s<br/>몸무게:%s<br/>취미:%s<br/>%s",
			name, height, weight, hobbys, bmiCalculation());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public ArrayList<String> getHobbys() {
		return hobbys;
	}

	public void setHobbys(ArrayList<String> hobbys) {
		this.hobbys = hobbys;
	}

	public BMICalResult getBmiCalResult() {
		return bmiCalResult;
	}

	public void setBmiCalResult(BMICalResult bmiCalResult) {
		this.bmiCalResult = bmiCalResult;
	}
	
	
}
