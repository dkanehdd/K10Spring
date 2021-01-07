package di;

public class Calculator {

	//사칙연산을 수행하는 4개의 메소드 정의
	public double adder(int fNum, int sNum) {
		int result = fNum + sNum;
		return result;
	}
	public double sub(int fNum, int sNum) {
		int result = fNum - sNum;
		return result;
	}
	public double multi(int fNum, int sNum) {
		int result = fNum * sNum;
		return result;
	}
	public double divide(int fNum, int sNum) {
		int result = fNum / sNum;
		return result;
	}
	
}
