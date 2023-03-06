package servlets;

import db.DBManager;
import models.Tasks;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name= "AddTaskServlet", value = "/addTask")
public class AddTaskServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/addTask.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("taskname");
        String description = request.getParameter("taskdescription");
        String date = request.getParameter("taskdate");
        String status = "Not Done";;
        Tasks task = new Tasks();
        task.setName(name);
        task.setDescription(description);
        task.setDeadlineDate(date);
        task.setStatus(status);
        DBManager.addTask(task);
        response.sendRedirect("/");
    }
}