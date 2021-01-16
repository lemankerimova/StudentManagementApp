package service1;

import model1.Subject;

public interface SubjectService {
	public boolean addSubjects();

	public void printSubjects();

	public void softDeleteSubject();

	public void hardDeleteSubject();

	public Subject getSubjectById();

	public void updateSubjectById();

	public void printSubject(Subject subject);
}
