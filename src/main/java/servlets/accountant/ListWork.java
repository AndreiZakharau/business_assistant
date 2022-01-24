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
import java.util.List;

@WebServlet( "/accountant/listWork")
public class ListWork extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<CategoriesDto> categories = CategoriesService.getInstance().getAllCategories();
        request.setAttribute("categories",categories);
        List<SuppliersDto> suppliers = SupplierService.getInstance().getAllSuppliers();
        request.setAttribute("suppliers",suppliers);
        List<ShopDto> shops = ShopService.getInstance().getAllShop();
        request.setAttribute("shops",shops);
        List<ProductDto>products = ProductService.getInstance().getAllProducts();
        request.setAttribute("products",products);
        getServletContext().getRequestDispatcher("/accountant/list_works.jsp").forward(request,response);

    }

}
