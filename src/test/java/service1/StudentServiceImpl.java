package service1;

import java.util.List;

import java.util.Scanner;
import dao.StudentDAO;
import model1.Student;

public class StudentServiceImpl implements StudentService {
	private StudentDAO studentDAO;

	public StudentServiceImpl(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	@Override
	public boolean addStudents() {
		boolean isAdded = false;

		Scanner sc = new Scanner(System.in);
		System.out.println("Add Student opp");

		System.out.println("Elave edeceyiniz telebe sayini daxil edin");
		int studentCount = sc.nextInt();

		for (int i = 0; i < studentCount; i++) {
			Student student = new Student();
			System.out.println("Telebenin adi");
			student.setName(sc.next());
			System.out.println("Telebenin soyadi");
			student.setSurname(sc.next());
			System.out.println("Telebenin dogum tarixi");
			student.setAge(sc.nextInt());
			System.out.println("Telebenin seria nomresi");
			student.setSeriaNum(sc.next());

			isAdded = studentDAO.saveStudent(student);
		}
		return isAdded;
	}

	@Override
	public Student getStudentById() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Telebenin id  sini daxil edin");
		Student student = studentDAO.getStudentById(sc.nextLong());
		return student;
	}

	@Override
	public void printStudent(Student student) {
		System.out.println(student.getId() + " " + student.getName() + " " + student.getSurname() + " "
				+ student.getAge() + " " + student.getSeriaNum());
	}

	@Override
	public void printStudents() {
		List<Student> students = studentDAO.getStudents();
		for (Student student : students) {
			printStudent(student);
		}
	}

	@Override
	public void softDeleteStudent() {
		System.out.println("Silmek istediyiniz telebenin ID sini daxil edin ");
		Scanner sc = new Scanner(System.in);
		try {
			Long id = sc.nextLong();
			if (studentDAO.softDeleteStudent(id)) {
				System.out.println("Telebe ugurla silindi");
			} else {
				System.out.println("Xeta bash verdi");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	@Override
	public void hardDeleteStudent() {
		System.out.println("Silmek istediyiniz telebenin ID sini daxil edin ");
		Scanner sc = new Scanner(System.in);
		try {
			Long id = sc.nextLong();
			if (studentDAO.hardDeleteStudent(id)) {
				System.out.println("Telebe ugurla silindi");
			} else {
				System.out.println("Xeta bash verdi");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	@Override
	public void updateStudentById() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Deyishiklik etmek istediyiniz telebeni secin");
		Student studentFromDb = studentDAO.getStudentById(sc.nextLong());
		printStudent(studentFromDb);

		while (true) {
		
			System.out.println("Deyishklik etmek istediyiniz melumati sechin");
			System.out.println("1.Ad\n2.Soyad\n3.Dogum Tarixi\n4.Seria Nomresi\n 0-EXIT");
			int updateField = sc.nextInt();
			if (updateField != 0) {
			switch (updateField) {

			case 1:
				System.out.println("Yeni adi daxil edin");
				studentFromDb.setName(sc.next());
				break;
			case 2:
				System.out.println("Yeni soyadi daxil edin");
				studentFromDb.setSurname(sc.next());
				break;
			case 3:
				System.out.println("Yeni yash daxil edin");
				studentFromDb.setAge(sc.nextInt());
				break;
			case 4:
				System.out.println("Yeni Seria Nomresini daxil edin");
				studentFromDb.setSeriaNum(sc.nextLine());
				break;
			}
			studentDAO.updateStudentById(studentFromDb);

		} else {
			break;
		}
	}
}
}