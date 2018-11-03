package servlet;

import dao.StudentDaoImpl;
import model.Student;
import service.StudentService;
import service.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "NavigationServlet", urlPatterns = "/ns")
public class NavigationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        procesRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        procesRequest(request, response);
    }

    private void procesRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        StudentService studentService = new StudentServiceImpl(new StudentDaoImpl());

        String action = null;
        if (request.getParameter("action") != null){
            action = request.getParameter("action");
        }
        if (action.equals("getAllStudents")){

            List<Student> students = studentService.getAllStudents();
            request.setAttribute("students", students);
            request.getRequestDispatcher("/WEB-INF/fragments/student-table.jsp").forward(request, response);

        }else if (action.equals("getAllTeachers")){
            request.getRequestDispatcher("/WEB-INF/fragments/tecaher-table.jsp").forward(request, response);
        }
    }
}
