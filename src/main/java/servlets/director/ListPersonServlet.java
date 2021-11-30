package servlets.director;

import dao.impl.PersonDAO;
import entity.Person;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/director/listPersonServlet")
public class ListPersonServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Person> person = PersonDAO.getInstance().findAll();
        request.setAttribute("person",person);
        getServletContext().getRequestDispatcher("/director/listPerson.jsp").forward(request,response);
    }

}
