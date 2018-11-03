package com.webApp.servlet;

import com.webApp.constants.NavigationConstants;
import com.webApp.dao.UserDaoImpl;
import com.webApp.model.User;
import com.webApp.services.UserService;
import com.webApp.services.UserServiceImpl;
import com.webApp.util.ValidateUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@WebServlet(name = "UserServlet", urlPatterns = "/us")
public class UserServlet extends HttpServlet {
    private UserService userService= new UserServiceImpl(new UserDaoImpl());
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }
    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String action = request.getParameter("action");
        if (action.equals(NavigationConstants.ACTION_DO_REGISTER)){
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");
            String username = request.getParameter("userName");
            String password = request.getParameter("pass");
            String rePassword = request.getParameter("rePass");
            if (ValidateUtil.validate(firstName, lastName, email, username, password, rePassword)){
                if (rePassword.equals(password)){
                    User user = new User();
                    user.setUsername(username);
                    user.setEmail(email);
                    user.setPassword(password);
                    String token = java.util.UUID.randomUUID().toString();
                    user.setToken(token);
                    if (userService.registerNewUser(user)){
                        String[] array = {"header.jsp", "main.jsp", "footer.jsp"};
                        request.setAttribute("pages", array);
                        request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
                    }
                }
            }
        }
    }
}
