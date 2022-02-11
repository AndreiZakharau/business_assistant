package servlets.salesperson;

import dao.impl.*;
import dto.categoriesDto.CategoriesDto;
import dto.expiredProductDto.ExpiredDto;
import dto.productDto.ProductDto;
import dto.shopDto.ShopDto;
import dto.suppliersDto.SuppliersDto;
import entity.*;
import service.*;

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

        List<CategoriesDto> categories = CategoriesService.getInstance().getAllCategories();
        request.setAttribute("categories", categories);
        List<SuppliersDto> suppliers = SupplierService.getInstance().getAllSuppliers();
        request.setAttribute("suppliers", suppliers);
        List<ShopDto> shops = ShopService.getInstance().getAllShop();
        request.setAttribute("shops", shops);
        List<ProductDto> products = ProductService.getInstance().getAllProducts();
        request.setAttribute("products", products);
        List<ExpiredDto> expiredProductList = ExpiredService.getInstance().getAllExpiredProduct();
        request.setAttribute("expiredProduct", expiredProductList);
        List<Order> orderList = OrderDAO.getInstance().findAll(); //TODO
        request.setAttribute("orders", orderList);
        getServletContext().getRequestDispatcher("/jsp/salesperson/salesperson_work.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ProductService.getInstance().updateProduct(ProductDto.builder()
                .id(Long.parseLong(request.getParameter("id")))
                .name(request.getParameter("name"))
                .categories(Long.parseLong(request.getParameter("categories_id")))
                .shop(Long.parseLong(request.getParameter("shop_id")))
                .suppliers(Long.parseLong(request.getParameter("suppliers_id")))
                .price(Double.parseDouble(request.getParameter("price")))
                .count(Integer.parseInt(request.getParameter("count")) - 1)
                .date(Date.valueOf(request.getParameter("date_expiration")))
                .localDate(LocalDate.parse(request.getParameter("delivery")))
                .build());
        response.sendRedirect(request.getContextPath() + "/salesperson/salespersonWork");

    }
}
