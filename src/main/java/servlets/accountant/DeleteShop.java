package servlets.accountant;


import dao.impl.ShopDAO;

import dto.shopDto.ShopDto;
import entity.Shops;
import service.ShopService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/accountant/deleteShop")
public class DeleteShop extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<ShopDto> shopsList = ShopService.getInstance().getAllShop();
        request.setAttribute("shops", shopsList);

        getServletContext().getRequestDispatcher("/jsp/accountant/deleteShop.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ShopDto shopDto = ShopDto.builder().id(Long.parseLong(request.getParameter("id"))).build();
        ShopService.getInstance().deleteShop(shopDto);

        response.sendRedirect(request.getContextPath() + "/accountant/deleteShop");

    }
}
