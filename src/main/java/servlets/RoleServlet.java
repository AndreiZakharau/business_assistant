package servlets;

import dao.impl.PersonDAO;
import entity.Person;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Random;

import static entity.Role.*;

@WebServlet("/roleServlet")
public class RoleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


            String name =request.getParameter("name");
            String lastName =request.getParameter("lastName");
            String telephoneNumber =request.getParameter("telephoneNumber");
            Person person = PersonDAO.getInstance().findByNamesAndPhone(name,lastName,telephoneNumber);
            if(person.getRole().equals(SALESPERSON)){

                response.sendRedirect(request.getContextPath()+"/salesperson/salesperson_menu.jsp");
            }else if (person.getRole().equals(DIRECTOR)){
                response.sendRedirect(request.getContextPath()+"/loginServlet");
            }else if (person.getRole().equals(ACCOUNTANT)){
                response.sendRedirect(request.getContextPath()+"/accountant/accountant_menu.jsp");
            }

        }

}
