package main;
import java.util.List;

import Professor.ProfessorController;
import Professor.ProfessorVO;
import common.AdminMenu;
import common.LoginMenu;
import common.ProfessorMenu;
import common.ScannerUtil;
import common.StudentMenu;
import lecture.LectureController;
import lecture.LectureVO;
import rc.RcController;
import rc.RcVO;
import sign.SignController;
import sign.SignVO;
import student.StudentController;
import student.StudentVO;
import sub.SubController;
import sub.SubVO;

public class StudentPortalView {
	private static StudentPortalView instance = new StudentPortalView();
	private StudentPortalView() { }
	public static StudentPortalView getInstance() {
		return instance;
	}
	
	public int getMenu() {
		return ScannerUtil.nextInt();
	}
	public LoginMenu sign(SignController signController) {
		while(true) {
			System.out.println("\n이전화면으로 돌아가려면 ID에 0을 눌러주세요.");
			System.out.print("ID: ");
			String id = ScannerUtil.nextLine();
			if(id.equals("0")) {
				return LoginMenu.RETURN;
			}
			System.out.print("PW: ");
			String pw = ScannerUtil.nextLine();
			System.out.println();
			int division = signController.sign(new SignVO(id,pw));
			if(division != 0) {
				return LoginMenu.findMenu(division);
			}
		}
	}
	
	public AdminMenu studentInsert(StudentController studentController) {
		while(true) {
			System.out.print(AdminMenu.STUDENT_INSERT.getMenuString());
			System.out.println("입력을 취소하려면 학생번호에 0을 입력하세요.");
			System.out.print("학생번호를 입력하세요(예: 202001001)>>");
			String stuNo = ScannerUtil.nextLine();
			if(cancel(stuNo)) {
				break;
			}
			System.out.print("학과번호를 입력하세요>>");
			String stuDep = ScannerUtil.nextLine();
			System.out.print("이름을 입력하세요>>");
			String stuNm = ScannerUtil.nextLine();
			System.out.print("이메일을 입력하세요>>");
			String stuEm = ScannerUtil.nextLine();
			System.out.print("전화번호를 입력하세요>>");
			String stuPneNo = ScannerUtil.nextLine();
			System.out.print("학년을 입력하세요>>");
			String stuGrd = ScannerUtil.nextLine();
			System.out.print("학적을 입력하세요>>");
			String stuAcdSt = ScannerUtil.nextLine();
			System.out.print("생년월일을 입력하세요(예: 950102)>>");
			String stuBir = ScannerUtil.nextLine();
			int insertStudent = studentController.insertStudent(new StudentVO(stuNo, stuNm, stuEm, stuPneNo, stuGrd, stuAcdSt, stuDep, stuBir));
			if(insertStudent == 1) {
				System.out.println("\n학생이 등록되었습니다.");
				break;
			} else {
				System.out.println("유효하지 않은 입력입니다.");
				System.out.println("입력한 정보를 확인해주세요.");
			}
		}
		return AdminMenu.STUDENT_MANAGEMENT;
	}
	
	public AdminMenu studentList(StudentController studentController) {
		System.out.println(AdminMenu.STUDENT_LIST.getMenuString());
		List<StudentVO> list = studentController.selectStudent();
		for(StudentVO vo : list) {
			System.out.println(vo);
		}
		return AdminMenu.STUDENT_MANAGEMENT;
	}
	
	public AdminMenu professorListInsert(ProfessorController professorController) {
		while(true) {
			System.out.print(AdminMenu.PROFESSOR_INSERT.getMenuString());
			System.out.println("입력을 취소하려면 교수번호에 0을 입력하세요.");
			System.out.print("교수번호를 입력하세요(예: 2101001)>>");
			String pfNo = ScannerUtil.nextLine();
			if(cancel(pfNo)) {
				break;
			}
			System.out.print("학과번호를 입력하세요>>");
			String pfDep = ScannerUtil.nextLine();
			System.out.print("이름을 입력하세요>>");
			String pfNm = ScannerUtil.nextLine();
			System.out.print("이메일을 입력하세요>>");
			String pfEm = ScannerUtil.nextLine();
			System.out.print("전화번호를 입력하세요>>");
			String pfPneNo = ScannerUtil.nextLine();
			System.out.print("생년월일을 입력하세요(예: 950102)>>");
			String pfBir = ScannerUtil.nextLine();
			int insertStudent = professorController.insertProfessor(new ProfessorVO(pfNo, pfDep, pfNm, pfEm, pfPneNo, pfBir));
			if(insertStudent == 1) {
				System.out.println("\n교수가 등록되었습니다.");
				break;
			} else {
				System.out.println("유효하지 않은 입력입니다.");
				System.out.println("입력한 정보를 확인해주세요.");
			}
		}
		return AdminMenu.PROFESSOR_MANAGEMENT;
	}
	
	public AdminMenu professorList(ProfessorController professorController) {
		System.out.println(AdminMenu.PROFESSOR_LIST.getMenuString());
		List<ProfessorVO> list = professorController.professor();
		for(ProfessorVO vo : list) {
			System.out.println(vo);
		}
		return AdminMenu.PROFESSOR_MANAGEMENT;
	}
	
	
	
	public AdminMenu getAdminMenu() {
		int temp = getMenu();
		if(temp != 0 && AdminMenu.findMenu(temp) != null) {
			return AdminMenu.findMenu(temp);
		} 
		return AdminMenu.HOME;
	}
	
	private boolean cancel(String message) {
		if(message.equals("0")) {
			System.out.println("\n입력을 취소합니다.");
			System.out.println("이전메뉴로 돌아갑니다.");
			return true;
		}
		return false;
	}
	
	public AdminMenu lectureList(LectureController lectureController) {
		System.out.println(AdminMenu.LECTURE_LIST.getMenuString());
		List<LectureVO> list = lectureController.selectLecture();
		for(LectureVO vo : list) {
			System.out.println(vo.listToString());
		}
		return AdminMenu.LECTURE_MANAGEMENT;
	}
	
	public AdminMenu lectureInsert(LectureController lectureController) {
		while(true) {
			System.out.print(AdminMenu.LECTURE_INSERT.getMenuString());
			System.out.println("입력을 취소하려면 강의번호에 0을 입력하세요.");
			System.out.print("강의번호를 입력하세요(예: 1)>>");
			String ltcNo = ScannerUtil.nextLine();
			if(cancel(ltcNo)) {
				break;
			}
			System.out.print("교과목을 입력하세요>>");
			String lecSub = ScannerUtil.nextLine();
			System.out.print("학과번호를 입력하세요>>");
			String lecDep = ScannerUtil.nextLine();
			System.out.print("연도를 입력하세요>>");
			String lecYr = ScannerUtil.nextLine();
			System.out.print("학기를 입력하세요>>");
			String lecSem = ScannerUtil.nextLine();
			System.out.print("강의시간을 입력하세요(예: AM/PM)>>");
			String lecTm = ScannerUtil.nextLine();
			System.out.print("강의요일을 입력하세요(예: 월)>>");
			String lecWk = ScannerUtil.nextLine();
			int insertStudent = lectureController.LectureInsert(new LectureVO(ltcNo, lecYr, lecSem, lecSub, lecDep, lecTm, lecWk));
			if(insertStudent == 1) {
				System.out.println("\n강의가 개설되었습니다.");
				break;
			} else {
				System.out.println("유효하지 않은 입력입니다.");
				System.out.println("입력한 정보를 확인해주세요.");
			}
		}
		return AdminMenu.LECTURE_MANAGEMENT;
	}
	
	public AdminMenu subjectList(SubController subController) {
		System.out.println(AdminMenu.SUBJECT_LIST.getMenuString());
		List<SubVO> list = subController.selectSub();
		for(SubVO vo : list) {
			System.out.println(vo);
		}
		return AdminMenu.SUBJECT_MANAGEMENT;
	}
	
	public AdminMenu subjectInsert(SubController subController) {
		while(true) {
			System.out.print(AdminMenu.SUBJECT_INSERT.getMenuString());
			System.out.println("입력을 취소하려면 과목번호에 0을 입력하세요.");
			System.out.print("과목번호를 입력하세요(예: 1)>>");
			String subNo = ScannerUtil.nextLine();
			if(cancel(subNo)) {
				break;
			}
			System.out.print("과목명을 입력하세요>>");
			String subNm = ScannerUtil.nextLine();
			System.out.print("이수구분를 입력하세요>>");
			String comDiv = ScannerUtil.nextLine();
			System.out.print("학점을 입력하세요>>");
			String subCre = ScannerUtil.nextLine();
			System.out.print("교수번호를 입력하세요>>");
			String subPro = ScannerUtil.nextLine();
			System.out.print("강의실번호를 입력하세요(예: AM/PM)>>");
			String subRm = ScannerUtil.nextLine();
			int insertStudent = subController.insertSub(new SubVO(subNo, subCre, subPro, subRm, subNm, comDiv));
			if(insertStudent == 1) {
				System.out.println("\n교과목이 등록되었습니다.");
				break;
			} else {
				System.out.println("유효하지 않은 입력입니다.");
				System.out.println("입력한 정보를 확인해주세요.");
			}
		}
		return AdminMenu.SUBJECT_MANAGEMENT;
	}
	
	//학생
	public StudentMenu auditSign(LectureController lectureController) {
		System.out.println(StudentMenu.AUDIT_SIGN.getMenuString());
		List<LectureVO> list = lectureController.audSelect();
		for(LectureVO vo : list) {
			System.out.println(vo.toString());
		}
		
		return StudentMenu.HOME;
	}
	
	public StudentMenu allRecord(LectureController lectureController) {
		System.out.println("성적조회");
		return StudentMenu.HOME;
	}
	
	public StudentMenu auditHistory(LectureController lectureController) {
		System.out.println(StudentMenu.AUDIT_HISTORY.getMenuString());
		List<LectureVO> list = lectureController.audSelect();
		for(LectureVO vo : list) {
			System.out.println(vo);
		}
		return StudentMenu.HOME;
	}
	
	//교수
	public ProfessorMenu recordList(RcController rcController) {
		System.out.println("\n강의목록을 출력합니다");
		List<RcVO> list = rcController.selectSub();
		for(RcVO vo : list) {
			System.out.println(vo.recordToString());
		}
		System.out.print("성적을 조회할 강의번호를 입력하세요>>");
		int lecNo = ScannerUtil.nextInt();
		List<RcVO> list2 = rcController.selectStu(lecNo);
		for(RcVO vo : list2) {
			System.out.println(vo.allToString());
		}
		
		return ProfessorMenu.HOME;
	}
	
	public ProfessorMenu recordEnter(RcController rcController) {
		System.out.println("성적입력");
		return ProfessorMenu.HOME;
	}
	
}
