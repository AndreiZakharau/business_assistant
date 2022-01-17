package servlets.director;

import dao.impl.PersonDAO;
import entity.Person;
import entity.Role;
import jframes.ObjectUpdate;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/director/updatePerson")
public class UpdatePerson extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Person> person = PersonDAO.getInstance().findAll();
        request.setAttribute("person",person);

        List<Role> roles = List.of(Role.ACCOUNTANT,Role.DIRECTOR,Role.SALESPERSON);
        request.setAttribute("role_role",roles);
        getServletContext().getRequestDispatcher("/director/updatePerson.jsp").forward(request,response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long id = Long.parseLong(request.getParameter("id"));
        String name = request.getParameter("name");
        String lastName = request.getParameter("lastName");
        String telephoneNumber = request.getParameter("telephoneNumber");
        Role role = Role.valueOf(request.getParameter("role"));
        Person person = new Person(name,lastName,telephoneNumber,role);
        person.setId(id);
        person.setName(name);
        person.setLastName(lastName);
        person.setTelephoneNumber(telephoneNumber);
        person.setRole(role);
        PersonDAO.getInstance().update(person);
        new ObjectUpdate();
        response.sendRedirect(request.getContextPath()+"/director/updatePerson");

    }
}
