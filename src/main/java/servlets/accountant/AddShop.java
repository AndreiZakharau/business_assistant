package servlets.accountant;

import dto.shopDto.CreateShopDto;
import dto.shopDto.ShopDto;
import service.ShopService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/accountant/addShop")
public class AddShop extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/jsp/accountant/myShops.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        CreateShopDto createShopDto = CreateShopDto.builder()
                .nameShop(request.getParameter("nameShop"))
                .address(request.getParameter("address")).build();

        ShopService.getInstance().addShop(createShopDto);

        response.sendRedirect(request.getContextPath() + "/accountant/addShop");

    }
}
