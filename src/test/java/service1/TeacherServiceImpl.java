package service1;

import java.util.List;
import java.util.Scanner;
import dao.TeacherDAO;

import model1.Teacher;

public class TeacherServiceImpl implements TeacherService {
	private TeacherDAO teacherDAO;

	public TeacherServiceImpl(TeacherDAO teacherDAO) {
		this.teacherDAO = teacherDAO;
	}

	@Override
	public boolean addTeachers() {
		boolean isAdded = false;

		Scanner sc = new Scanner(System.in);
		System.out.println("AD TEACHER OPP");

		System.out.println("Elave edeceyiniz muellim sayini daxil edin");
		int teacherCount = sc.nextInt();

		for (int i = 0; i < teacherCount; i++) {
			Teacher teacher = new Teacher();
			System.out.println("Muellimin adi");
			teacher.setName(sc.next());
			System.out.println("Muellimin soyadi");
			teacher.setSurname(sc.next());
			System.out.println("Muellimin dogum tarixi");
			teacher.setAge(sc.nextInt());
			System.out.println("Muellimin seria nomresi");
			teacher.setSeriaNum(sc.next());

			isAdded = teacherDAO.saveTeacher(teacher);

		}
		return isAdded;
	}

	@Override
	public void printTeachers() {
		List<Teacher> teachers = teacherDAO.getTeachers();
		for (Teacher teacher : teachers) {
			System.out.println(teacher.getId() + " " + teacher.getName() + " " + teacher.getSurname() + " "
					+ teacher.getAge() + " " + teacher.getSeriaNum());
		}

	}

	@Override
	public void printTeacher(Teacher teacher) {
		System.out.println(teacher.getId() + " " + teacher.getName() + " " + teacher.getSurname() + " "
				+ teacher.getAge() + " " + teacher.getSeriaNum());
	}

	@Override
	public void softDeleteTeacher() {
		System.out.println("Silmek istediyiniz muellimin ID sini daxil edin ");
		Scanner sc = new Scanner(System.in);
		try {
			Long id = sc.nextLong();
			if (teacherDAO.softDeleteTeacher(id)) {
				System.out.println("Muellim ugurla silindi");
			} else {
				System.err.println("Xeta bash verdi");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	@Override
	public void hardDeleteTeacher() {
		System.out.println("Silmek istediyiniz muellimin ID sini daxil edin ");
		Scanner sc = new Scanner(System.in);
		try {
			Long id = sc.nextLong();
			if (teacherDAO.hardDeleteTeacher(id)) {
				System.out.println("Muellim ugurla silindi");
			} else {
				System.out.println("Xeta bash verdi");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	@Override
	public Teacher getTeacherById() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Muellimin id  sini daxil edin");
		teacherDAO.getTeacherById(sc.nextLong());
		Teacher teacher = teacherDAO.getTeacherById(sc.nextLong());
		return teacher;

	}

	@Override
	public void updateTeacherById() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Deyishiklik etmek istediyiniz muellimi secin");
		Teacher teacherFromDb = teacherDAO.getTeacherById(sc.nextLong());
		printTeacher(teacherFromDb);

		while (true) {

			System.out.println("Deyishklik etmek istediyiniz melumati sechin");
			System.out.println("1.Ad\n2.Soyad\n3.Dogum Tarixi\n4.Seria Nomresi\n5.Fennin adi 0-EXIT");
			int updateField = sc.nextInt();
			if (updateField != 0) {
				switch (updateField) {

				case 1:
					System.out.println("Yeni adi daxil edin");
					teacherFromDb.setName(sc.next());
					break;
				case 2:
					System.out.println("Yeni soyadi daxil edin");
					teacherFromDb.setSurname(sc.next());
					break;
				case 3:
					System.out.println("Yeni yash daxil edin");
					teacherFromDb.setAge(sc.nextInt());
					break;
				case 4:
					System.out.println("Yeni Seria Nomresini daxil edin");
					teacherFromDb.setSeriaNum(sc.nextLine());
					break;
				}
				teacherDAO.updateTeacherById(teacherFromDb);

			} else {
				break;
			}
		}
	}
}
