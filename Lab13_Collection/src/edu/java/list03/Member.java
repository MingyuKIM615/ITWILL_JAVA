package edu.java.list03;

public class Member {
	// field
	private String memberId;
	private String memberPassword;

	// 생성자 - 기본 생성자, 파라미터 2개인 생성자
	public Member() {
	}

	public Member(String memberId, String memberPassword) {
		this.memberId = memberId;
		this.memberPassword = memberPassword;
	}

	// getter(필드가 가지고 있는 값을 리턴) & setters(필드의 값을 변경)
	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPassword() {
		return memberPassword;
	}

	public void setMemberPassword(String memberPassword) {
		this.memberPassword = memberPassword;
	}

	// toString override
	@Override
	public String toString() {

		return "Member{memberId : " + this.memberId + ", memberPassword : " + this.memberPassword + "}";
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean result = false;
		if(obj instanceof Member) { // 파라미터 obj가  Member 타입 객체이면
			Member m = (Member) obj; // casting(강제 타입 변환)
			if(this.memberId.equals(m.memberId)) { // 나의 memberId와 파라미터로 전달된 객체의 memberId가 같으면
				result = true;
			}
		}
		return result;
	}
	
	// hashCode 메서드 override: equals 가 true를 리턴하는 두 객체는 같은 hashCode값을 같도록 구현
	@Override
	public int hashCode() {
		// equals를 override할 때 memberId만 같으면 true가 되도록 구현했기 때문에,
		// hashCode도 memberId(String 클래스 객체)의 hashCode를 이용하면 됨.
		return this.memberId.hashCode();
	}

}
