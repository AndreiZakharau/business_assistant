package servise.accountant;

import dao.impl.ProductDAO;
import entity.Products;
import jframes.DeleteObject;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/accountant/deleteProduct")
public class DeleteProduct extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Products> productsList = ProductDAO.getInstance().findAll();
        request.setAttribute("products",productsList);

        getServletContext().getRequestDispatcher("/accountant/deleteProduct.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        Products products = new Products(id);
        products.setId(id);
        ProductDAO.getInstance().delete(products);

        new DeleteObject();
        response.sendRedirect(request.getContextPath()+"/accountant/deleteProduct");


    }
}
