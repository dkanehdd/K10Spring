package common;

public class MemberDTO {

	private String id;
	private String pw;
	private String name;
	private String email;
	/*
	기본생성자는 디폴트로 삽입된다.
	멤버변수의 갯수가 많을때는 생성자를 추가하지 않아도 된다.
	 */
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
