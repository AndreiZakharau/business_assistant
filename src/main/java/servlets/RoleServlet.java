package servlets;

import dao.impl.PersonDAO;
import dto.personDto.PersonNamePhoneDto;
import entity.Person;
import service.PersonService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Random;

import static entity.Role.*;

@WebServlet("/roleServlet")
public class RoleServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        Person person = PersonService.getInstance().enterPerson(PersonNamePhoneDto.builder()
                .name(request.getParameter("name"))
                .lastName(request.getParameter("lastName"))
                .telephoneNumber(request.getParameter("telephoneNumber"))
                .build());
            if(person.getRole().equals(SALESPERSON)){
                response.sendRedirect(request.getContextPath()+"/salesperson/salesperson_menu.jsp");
            }else if (person.getRole().equals(DIRECTOR)){
                response.sendRedirect(request.getContextPath()+"/loginServlet");
            }else if (person.getRole().equals(ACCOUNTANT)){
                response.sendRedirect(request.getContextPath()+"/accountant/accountant_menu.jsp");
            }

        }

}
