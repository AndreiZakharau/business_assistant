package servlets.accountant;

import dto.productDto.ProductDto;
import service.ProductService;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/accountant/deleteProduct")
public class DeleteProduct extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<ProductDto> productsList = ProductService.getInstance().getAllProducts();
        request.setAttribute("products",productsList);

        getServletContext().getRequestDispatcher("/accountant/deleteProduct.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ProductService.getInstance().deleteProduct(ProductDto.builder()
                .id(Long.parseLong(request.getParameter("id"))).build());

        response.sendRedirect(request.getContextPath()+"/accountant/deleteProduct");


    }
}
