package dao;

import model.Student;
import util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    private final String GET_ALL_STUDENTS = "select * from student";
    @Override
    public List<Student> getAllStudent() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Student> students = new ArrayList<>();
        try {
            connection = DbUtil.getConnection();
            preparedStatement = connection.prepareStatement(GET_ALL_STUDENTS);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Student student = new Student();
                student.setLastName(resultSet.getString("last_name"));
                student.setName(resultSet.getString("first_name"));
                student.setId(resultSet.getInt("id_student"));
                student.setDob(resultSet.getDate("date_of_birth").toLocalDate());
                students.add(student);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DbUtil.closeAll(connection,preparedStatement, resultSet);
        }
        return students;
    }
}
