package service1;

import java.util.List;
import model1.Student;

public interface StudentService {

	public boolean addStudents();

	public void printStudents();

	public void softDeleteStudent();

	public void hardDeleteStudent();

	public Student getStudentById();

	public void updateStudentById();

	public void printStudent(Student student);
}
