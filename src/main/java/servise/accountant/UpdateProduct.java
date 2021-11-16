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
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@WebServlet("/accountant/updateProduct")
public class UpdateProduct extends HttpServlet {
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

        getServletContext().getRequestDispatcher("/accountant/updateProduct.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int count = Integer.parseInt(request.getParameter("count"));
        double price = Double.parseDouble(request.getParameter("price"));
        int categories = Integer.parseInt(request.getParameter("categories_id"));
        int suppliers = Integer.parseInt(request.getParameter("suppliers_id"));
        LocalDate localDate = LocalDate.parse(request.getParameter("delivery"));
        java.sql.Date date = Date.valueOf(request.getParameter("date_expiration"));
        int shops = Integer.parseInt(request.getParameter("shop_id"));
        Products products = new Products(id,name,count,price,categories,suppliers,localDate,date,shops);
        products.setName(name);
        products.setCount(count);
        products.setPrice(price);
        products.setCategories(categories);
        products.setSuppliers(suppliers);
        products.setLocalDate(localDate);
        products.setDate(date);
        products.setShop(shops);
        ProductDAO.getInstance().update(products);

        response.sendRedirect(request.getContextPath()+"/accountant/updateProduct");
    }
}
