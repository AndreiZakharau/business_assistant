package servlets;

import dao.impl.ShopDAO;
import entity.Shops;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/AddShopServlet")
public class AddShopServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       getServletContext().getRequestDispatcher("/myShops.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


            String nameShop = request.getParameter("nameShop");
            String address = request.getParameter("address");
            Shops shops = new Shops(nameShop,address);
            shops.setNameShop(nameShop);
            shops.setAddress(address);
            request.setAttribute("shops",shops);
            ShopDAO shopDAO = new ShopDAO();
            shopDAO.add(shops);
            response.sendRedirect(request.getContextPath()+"/index.jsp");


//            getServletContext().getRequestDispatcher("/myShops.jsp").forward(request, response);


    }
}
