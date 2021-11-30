package servlets.director;

import dao.impl.PersonDAO;
import entity.Person;
import jframes.DeleteObject;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/director/deletePersonServlet")
public class DeletePersonServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Person> person = PersonDAO.getInstance().findAll();
        request.setAttribute("person", person);

        getServletContext().getRequestDispatcher("/director/deletePerson.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        long id = Long.parseLong(request.getParameter("id"));
        Person person = new Person(id);
        person.setId(id);
        PersonDAO.getInstance().delete(person);
        new DeleteObject();
        response.sendRedirect(request.getContextPath()+("/director/deletePersonServlet"));
    }
}
