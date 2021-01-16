package service1;

import java.util.List;
import java.util.Scanner;
import dao.SubjectDAO;
import model1.Subject;

public class SubjectServiceImpl implements SubjectService {
	private SubjectDAO subjectDAO;

	public SubjectServiceImpl(SubjectDAO subjectDAO) {
		this.subjectDAO = subjectDAO;
	}

	@Override
	public boolean addSubjects() {
		boolean isAdded = false;

		Scanner sc = new Scanner(System.in);
		System.out.println("ADD SUBJECT OPP");

		System.out.println("Elave edeceyiniz fennin sayini daxil edin");
		int subjectCount = sc.nextInt();

		for (int i = 0; i < subjectCount; i++) {
			Subject subject = new Subject();
			System.out.println("Fennin adi");
			subject.getSubject_name();

			isAdded = subjectDAO.saveSubject(subject);
		}
		return isAdded;
	}

	@Override
	public void printSubjects() {
		List<Subject> subjects = subjectDAO.getSubjects();
		for (Subject subject : subjects) {
			System.out.println(subject.getId() + " " + subject.getSubject_name());
			printSubject(subject);
		}

	}

	@Override
	public void printSubject(Subject subject) {
		System.out.println(subject.getSubject_name());
	}

	@Override
	public void softDeleteSubject() {
		System.out.println("Silmek istediyiniz fennin ID sini daxil edin ");
		Scanner sc = new Scanner(System.in);
		try {
			Long id = sc.nextLong();
			if (subjectDAO.softDeleteSubject(id)) {
				System.out.println("Fenn ugurla silindi");
			} else {
				System.out.println("Xeta bash verdi");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void hardDeleteSubject() {
		System.out.println("Silmek istediyiniz fennin ID sini daxil edin ");
		Scanner sc = new Scanner(System.in);
		try {
			Long id = sc.nextLong();
			if (subjectDAO.hardDeleteSubject(id)) {
				System.out.println("Telebe ugurla silindi");
			} else {
				System.out.println("Xeta bash verdi");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	@Override
	public Subject getSubjectById() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Fennin id  sini daxil edin");
		subjectDAO.getSubjectById(sc.nextLong());
		Subject subject = subjectDAO.getSubjectById(sc.nextLong());
		return subject;
	}

	@Override
	public void updateSubjectById() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Deyishiklik etmek istediyiniz fenni secin");
		Subject subjectFromDb = subjectDAO.getSubjectById(sc.nextLong());
		printSubject(subjectFromDb);

		while (true) {

			System.out.println("Deyishklik etmek istediyiniz melumati sechin");
			System.out.println("1.Ad\n 0-EXIT");
			int updateField = sc.nextInt();
			if (updateField != 0) {
				switch (updateField) {

				case 1:
					System.out.println("Yeni fennin adini daxil edin");
					subjectFromDb.setSubject_name(sc.next());
					break;
				}
				subjectDAO.updateSubjectById(subjectFromDb);

			} else {
				break;
			}
		}

	}

}
