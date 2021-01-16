package controller1;

import java.util.Scanner;

import applicationproperties1.ApplicationProperties;
import dao.StudentDAO;
import dao.StudentDAOImpl;
import exceptions.SeriaNumException;
import service1.StudentService;
import service1.StudentServiceImpl;

public class StudentController {

	public static void studentController() throws Exception {

		Scanner sc = new Scanner(System.in);
		StudentDAO studentDAO = new StudentDAOImpl();
		StudentService studentService = new StudentServiceImpl(studentDAO);
		ApplicationProperties.printStudentMenu();
		System.out.println("EMELIYYATIN NOMRESINI DAXIL EDIN");
		int selectedOperation = sc.nextInt();

		try {
			switch (selectedOperation) {
			case 1:
				System.out.println("Menu-> ADD STUDENT OPERATION");
				studentService.addStudents();
				break;
			case 2:
				System.out.println("Menu-> GET STUDENT LIST");
				studentService.printStudents();
				break;
			case 3:
				System.out.println("Menu-> SOFT DELETE STUDENT BY ID");
				studentService.printStudents();
				studentService.softDeleteStudent();
				break;
			case 4:
				System.out.println("Menu-> HARD DELETE STUDENT BY ID");
				studentService.printStudents();
				studentService.hardDeleteStudent();
				break;
			case 5:
				System.out.println("Menu-> UPDATE STUDENT BY ID");
				studentService.printStudents();
				studentService.updateStudentById();
				break;

			}
		} catch (SeriaNumException ex) {
			System.out.println(ex.getMessage());
		}

	}

}
