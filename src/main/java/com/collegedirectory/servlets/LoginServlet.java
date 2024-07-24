package com.collegedirectory.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.collagedirectory.dao.UserDao;
import com.collagedirectory.dto.Users;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
        String password = req.getParameter("password");
        String role = req.getParameter("role");

        UserDao userDao = new UserDao();
        Users user = userDao.findUserByUsernameAndPassword(username, password);
        System.out.println(user);
        if (user != null && user.getRole().equals(role)) {
            req.getSession().setAttribute("user", user);
            switch (role) {
                case "Student":
                    req.getRequestDispatcher("student.jsp").forward(req, resp);
                    break;
                case "FacultyMember":
                	req.getRequestDispatcher("faculty.jsp").forward(req, resp);
                    break;
                case "Administrator":
                	req.getRequestDispatcher("admin.jsp").forward(req, resp);
                    break;
            }
        } else {
            resp.getWriter().print("<script>alert('Invalid Credentials');</script>");
            req.getRequestDispatcher("home.jsp").include(req, resp);
        }
    }
}