package servlets.accountant;


import dto.categoriesDto.CategoriesDto;
import dto.productDto.ProductDto;
import dto.shopDto.ShopDto;
import dto.suppliersDto.SuppliersDto;
import service.CategoriesService;
import service.ProductService;
import service.ShopService;
import service.SupplierService;

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

        List<CategoriesDto> categories = CategoriesService.getInstance().getAllCategories();
        request.setAttribute("categories", categories);
        List<SuppliersDto> suppliers = SupplierService.getInstance().getAllSuppliers();
        request.setAttribute("suppliers", suppliers);
        List<ShopDto> shops = ShopService.getInstance().getAllShop();
        request.setAttribute("shops", shops);
        List<ProductDto> products = ProductService.getInstance().getAllProducts();
        request.setAttribute("products", products);
        getServletContext().getRequestDispatcher("/jsp/accountant/updateProduct.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ProductDto productDto = ProductDto.builder().id(Long.parseLong(request.getParameter("id")))
                .name(request.getParameter("name"))
                .categories(Long.parseLong(request.getParameter("categories_id")))
                .count(Integer.parseInt(request.getParameter("count")))
                .price(Double.parseDouble(request.getParameter("price")))
                .localDate(LocalDate.parse(request.getParameter("delivery")))
                .date(Date.valueOf(request.getParameter("date_expiration")))
                .suppliers(Long.parseLong(request.getParameter("suppliers_id")))
                .shop(Long.parseLong(request.getParameter("shop_id")))
                .build();

        ProductService.getInstance().updateProduct(productDto);

        response.sendRedirect(request.getContextPath() + "/accountant/updateProduct");
    }
}
