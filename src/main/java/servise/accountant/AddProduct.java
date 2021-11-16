package servise.accountant;


import dao.impl.CategoriesDAO;
import dao.impl.ProductDAO;
import dao.impl.ShopDAO;
import dao.impl.SuppliersDAO;
import entity.Categories;
import entity.Products;
import entity.Shops;
import entity.Suppliers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@WebServlet("/accountant/addProduct")
public class AddProduct extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Categories> categories = CategoriesDAO.getInstance().findAll();
        request.setAttribute("categories",categories);
        List<Suppliers> suppliers = SuppliersDAO.getInstance().findAll();
        request.setAttribute("suppliers",suppliers);
        List<Shops> shops = ShopDAO.getInstance().findAll();
        request.setAttribute("shops",shops);

        getServletContext().getRequestDispatcher("/accountant/addProduct.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String name = request.getParameter("name");
        int count = Integer.parseInt(request.getParameter("count"));
        double price = Double.parseDouble(request.getParameter("price"));
        int categories = Integer.parseInt(request.getParameter("categories_id"));
        int suppliers = Integer.parseInt(request.getParameter("suppliers_id"));
        LocalDate localDate = LocalDate.parse(request.getParameter("delivery"));
        Date date = Date.valueOf(request.getParameter("date_expiration"));
        int shops = Integer.parseInt(request.getParameter("shop_id"));
        Products products = new Products(name,count,price,categories,suppliers,localDate,date,shops);
        products.setName(name);
        products.setCount(count);
        products.setPrice(price);
        products.setCategories(categories);
        products.setSuppliers(suppliers);
        products.setLocalDate(localDate);
        products.setDate(date);
        products.setShop(shops);
        ProductDAO.getInstance().add(products);
        response.sendRedirect(request.getContextPath()+"/accountant/addProduct");

    }
}
