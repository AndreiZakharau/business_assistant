package servise.director;

import dao.impl.PersonDAO;
import entity.Person;
import entity.Role;
import jframes.ExistObject;
import jframes.ObjectAdded;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/director/addPerson")
public class AddPerson extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Role> roles = List.of(Role.ACCOUNTANT,Role.DIRECTOR,Role.SALESPERSON);
        req.setAttribute("role_role",roles);
        getServletContext().getRequestDispatcher("/director/addPerson.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String name = req.getParameter("name");
       String lastName = req.getParameter("lastName");
       String telephoneNumber = req.getParameter("telephoneNumber");
       Role role = Role.valueOf(req.getParameter("role"));
       Person person = new Person(name,lastName,telephoneNumber,role);
       person.setName(name);
       person.setLastName(lastName);
       person.setTelephoneNumber(telephoneNumber);
       person.setRole(role);
       Person persons = PersonDAO.getInstance().findByAllParameters(name,lastName,telephoneNumber);
       if(persons.getName() != null && persons.getLastName() != null && persons.getTelephoneNumber() != null
       && (persons.getName().equals(name) && persons.getLastName().equals(lastName) && persons.getTelephoneNumber().equals(telephoneNumber))){
           new ExistObject();
        }else{
           PersonDAO.getInstance().add(person);
           new ObjectAdded();
        }

       resp.sendRedirect(req.getContextPath()+"/director/addPerson");
    }
}
