package servlets.director;

import dto.personDto.PersonDto;
import service.PersonService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/director/listPersonServlet")
public class ListPersonServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<PersonDto> person = PersonService.getInstance().getAllPerson();
        request.setAttribute("person", person);
        getServletContext().getRequestDispatcher("/jsp/director/listPerson.jsp").forward(request, response);
    }

}
