package servlets.accountant;

import dto.categoriesDto.CategoriesDto;
import dto.productDto.CreateProductDto;
import dto.shopDto.ShopDto;
import dto.suppliersDto.SuppliersDto;
import service.CategoriesService;
import service.ProductService;
import service.ShopService;
import service.SupplierService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet("/accountant/addProduct")
public class AddProduct extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<CategoriesDto> categories = CategoriesService.getInstance().getAllCategories();
        request.setAttribute("categories",categories);
        List<SuppliersDto> suppliers = SupplierService.getInstance().getAllSuppliers();
        request.setAttribute("suppliers",suppliers);
        List<ShopDto> shops = ShopService.getInstance().getAllShop();
        request.setAttribute("shops",shops);

        getServletContext().getRequestDispatcher("/jsp/accountant/addProduct.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ProductService.getInstance().addProduct(CreateProductDto.builder()
                        .name(request.getParameter("name"))
                        .count(request.getParameter("count"))
                        .price(request.getParameter("price"))
                        .categories(request.getParameter("categories_id"))
                        .suppliers(request.getParameter("suppliers_id"))
                        .localDate(request.getParameter("delivery"))
                        .date(Date.valueOf(request.getParameter("date_expiration")))
                        .shop(request.getParameter("shop_id"))
                .build());


        response.sendRedirect(request.getContextPath() + "/accountant/addProduct");

    }
}
