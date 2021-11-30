package servlets.accountant;

import dao.impl.ShopDAO;
import entity.Shops;
import jframes.ObjectUpdate;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/accountant/updateShop")
public class UpdateShop extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Shops> shopsList = ShopDAO.getInstance().findAll();
        request.setAttribute("shops",shopsList);

        getServletContext().getRequestDispatcher("/accountant/updateShop.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        long id = Long.parseLong(request.getParameter("id"));
        String name = request.getParameter("nameShop");
        String address = request.getParameter("address");
        Shops shops = new Shops(id,name,address);
        shops.setId(id);
        shops.setNameShop(name);
        shops.setAddress(address);
        ShopDAO.getInstance().update(shops);

        new ObjectUpdate();
        response.sendRedirect( request.getContextPath() + "/accountant/updateShop");
    }
}
