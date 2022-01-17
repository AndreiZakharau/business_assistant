package servlets.accountant;

import dao.impl.ShopDAO;
import entity.Shops;
import jframes.ExistObject;
import jframes.ObjectAdded;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/accountant/addShop")
public class AddShop extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       getServletContext().getRequestDispatcher("/accountant/myShops.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


            String nameShop = request.getParameter("nameShop");
            String address = request.getParameter("address");
            Shops shops = new Shops(nameShop,address);
            shops.setNameShop(nameShop);
            shops.setAddress(address);
            Shops shop = ShopDAO.getInstance().finByName(nameShop);
            if(shop.getNameShop() != null && shop.getNameShop().equals(nameShop)){
                new ExistObject();
            }else {
                ShopDAO.getInstance().add(shops);
                new ObjectAdded();
            }

            response.sendRedirect(request.getContextPath()+"/accountant/addShop");

    }
}
