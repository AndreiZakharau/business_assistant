package servlets.director;

import dto.personDto.CreatePersonDto;
import dto.shopDto.ShopDto;
import entity.Role;
import service.PersonService;
import service.ShopService;

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
        List<ShopDto> listShops = ShopService.getInstance().getAllShop();
        req.setAttribute("id_shop", listShops);
        List<Role> roles = List.of(Role.ACCOUNTANT, Role.DIRECTOR, Role.SALESPERSON);
        req.setAttribute("role_role", roles);
        getServletContext().getRequestDispatcher("/jsp/director/addPerson.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PersonService.getInstance().addPerson(CreatePersonDto.builder()
                .name(req.getParameter("name"))
                .lastName(req.getParameter("lastName"))
                .telephoneNumber(req.getParameter("telephoneNumber"))
                .role(req.getParameter("role"))
                .shop(req.getParameter("shop"))
                .build());


        resp.sendRedirect(req.getContextPath() + "/director/addPerson");
    }
}
