package dao;

import java.util.List;
import model1.Subject;

public interface SubjectDAO {

	public boolean saveSubject(Subject subject);

	public List<Subject> getSubjects();

	public boolean softDeleteSubject(Long id);

	public boolean hardDeleteSubject(Long id);

	public Subject getSubjectById(Long id);

	public boolean updateSubjectById(Subject subject);
}
