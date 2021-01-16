package service1;

import java.util.List;
import java.util.Scanner;
import dao.GroupDAO;
import model1.Group;

public class GroupServiceImpl implements GroupService {
	private GroupDAO groupDAO;

	public GroupServiceImpl(GroupDAO groupDAO) {
		this.groupDAO = groupDAO;
	}

	@Override
	public boolean addGroups() {
		boolean isAdded = false;

		Scanner sc = new Scanner(System.in);
		System.out.println("ADD GROUP OPP");

		System.out.println("Elave edeceyiniz grup sayini daxil edin");
		int groupCount = sc.nextInt();

		for (int i = 0; i < groupCount; i++) {
			Group group = new Group();
			System.out.println("Grupun adi");
			group.getGroupname();
			System.out.println("Grupun id si");
			group.getId();

			isAdded = groupDAO.saveGroup(group);
		}
		return isAdded;
	}

	@Override
	public Group getGroupById() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Grupun id sini daxil edin");
		Group group = groupDAO.getGroupById(sc.nextLong());
		return group;
	}

	@Override
	public void printGroup(Group group) {
		System.out.println(group.getId() + " " + group.getGroupname());
	}

	@Override
	public void printGroups() {
		List<Group> groups = groupDAO.getGroups();
		for (Group group : groups) {
			System.out.println(group.getId() + " " + group.getGroupname());
		}

	}

	@Override
	public void softDeleteGroup() {
		System.out.println("Silmek istediyiniz grupun ID sini daxil edin ");
		Scanner sc = new Scanner(System.in);
		try {
			Long id = sc.nextLong();
			if (groupDAO.softDeleteGroup(id)) {
				System.out.println("Grup ugurla silindi");
			} else {
				System.out.println("Xeta bash verdi");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	@Override
	public void hardDeleteGroup() {

		System.out.println("Silmek istediyiniz Grupun ID sini daxil edin ");
		Scanner sc = new Scanner(System.in);
		try {
			Long id = sc.nextLong();
			if (groupDAO.hardDeleteGroup(id)) {
				System.out.println("Grup ugurla silindi");
			} else {
				System.out.println("Xeta bash verdi");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	@Override
	public void updateGroupById() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Deyishiklik etmek istediyiniz grupu secin");
		Group groupFromDb = groupDAO.getGroupById(sc.nextLong());
		printGroup(groupFromDb);

		while (true) {

			System.out.println("Deyishklik etmek istediyiniz melumati sechin");
			System.out.println("1.Ad 0-EXIT");
			int updateField = sc.nextInt();
			if (updateField != 0) {
				switch (updateField) {

				case 1:
					System.out.println("Yeni adi daxil edin");
					groupFromDb.setGroupname(sc.next());
					break;
				}
				groupDAO.updateGroupById(groupFromDb);

			} else {
				break;
			}
		}

	}

}
