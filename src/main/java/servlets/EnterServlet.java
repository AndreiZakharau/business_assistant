package servlets;

import dto.personDto.PersonDto;
import dto.personDto.PersonNamePhoneDto;
import entity.Person;
import service.PersonService;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/enterServlet")
public class EnterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<PersonDto> personList = PersonService.getInstance().getAllPerson();
        request.setAttribute("persons",personList);
        getServletContext().getRequestDispatcher("/jsp/registration.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

       Person person = PersonService.getInstance().enterPerson(PersonNamePhoneDto.builder()
                        .name(request.getParameter("name"))
                        .lastName(request.getParameter("lastName"))
                        .telephoneNumber(request.getParameter("telephoneNumber"))
                .build());

        HttpSession session = request.getSession();
        session.setAttribute( "name",person.getName());
        session.setAttribute("lastName",person.getLastName());
        session.setAttribute("telephoneNumber", person.getTelephoneNumber());
        session.setAttribute("id_shop",person.getShop());
        getServletContext().getRequestDispatcher("/roleServlet").forward(request,response);

    }
}
