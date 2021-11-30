package servlets.accountant;


import dao.impl.SuppliersDAO;
import entity.Suppliers;
import jframes.DeleteObject;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/accountant/deleteSupplier")
public class DeleteSupplier extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Suppliers> suppliersList = SuppliersDAO.getInstance().findAll();
        request.setAttribute("suppliers",suppliersList);

        getServletContext().getRequestDispatcher("/accountant/deleteSupplier.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        long id = Long.parseLong(request.getParameter("id"));
        Suppliers suppliers = new Suppliers();
        suppliers.setId(id);
        SuppliersDAO.getInstance().delete(suppliers);

        new DeleteObject();
        response.sendRedirect(request.getContextPath()+"/accountant/deleteSupplier");
    }
}
