package dao;

import model1.Group;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import db1.DbHelper;

public class GroupDAOImpl implements GroupDAO {

	@Override
	public boolean saveGroup(Group group) {
		boolean isAdded = false;
		Connection c = null;
		PreparedStatement ps = null;
		String sql = "INSERT INTO group(g_name) VALUES (?)";

		c = DbHelper.getConnection();
		if (c != null) {

			try {
				ps = c.prepareStatement(sql);
				ps.setString(1, group.getGroupname());
				ps.execute();
				isAdded = true;
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());

			} finally {
				try {
					ps.close();
					c.close();

				} catch (Exception e) {

				}

			}

		}
		return isAdded;

	}

	@Override
	public List<Group> getGroups() {
		List<Group> groups = new ArrayList<>();
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT id,g_name FROM group WHERE active = 1";
		try {
			c = DbHelper.getConnection();
			if (c != null) {
				ps = c.prepareStatement(sql);
				rs = ps.executeQuery();

				while (rs.next()) {
					Group group = new Group();
					group.setGroupname(rs.getString("g_name"));
					group.setId(rs.getLong("id"));
					System.out.println(group.getGroupname());
					groups.add(group);

				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				c.close();
				ps.close();
			} catch (SQLException ex) {
				ex.getMessage();
			}
		}
		return groups;
	}

	@Override
	public boolean softDeleteGroup(Long id) {
		boolean isDeleted = false;
		Connection c = null;
		PreparedStatement ps = null;
		String sql = "UPDATE group SET active = 0 WHERE id = ?";
		try {
			c = DbHelper.getConnection();
			if (c != null) {
				ps = c.prepareStatement(sql);
				ps.setLong(1, id);
				ps.execute();
				isDeleted = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				c.close();
				ps.close();
			} catch (SQLException ex) {

			}
		}
		return isDeleted;
	}

	@Override
	public boolean hardDeleteGroup(Long id) {
		boolean isDeleted = false;
		Connection c = null;
		PreparedStatement ps = null;
		String sql = "DELETE FROM group WHERE id = ?";
		try {
			c = DbHelper.getConnection();
			if (c != null) {
				ps = c.prepareStatement(sql);
				ps.setLong(1, id);
				ps.execute();
				isDeleted = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				c.close();
				ps.close();
			} catch (SQLException ex) {

			}
		}
		return isDeleted;
	}

	@Override
	public Group getGroupById(Long id) {
		Group group = new Group();
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT id,g_name FROM group WHERE active = 1 and id=" + id;
		try {
			c = DbHelper.getConnection();
			if (c != null) {
				ps = c.prepareStatement(sql);
				rs = ps.executeQuery();

				if (rs.next()) {
					group.setId(rs.getLong("id"));
					group.setGroupname(rs.getString("g_name"));
				}

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				c.close();
				ps.close();
			} catch (SQLException ex) {
				ex.getMessage();
			}
		}
		return group;

	}

	@Override
	public boolean updateGroupById(Group group) {
		boolean isUpdated = false;
		Connection c = null;
		PreparedStatement ps = null;
		String sql = "UPDATE group SET g_name = ?, WHERE id =?";

		c = DbHelper.getConnection();
		if (c != null) {

			try {
				ps = c.prepareStatement(sql);
				ps.setString(1, group.getGroupname());
				ps.setLong(5, group.getId());
				ps.execute();
				isUpdated = true;
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());

			} finally {
				try {
					ps.close();
					c.close();

				} catch (Exception e) {

				}

			}

		}
		return isUpdated;

	}

}
