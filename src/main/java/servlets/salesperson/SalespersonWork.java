package servlets.salesperson;

import dao.impl.*;
import entity.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@WebServlet("/salesperson/salespersonWork")
public class SalespersonWork extends HttpServlet {
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
        List<Order> orderList = OrderDAO.getInstance().findAll();
        request.setAttribute("orders",orderList);
        getServletContext().getRequestDispatcher("/salesperson/salesperson_work.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        long id = Long.parseLong(request.getParameter("id"));
        String name = request.getParameter("name");
        long categories = Long.parseLong(request.getParameter("categories_id"));
        long suppliers = Long.parseLong(request.getParameter("suppliers_id"));
        long shops = Long.parseLong(request.getParameter("shop_id"));
        double price = Double.parseDouble(request.getParameter("price"));
        LocalDate localDate1 = LocalDate.parse(request.getParameter("delivery"));
        java.sql.Date date = Date.valueOf(request.getParameter("date_expiration"));
        int count = Integer.parseInt(request.getParameter("count"))-1;
        Products products = new Products(id,name,count,price,categories,suppliers,localDate1,date,shops);
        products.setName(name);
        products.setCount(count);
        products.setPrice(price);
        products.setCategories(categories);
        products.setSuppliers(suppliers);
        products.setLocalDate(localDate1);
        products.setDate(date);
        products.setShop(shops);

    }
}
