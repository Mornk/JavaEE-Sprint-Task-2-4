package servlets;

import db.DBManager;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ChangeTaskServlet", value = "/changeTask")
public class ChangeTaskServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("idchange");
        String name = request.getParameter("taskname");
        String description = request.getParameter("taskdescription");
        String date = request.getParameter("taskdate");
        String status = request.getParameter("taskstatus");
        if (name!=null){
            DBManager.changeTaskName((Long.parseLong(id)),description);
        }
        if(description!=null){
            DBManager.changeTaskDescription((Long.parseLong(id)),description);
        }
        if(status!=null){
            DBManager.changeTaskStatus((Long.parseLong(id)),status);
        }
        if(date!=null){
            DBManager.changeTaskDeadline((Long.parseLong(id)),date);
        }
        response.sendRedirect("/");
    }
}
