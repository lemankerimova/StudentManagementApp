//package controller1;
//
//import java.util.Scanner;
//import applicationproperties1.ApplicationProperties;
//import dao.GroupDAO;
//import dao.SubjectDAO;
//import dao.GroupDAOImpl;
//import dao.StudentDAO;
//import dao.StudentDAOImpl;
//import dao.SubjectDAOImpl;
//import dao.TeacherDAO;
//import dao.TeacherDAOImpl;
//import exceptions.SeriaNumException;
//import service1.GroupService;
//import service1.GroupServiceImpl;
//import service1.StudentService;
//import service1.StudentServiceImpl;
//import service1.SubjectService;
//import service1.SubjectServiceImpl;
//import service1.TeacherService;
//import service1.TeacherServiceImpl;
//
//public class MainController {
//
//	public static void main(String[] args) {
//
//		SubjectDAO subjectDAO = new SubjectDAOImpl();
//		GroupDAO groupDAO = new GroupDAOImpl();
//		StudentDAO studentDAO = new StudentDAOImpl();
//		TeacherDAO teacherDAO = new TeacherDAOImpl();
//		StudentService studentService = new StudentServiceImpl(studentDAO);
//		TeacherService teacherService = new TeacherServiceImpl(teacherDAO);
//		GroupService groupService = new GroupServiceImpl(groupDAO);
//		SubjectService subjectService = new SubjectServiceImpl(subjectDAO);
//		Scanner sc = new Scanner(System.in);
//
//		ApplicationProperties.printGeneralMenu();
//
//		System.out.println("Please select operation with num");
//		int selectedOperation = sc.nextInt();
//
//		try {
//			switch (selectedOperation) {
//			case 1:
//				System.out.println("Menu-> ADD STUDENT OPERATION");
//				studentService.addStudents();
//				main(args);
//				break;
//			case 2:
//				System.out.println("Menu-> GET STUDENT LIST");
//				studentService.printStudents();
//				main(args);
//				break;
//			case 3:
//				System.out.println("Menu-> SOFT DELETE STUDENT BY ID");
//				studentService.printStudents();
//				studentService.softDeleteStudent();
//				main(args);
//				break;
//			case 4:
//				System.out.println("Menu-> HARD DELETE STUDENT BY ID");
//				studentService.printStudents();
//				studentService.hardDeleteStudent();
//				main(args);
//				break;
//			case 5:
//				System.out.println("Menu-> UPDATE STUDENT BY ID");
//				studentService.printStudents();
//				studentService.updateStudentById();
//				main(args);
//				break;
//			case 6:
//				System.out.println("Menu-> ADD TEACHER OPERATION");
//				teacherService.addTeachers();
//				main(args);
//				break;
//			case 7:
//				System.out.println("Menu-> GET TEACHER OPERATION");
//				teacherService.printTeachers();
//				main(args);
//				break;
//			case 8:
//				System.out.println("MENU-> Soft DELETE TEACHER BY ID");
//				teacherService.printTeachers();
//				teacherService.softDeleteTeacher();
//				main(args);
//				break;
//			case 9:
//				System.out.println("MENU-> Hard DELETE TEACHER BY ID");
//				teacherService.printTeachers();
//				teacherService.hardDeleteTeacher();
//				main(args);
//			case 10:
//				System.out.println("Menu-> ADD GROUP OPERATION");
//				groupService.addGroups();
//				main(args);
//				break;
//			case 11:
//				System.out.println("Menu-> GET GROUP OPERATION");
//				groupService.printGroups();
//				main(args);
//				break;
//			case 12:
//				System.out.println("Menu-> SOFT DELETE GROUP BY ID");
//				groupService.printGroups();
//				groupService.softDeleteGroup();
//				main(args);
//				break;
//			case 13:
//				System.out.println("Menu-> HARD DELETE GROUP BY ID");
//				subjectService.addSubjects();
//				main(args);
//				break;
//			case 14:
//				System.out.println("Menu-> ADD SUBJECT BY ID");
//				subjectService.addSubjects();
//				main(args);
//			case 15:
//				System.out.println("Menu-> GET SUBJECT LIST");
//				subjectService.printSubjects();
//				main(args);
//				break;
//			case 16:
//				System.out.println("Menu-> SOFT DELETE SUBJECT BY ID");
//				subjectService.softDeleteSubject();
//				subjectService.softDeleteSubject();
//				main(args);
//				break;
//			case 17:
//				System.out.println("Menu-> HARD DELETE SUBJECT BY ID");
//				subjectService.printSubjects();
//				subjectService.hardDeleteSubject();
//				main(args);
//				break;
//			}
//
//		} catch (SeriaNumException e) {
//			System.err.println(e.getMessage());
//			main(args);
//		}
//	}
//}
