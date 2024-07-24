<%@page import="com.collagedirectory.dao.UserDao"%>
<%@page import="com.collagedirectory.dto.Users"%>
<%@page import="java.util.List"%>
<%@page import="com.collagedirectory.dto.StudentProfile"%>
<%@page import="com.collagedirectory.dao.StudentDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Manage Records</title>
    <link rel="stylesheet" href="CSS/admin.css">
</head>
<body>
    <div class="container">
        <h2>Manage Student and Faculty Records</h2>

        <h3>Add/Update Student</h3>
        <form action="manageStudent" method="post">
            <input type="hidden" name="action" value="addUpdateStudent">
            <label for="studentName">Name:</label>
            <input type="text" id="studentName" name="name">

            <label for="studentEmail">Email:</label>
            <input type="email" id="studentEmail" name="email">
            <label for="mob">Mobile:</label>
            <input type="tel" id="mob" name="mob">
			<label for="userName">Username:</label>
            <input type="text" id="userName" name="username">
            <label for="password">Password:</label>
            <input type="password" id="password" name="password">
            <label for="studentDepartment">Department:</label>
            <input type="text" id="studentDepartment" name="department">
            
			<label for="studentDepartmentdesc">Department Description:</label>
            <input type="text" id="studentDepartmentdesc" name="description">
            
            <label for="studentYear">Year:</label>
            <input type="text" id="studentYear" name="year">

            <button type="submit">Submit</button>
        </form>

        <h3>Remove Student</h3>
        <form action="manageStudent" method="post">
            <input type="hidden" name="action" value="removeStudent">
            <label for="removeStudentId">Student ID:</label>
            <input type="text" id="removeStudentId" name="id">

            <button type="submit">Remove</button>
        </form>

        <h3>Student Records</h3>
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Department</th>
                    <th>Year</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <%-- Fetch and display student records --%>
                <% StudentDao dao=new StudentDao();
                List<StudentProfile>list=dao.findAll(); 
                if(list != null && !list.isEmpty()){
                	
                
                for(StudentProfile s:list){%>
                
                    <tr>
                        <td><%=s.getId()%></td>
                        <% UserDao dao2=new UserDao();
                        Users u=dao2.findById(s.getUser().getId()); %>
                        <td><%=u.getName()%></td>
                        <td><%=u.getEmail()%></td>
                        <td><%=s.getDepartment()%></td>
                        <td><%=s.getYear()%></td>
                        <td>
                            <a href="editStudent?id=<%=s.getId()%>">Edit</a> |
                            <a href="manageStudent?action=removeStudent&id=<%=s.getId()%>">Remove</a>
                        </td>
                    </tr>
                <%}} %>
            </tbody>
        </table>

        <h3>Add/Update Faculty</h3>
        <form action="manageFaculty" method="post">
            <input type="hidden" name="action" value="addUpdateFaculty">

            <label for="facultyName">Name:</label>
            <input type="text" id="facultyName" name="name">

            <label for="facultyEmail">Email:</label>
            <input type="email" id="facultyEmail" name="email">

            <label for="facultyDepartment">Department:</label>
            <input type="text" id="facultyDepartment" name="department">

            <button type="submit">Submit</button>
        </form>

        <h3>Remove Faculty</h3>
        <form action="manageFaculty" method="post">
            <input type="hidden" name="action" value="removeFaculty">
            <label for="removeFacultyId">Faculty ID:</label>
            <input type="text" id="removeFacultyId" name="id">

            <button type="submit">Remove</button>
        </form>

        <h3>Faculty Records</h3>
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Department</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <%-- Fetch and display faculty records --%>
                <c:forEach var="faculty" items="${faculties}">
                    <tr>
                        <td>${faculty.id}</td>
                        <td>${faculty.name}</td>
                        <td>${faculty.email}</td>
                        <td>${faculty.department}</td>
                        <td>
                            <a href="editFaculty?id=${faculty.id}">Edit</a> |
                            <a href="manageFaculty?action=removeFaculty&id=${faculty.id}">Remove</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
