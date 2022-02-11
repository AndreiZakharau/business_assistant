package servlets.director;

import dto.personDto.PersonDto;
import dto.shopDto.ShopDto;
import entity.Role;
import service.PersonService;
import service.ShopService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/director/updatePerson")
public class UpdatePerson extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<PersonDto> person = PersonService.getInstance().getAllPerson();
        request.setAttribute("person", person);
        List<ShopDto> shops = ShopService.getInstance().getAllShop();
        request.setAttribute("id_shop", shops);
        List<Role> roles = List.of(Role.ACCOUNTANT, Role.DIRECTOR, Role.SALESPERSON);
        request.setAttribute("role_role", roles);
        getServletContext().getRequestDispatcher("/jsp/director/updatePerson.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PersonService.getInstance().updatePerson(PersonDto.builder()
                .id(Long.parseLong(request.getParameter("id")))
                .name(request.getParameter("name"))
                .lastName(request.getParameter("lastName"))
                .telephoneNumber(request.getParameter("telephoneNumber"))
                .role(Role.valueOf(request.getParameter("role")))
                .shop(Long.parseLong(request.getParameter("shop")))
                .build());

        response.sendRedirect(request.getContextPath() + "/director/updatePerson");

    }
}
