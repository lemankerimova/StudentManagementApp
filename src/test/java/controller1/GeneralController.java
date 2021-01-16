package controller1;

import java.util.Scanner;

import applicationproperties1.ApplicationProperties;
import exceptions.SeriaNumException;

public class GeneralController {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		ApplicationProperties.printGeneralMenu();
		System.out.println("Please select operation with num");
		int selectedController = sc.nextInt();

		try {
			switch (selectedController) {
			case 1:
				System.out.println("Menu->STUDENT CONTROLLER");
				StudentController.studentController();
				main(args);
				break;
			case 2:
				System.out.println("Menu->TEACHER CONTROLLER");
				TeacherController.teacherController();
				main(args);
				break;
			case 3:
				System.out.println("Menu->SUBJECT CONTROLLER");
				SubjectController.subjectController();
				main(args);
				break;
			case 4:
				System.out.println("Menu->GROUP CONTROLLER");
				GroupController.groupController();
				main(args);
				break;
			}

		} catch (SeriaNumException ex) {
			System.out.println(ex.getMessage());
		}

	}
}
