package br.com.school.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.school.factory.ConnectionFactory;
import br.com.school.model.Student;

public class StudentDAO {
	
	public void save(Student student) throws Exception {
		String sql = "INSERT INTO student(nome, email, curso) values(?,?,?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			pstm.setString(1, student.getName());
			pstm.setString(2, student.getEmail());
			pstm.setString(3, student.getCourse());
			
			pstm.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try {
				if(pstm!=null) {
					pstm.close();
				}
				if(conn!=null) {
					conn.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

	public List<Student> getAllStudents() throws Exception {
		List<Student> students = new ArrayList<Student>();
		String sql = "SELECT * FROM student";
		
		Connection conn = null;
		PreparedStatement pstm = null;

		ResultSet rset = null;

		try{
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			while (rset.next()) {
				Student student = new Student();
				student.setId(rset.getInt("id"));
				student.setName(rset.getString("nome"));
				student.setEmail(rset.getString("email"));
				student.setCourse(rset.getString("curso"));
				students.add(student);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				if(rset!=null){
					rset.close();
				}
				if(pstm!=null){
					pstm.close();
				}
				if(conn!=null){
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}

		return students;
	}

	public void listStudents(StudentDAO studentDAO) throws Exception {
		for(Student s : studentDAO.getAllStudents()) {
			System.out.println("Student: " + s.getName() + " - " + s.getEmail() + " - " + s.getCourse());
		}
	}

	public Student getStudentById(int id) throws Exception {
		String sql = "SELECT * FROM student WHERE id = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		Student student = null;
		
		try{
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setInt(1, id);
			
			ResultSet rset = pstm.executeQuery();
			if(rset.next()){
				student = new Student();
				student.setId(rset.getInt("id"));
				student.setName(rset.getString("nome"));
				student.setEmail(rset.getString("email"));
				student.setCourse(rset.getString("curso"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(pstm!=null){
					pstm.close();
				}
				if(conn!=null){
					conn.close();
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return student;
	}

	public void update(Student student) throws Exception {
		String sql = "UPDATE student SET nome = ?, email = ?, curso = ? WHERE id = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try{
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setString(1, student.getName());
			pstm.setString(2, student.getEmail());
			pstm.setString(3, student.getCourse());
			pstm.setInt(4, student.getId());

			int rowsAffected = pstm.executeUpdate();
			System.out.println("Rows affected: " + rowsAffected);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(pstm!=null){
					pstm.close();
				}
				if(conn!=null){
					conn.close();
				}
			}catch(Exception e){
				System.out.println("Erro ao fechar conexão");
				e.printStackTrace();
			}
		}
	}
	
	public void delete(Student student) throws Exception {
		String sql = "DELETE FROM student WHERE id = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try{
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setInt(1, student.getId());
			
			pstm.execute();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(pstm!=null){
					pstm.close();
				}
				if(conn!=null){
					conn.close();
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		

	}
}