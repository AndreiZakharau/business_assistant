package servlets.salesperson;

import dto.productDto.ProductDto;

import service.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet( "/salesperson/addExpiredProductServlet")
public class AddExpiredProductServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ProductService.getInstance().deleteProduct(ProductDto.builder()
                .id(Long.parseLong(request.getParameter("id"))).build());

        response.sendRedirect(request.getContextPath() + "/salesperson/salespersonWork");
    }

}
