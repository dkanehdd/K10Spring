package common;

public class StudentDTO {
	
	private String name;
	private String age;
	private String gradeNum;
	private String classNum;
	/*
	해당 DTO객체를 커맨드객체로 사용하기 위해서는
	반드시 기본생성자가 필요하다. 따라서 처음부터 생성자를 
	만들지 않거나, 만약만든다면 기본생성자를 추가해야한다.
	*/
	public StudentDTO() {}
	public StudentDTO(String name, String age, String gradeNum, String classNum) {
		super();
		this.name = name;
		this.age = age;
		this.gradeNum = gradeNum;
		this.classNum = classNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getGradeNum() {
		return gradeNum;
	}
	public void setGradeNum(String gradeNum) {
		this.gradeNum = gradeNum;
	}
	public String getClassNum() {
		return classNum;
	}
	public void setClassNum(String classNum) {
		this.classNum = classNum;
	}
}
