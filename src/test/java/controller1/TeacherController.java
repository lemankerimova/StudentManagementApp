package controller1;

import java.util.Scanner;

import applicationproperties1.ApplicationProperties;
import dao.TeacherDAO;
import dao.TeacherDAOImpl;
import exceptions.SeriaNumException;
import service1.TeacherService;
import service1.TeacherServiceImpl;

public class TeacherController {

	public static void teacherController() throws Exception {

		Scanner sc = new Scanner(System.in);
		TeacherDAO teacherDAO = new TeacherDAOImpl();
		TeacherService teacherService = new TeacherServiceImpl(teacherDAO);
		ApplicationProperties.printTeacherMenu();
		System.out.println("EMELIYYATIN NOMRESINI DAXIL EDIN");	
		int selectedOperation = sc.nextInt();

		try {
			switch (selectedOperation) {
			case 1:
				System.out.println("Menu-> ADD TEACHER OPERATION");
				teacherService.addTeachers();
				break;
			case 2:
				System.out.println("Menu-> GET TEACHER LIST");
				teacherService.printTeachers();
				break;
			case 3:
				System.out.println("Menu-> SOFT DELETE TEACHER BY ID");
				teacherService.printTeachers();
				teacherService.softDeleteTeacher();
				break;
			case 4:
				System.out.println("Menu-> HARD DELETE TEACHER BY ID");
				teacherService.printTeachers();
				teacherService.hardDeleteTeacher();
				break;
			case 5:
				System.out.println("Menu-> UPDATE TEACHER BY ID");
				teacherService.printTeachers();
				teacherService.updateTeacherById();
				break;

			}
		} catch (SeriaNumException ex) {
			System.out.println(ex.getMessage());
		}

	}
}
