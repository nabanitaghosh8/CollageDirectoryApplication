package com.collegedirectory.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.collagedirectory.dao.DepartmentDao;
import com.collagedirectory.dao.StudentDao;
import com.collagedirectory.dao.UserDao;
import com.collagedirectory.dto.Department;
import com.collagedirectory.dto.StudentProfile;
import com.collagedirectory.dto.Users;

@WebServlet("/manageStudent")
public class ManageStudentServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action=req.getParameter("action");
		
		if(action.equals("addUpdateStudent")) {
			String name=req.getParameter("name");
			String email=req.getParameter("email");
			String year=req.getParameter("year");
			String dept=req.getParameter("department");
			String description=req.getParameter("description");
			String username=req.getParameter("username");
			String password=req.getParameter("password");
			Long mob=Long.parseLong(req.getParameter("mob"));
			Department d=new Department();
			d.setName(dept);
			d.setDescription(description);
			DepartmentDao dao2=new DepartmentDao();
			dao2.addDepartment(d);
			Users u =new Users();
			u.setName(name);
			u.setEmail(email);
			u.setPassword(password);
			u.setUsername(username);
			u.setMobile(mob);
			u.setRole("Student");
			UserDao dao3=new UserDao();
			dao3.save(u);
			StudentProfile s=new StudentProfile();
			s.setUser(u);
			s.setDepartment(d);
			s.setYear(year);
			StudentDao dao=new StudentDao();
			dao.addStudent(s);
			resp.getWriter().print("<script>alert('Student data saved');</script>");
			req.getRequestDispatcher("admin.jsp").include(req, resp);
			
		}
		else if(action.equals("removeStudent")) {
			Long id=Long.parseLong(req.getParameter("removeStudentId"));
			StudentDao dao=new StudentDao();
			StudentProfile s=dao.findbyId(id);
			if(s!=null) {
				dao.removeStudent(s);
				resp.getWriter().print("<script>alert('Student data Deleted');</script>");
				req.getRequestDispatcher("admin.jsp").include(req, resp);
			}
			else {
				resp.getWriter().print("<script>alert('Student data not Present');</script>");
				req.getRequestDispatcher("admin.jsp").include(req, resp);
			}
			
			
		}
	}
}
