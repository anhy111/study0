package projectPrint;

public class printProject {
	public static void main(String[] args) {
		// adminStudentList 학과 순서 바꾸면 좋음
		System.out.println("------------------------------------------------");
		System.out.println("|학생번호|학생이름|이메일|전화번호|학년|학적|학과|생년월일|");
		System.out.println("------------------------------------------------");
		
		// adminProfessorList 
		System.out.println("-----------------------------------------------");
		System.out.println("|교수번호|학과번호|교수이름|학과|전화번호|이메일|생년월일|");
		System.out.println("-----------------------------------------------");
		
		// adminLectureList
		System.out.println("---------------------------------------------");
		System.out.println("|강의번호|연도|학기|학과번호|과목번호|강의시간|강의요일|");
		System.out.println("---------------------------------------------");
		
		// audSelectList
		System.out.println("---------------------------------------------");
		System.out.println("|강의번호|연도|학기|학과|과목|강의시간|강의요일|");
		System.out.println("---------------------------------------------");
		
		// 학생수강신청
		System.out.println("--------------------------------------------------------------");
		System.out.println("|강의번호|과목|학과|교수이름|연도|학기|강의시간|강의요일|강의실|현재수강인원|");
		System.out.println("--------------------------------------------------------------");
		
		// 성적조회
		System.out.println("-------------------------------------------------------");
		System.out.println("|연도|학기|학과|학생이름|과목|교수이름|학점|이수구분|점수|평점|등급|");
		System.out.println("-------------------------------------------------------");
		
		
		
		
		
	}
}
