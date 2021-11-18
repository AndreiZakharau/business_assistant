package servise.accountant;


import dao.impl.ShopDAO;

import entity.Shops;
import jframes.DeleteObject;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet( "/accountant/deleteShop")
public class DeleteShop extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Shops> shopsList = ShopDAO.getInstance().findAll();
        request.setAttribute("shops",shopsList);

        getServletContext().getRequestDispatcher("/accountant/deleteShop.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        Shops shops = new Shops();
        shops.setId(id);
        ShopDAO.getInstance().delete(shops);

        new DeleteObject();
        response.sendRedirect(request.getContextPath()+"/accountant/deleteShop");

    }
}
