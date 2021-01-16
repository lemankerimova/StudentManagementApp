package service1;

import model1.Subject;
import model1.Teacher;

public interface TeacherService {

	public boolean addTeachers();

	public void printTeachers();

	public void softDeleteTeacher();

	public void hardDeleteTeacher();

	public Teacher getTeacherById();

	public void updateTeacherById();

	public void printTeacher(Teacher teacher);

}
