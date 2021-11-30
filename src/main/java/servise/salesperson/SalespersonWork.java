package servise.salesperson;

import dao.impl.*;
import entity.*;
import jframes.ObjectUpdate;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
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

        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int categories = Integer.parseInt(request.getParameter("categories_id"));
        int suppliers = Integer.parseInt(request.getParameter("suppliers_id"));
        int shops = Integer.parseInt(request.getParameter("shop_id"));
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

        int quantum;
        int number;
        double sum;
        int idProduct;
        if(request.getParameter("number") == null){
            number = 1;
        }else {
            number = Integer.parseInt(request.getParameter("number"));
        }
        if(request.getParameter("product") == null ) {
            idProduct = id;
        } else {
            idProduct = Integer.parseInt(request.getParameter("idOrder"));
        }
//            } else {
//            idProduct = Integer.parseInt(request.getParameter("idOrder"))+1;
//            }
        String product = name;
        if(request.getParameter("quantum") == null || Integer.parseInt(request.getParameter("idOrder")) != id){
            quantum = 1;
        }else {
            quantum = Integer.parseInt(request.getParameter("quantum")) + 1;
        }
        LocalDate localDate = LocalDate.now();
//        LocalTime localTime = LocalTime.now();
        double interest = Double.parseDouble(request.getParameter("interest"));
        double priceFinal = price + (price * interest / 100);
        if(request.getParameter("sum") == null ){
            sum = priceFinal * quantum;
        }else {
            sum = Double.parseDouble(request.getParameter("sum")) + (priceFinal * quantum);
        }
        String nameSalesperson = request.getParameter("nameSalesperson");
        String nameShop = request.getParameter("nameShop");

        Order order = new Order(number,idProduct,product,quantum,localDate,priceFinal,sum,nameSalesperson,nameShop);
        order.setNumber(number);
        order.setId(idProduct);
        order.setProduct(product);
        order.setQuantum(quantum);
        order.setLocalDate(localDate);
//        order.setLocalTime(localTime);
        order.setPriceFinal(priceFinal);
        order.setSum(sum);
        order.setNameSalesperson(nameSalesperson);
        order.setNameShop(nameShop);
        if (request.getParameter("numberNew") == null){
            if(request.getParameter("number")==null || request.getParameter("idOrder")==null){
                ProductDAO.getInstance().update(products);
                OrderDAO.getInstance().add(order);

                response.sendRedirect(request.getContextPath()+"/salesperson/salespersonWork");
            }else {
                ProductDAO.getInstance().update(products);
                OrderDAO.getInstance().update(order);
                response.sendRedirect(request.getContextPath()+"/salesperson/salespersonWork");
            }
        }else {
            ProductDAO.getInstance().update(products);
            OrderDAO.getInstance().add(order);
            response.sendRedirect(request.getContextPath()+"/salesperson/printOrder");
        }



    }
}
