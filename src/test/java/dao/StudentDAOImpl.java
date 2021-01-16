package dao;

import model1.Student;
import java.sql.Connection;
import db1.DbHelper;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {

	@Override
	public boolean saveStudent(Student student) {
		boolean isAdded = false;
		Connection c = null;
		PreparedStatement ps = null;
		String sql = "INSERT INTO student(s_name,surname,age,seria_num) VALUES (? ,?,?,?)";

		c = DbHelper.getConnection();
		if (c != null) {

			try {
				ps = c.prepareStatement(sql);
				ps.setString(1, student.getName());
				ps.setString(2, student.getSurname());
				ps.setInt(3, student.getAge());
				ps.setString(4, student.getSeriaNum());
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
	public List<Student> getStudents() {
		List<Student> students = new ArrayList<>();
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT id,s_name,surname,age,seria_num FROM student WHERE active = 1";
		try {
			c = DbHelper.getConnection();
			if (c != null) {
				ps = c.prepareStatement(sql);
				rs = ps.executeQuery();

				while (rs.next()) {
					Student student = new Student();
					student.setId(rs.getLong("id"));
					student.setName(rs.getString("s_name"));
					student.setSurname(rs.getString("surname"));
					student.setSeriaNum(rs.getNString("seria_num"));
					student.setAge(rs.getInt("age"));
					System.out.println(student.getName());
					students.add(student);

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
		return students;
	}

	public boolean hardDeleteStudent(Long id) {
		boolean isDeleted = false;
		Connection c = null;
		PreparedStatement ps = null;
		String sql = "DELETE FROM student WHERE id = ?";
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
	public boolean softDeleteStudent(Long id) {
		boolean isDeleted = false;
		Connection c = null;
		PreparedStatement ps = null;
		String sql = "UPDATE student SET active = 0 WHERE id = ?";
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
	public Student getStudentById(Long id) {
		Student student = new Student();
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT id,s_name,surname,age,seria_num FROM student WHERE active = 1 and id=" + id;
		try {
			c = DbHelper.getConnection();
			if (c != null) {
				ps = c.prepareStatement(sql);
				rs = ps.executeQuery();

				if (rs.next()) {
					student.setId(rs.getLong("id"));
					student.setName(rs.getString("s_name"));
					student.setSurname(rs.getString("surname"));
					student.setSeriaNum(rs.getNString("seria_num"));
					student.setAge(rs.getInt("age"));
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
		return student;

	}

	@Override
	public boolean updateStudentById(Student student) {
		boolean isUpdated = false;
		Connection c = null;
		PreparedStatement ps = null;
		String sql = "UPDATE student SET s_name = ?,surname = ?,age = ?,seria_num = ? WHERE id = ?";

		c = DbHelper.getConnection();
		if (c != null) {

			try {
				ps = c.prepareStatement(sql);
				ps.setString(1, student.getName());
				ps.setString(2, student.getSurname());
				ps.setInt(3, student.getAge());
				ps.setString(4, student.getSeriaNum());
				ps.setLong(5, student.getId());
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
