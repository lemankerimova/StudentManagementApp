package db1;

import java.util.HashMap;
import java.util.Map;
import model1.Group;
import model1.Student;
import model1.Subject;
import model1.Teacher;

public class DbClass {
	public static Map<String, Student> studentList = new HashMap<String, Student>();

	public static Map<String, Teacher> teacherList = new HashMap<String, Teacher>();

	public static Map<String, Group> groupList = new HashMap<String, Group>();

	public static Map<String, Subject> subjectList = new HashMap<String, Subject>();
}