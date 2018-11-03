package service;

import dao.StudentDao;
import model.Student;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    private StudentDao studentDao;
    public StudentServiceImpl(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentDao.getAllStudent();
    }
}
