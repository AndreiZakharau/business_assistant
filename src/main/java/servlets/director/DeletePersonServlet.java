package servlets.director;

import dto.personDto.PersonDto;
import service.PersonService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/director/deletePersonServlet")
public class DeletePersonServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<PersonDto> person = PersonService.getInstance().getAllPerson();
        request.setAttribute("person", person);

        getServletContext().getRequestDispatcher("/jsp/director/deletePerson.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PersonService.getInstance().deletePerson(PersonDto.builder()
                .id(Long.parseLong(request.getParameter("id")))
                .build());

        response.sendRedirect(request.getContextPath() + ("/director/deletePersonServlet"));
    }
}
