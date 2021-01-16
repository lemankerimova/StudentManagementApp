package dao;

import java.util.List;

import model1.Group;

public interface GroupDAO {

	public boolean saveGroup(Group group);

	public List<Group> getGroups();

	public boolean softDeleteGroup(Long id);

	public boolean hardDeleteGroup(Long id);

	public Group getGroupById(Long id);

	public boolean updateGroupById(Group group);
}
