package servlets;

import db.DBManager;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import models.Tasks;

import java.io.IOException;

@WebServlet(name = "DetailsTaskServlet", value = "/detailsTasks")
public class DetailsTaskServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Tasks task = DBManager.getTask(Long.parseLong(id));
        request.setAttribute("task",task);
        request.getRequestDispatcher("/detailsTasks.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
