package controller1;

import java.util.Scanner;

import applicationproperties1.ApplicationProperties;
import dao.GroupDAO;
import dao.GroupDAOImpl;
import exceptions.SeriaNumException;
import service1.GroupService;
import service1.GroupServiceImpl;


public class GroupController {
	public static void groupController() throws Exception {
		Scanner sc = new Scanner(System.in);
		GroupDAO groupDAO = new GroupDAOImpl();
		GroupService groupService = new GroupServiceImpl(groupDAO);
		ApplicationProperties.printGroupMenu();
		System.out.println("EMELIYYATIN NOMRESINI DAXIL EDIN");	
		int selectedOperation = sc.nextInt();

		try {
			switch (selectedOperation) {
			case 1:
				System.out.println("Menu-> ADD GROUP OPERATION");
				groupService.addGroups();
				break;
			case 2:
				System.out.println("Menu-> GET GROUP LIST");
				groupService.printGroups();
				break;
			case 3:
				System.out.println("Menu-> SOFT DELETE GROUP BY ID");
				groupService.printGroups();
				groupService.softDeleteGroup();
				break;
			case 4:
				System.out.println("Menu-> HARD DELETE GROUP BY ID");
				groupService.printGroups();
				groupService.hardDeleteGroup();
				break;
			case 5:
				System.out.println("Menu-> UPDATE GROUP BY ID");
				groupService.printGroups();
				groupService.updateGroupById();
				break;

			}
		} catch (SeriaNumException ex) {
			System.out.println(ex.getMessage());
			
		}

	}

}
