package controller1;

import java.util.Scanner;

import applicationproperties1.ApplicationProperties;
import dao.SubjectDAO;
import dao.SubjectDAOImpl;
import exceptions.SeriaNumException;
import service1.SubjectService;
import service1.SubjectServiceImpl;

public class SubjectController {

	public static void subjectController() throws Exception {

		Scanner sc = new Scanner(System.in);
		SubjectDAO subjectDAO = new SubjectDAOImpl();
		SubjectService subjectService = new SubjectServiceImpl(subjectDAO);
		ApplicationProperties.printSubjectMenu();
		System.out.println("EMELIYYATIN NOMRESINI DAXIL EDIN");
		int selectedOperation = sc.nextInt();

		try {
			switch (selectedOperation) {
			case 1:
				System.out.println("Menu-> ADD SUBJECT OPERATION");
				subjectService.addSubjects();
				break;
			case 2:
				System.out.println("Menu-> GET SUBJECT LIST");
				subjectService.printSubjects();
				break;
			case 3:
				System.out.println("Menu-> SOFT DELETE SUBJECT BY ID");
				subjectService.printSubjects();
				subjectService.softDeleteSubject();
				break;
			case 4:
				System.out.println("Menu-> HARD DELETE SUBJECT BY ID");
				subjectService.printSubjects();
				subjectService.hardDeleteSubject();
				break;
			case 5:
				System.out.println("Menu-> UPDATE SUBJECT BY ID");
				subjectService.printSubjects();
				subjectService.updateSubjectById();
				break;

			}
		} catch (SeriaNumException ex) {
			System.out.println(ex.getMessage());
		}

	}

}
