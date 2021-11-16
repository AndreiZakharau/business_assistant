package servlets;

import dao.impl.PersonDAO;
import entity.Person;
import entity.Role;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;


@WebServlet("/enterServlet")
public class EnterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/registration.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


       String name =request.getParameter("name");
       String lastName =request.getParameter("lastName");
       String telephoneNumber =request.getParameter("telephoneNumber");
       Person person = PersonDAO.getInstance().findByAllParameters(name,lastName,telephoneNumber);
           if(person.getName().equals(name)){
           if(person.getLastName().equals(lastName)){
           }else {
               response.sendRedirect(request.getContextPath() + "/error.jsp");
           }
               if (person.getTelephoneNumber().equals(telephoneNumber)){
                   HttpSession session = request.getSession();
                   session.setAttribute("name",name);
                   session.setAttribute("lastName",lastName);
                   session.setAttribute("telephoneNumber",telephoneNumber);
                   getServletContext().getRequestDispatcher("/roleServlet").forward(request,response);
                   }else {
                   response.sendRedirect(request.getContextPath() + "/error.jsp");
               }
       }else{
           response.sendRedirect(request.getContextPath()+"/error.jsp");
       }


    }
}
