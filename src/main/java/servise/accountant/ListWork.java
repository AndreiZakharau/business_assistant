package servise.accountant;

import dao.impl.CategoriesDAO;
import dao.impl.ProductDAO;
import dao.impl.ShopDAO;
import dao.impl.SuppliersDAO;
import entity.Categories;
import entity.Products;
import entity.Shops;
import entity.Suppliers;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet( "/accountant/listWork")
public class ListWork extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Categories> categories = CategoriesDAO.getInstance().findAll();
        request.setAttribute("categories",categories);
        List<Suppliers> suppliers = SuppliersDAO.getInstance().findAll();
        request.setAttribute("suppliers",suppliers);
        List<Shops> shops = ShopDAO.getInstance().findAll();
        request.setAttribute("shops",shops);
        List<Products>products = ProductDAO.getInstance().findAll();
        request.setAttribute("products",products);
        getServletContext().getRequestDispatcher("/accountant/list_works.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
