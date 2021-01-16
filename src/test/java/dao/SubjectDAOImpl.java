package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model1.Subject;
import db1.DbHelper;
import model1.Student;

public class SubjectDAOImpl implements SubjectDAO {

	@Override
	public boolean saveSubject(Subject subject) {
		boolean isAdded = false;
		Connection c = null;
		PreparedStatement ps = null;
		String sql = "INSERT INTO subject(id,subject_name,active) VALUES (?,?,?)";

		c = DbHelper.getConnection();
		if (c != null) {

			try {
				ps = c.prepareStatement(sql);
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
	public List<Subject> getSubjects() {
		List<Subject> subjects = new ArrayList<>();
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT id,subject_name,active FROM subject WHERE active = 1";
		try {
			c = DbHelper.getConnection();
			if (c != null) {
				ps = c.prepareStatement(sql);
				rs = ps.executeQuery();

				while (rs.next()) {
					Subject subject = new Subject();
					subject.setId(rs.getLong("id"));
					subject.setSubject_name(rs.getString("subject name"));
					subject.setActive(rs.getBoolean("active"));
					subjects.add(subject);

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
		return subjects;
	}

	@Override
	public boolean softDeleteSubject(Long id) {
		boolean isDeleted = false;
		Connection c = null;
		PreparedStatement ps = null;
		String sql = "UPDATE subject SET active = 0 WHERE id = ?";
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
	public boolean hardDeleteSubject(Long id) {
		boolean isDeleted = false;
		Connection c = null;
		PreparedStatement ps = null;
		String sql = "DELETE FROM subject WHERE id = ?";
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
	public Subject getSubjectById(Long id) {
		Subject subject = new Subject();
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT id,sub_name FROM subject WHERE active = 1 and id=" + id;
		try {
			c = DbHelper.getConnection();
			if (c != null) {
				ps = c.prepareStatement(sql);
				rs = ps.executeQuery();

				if (rs.next()) {
					subject.setId(rs.getLong("id"));
					subject.setSubject_name(rs.getString("sub_name"));

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
		return subject;

	}

	@Override
	public boolean updateSubjectById(Subject subject) {
		boolean isUpdated = false;
		Connection c = null;
		PreparedStatement ps = null;
		String sql = "UPDATE subject SET sub_name = ?, WHERE id = ?";

		c = DbHelper.getConnection();
		if (c != null) {

			try {
				ps = c.prepareStatement(sql);
				ps.setString(1, subject.getSubject_name());
				ps.setLong(2, subject.getId());
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
