package service1;

import model1.Group;
import model1.Student;

public interface GroupService {

	public boolean addGroups();

	public void printGroups();

	public void softDeleteGroup();

	public void hardDeleteGroup();

	public Group getGroupById();

	public void updateGroupById();

	public void printGroup(Group group);

}
