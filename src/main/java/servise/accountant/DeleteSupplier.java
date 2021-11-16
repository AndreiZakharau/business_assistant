package servise.accountant;


import dao.impl.SuppliersDAO;
import entity.Suppliers;

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

        int id = Integer.parseInt(request.getParameter("id"));
        Suppliers suppliers = new Suppliers(id);
        suppliers.setId(id);
        SuppliersDAO.getInstance().delete(suppliers);

        response.sendRedirect(request.getContextPath()+"/accountant/deleteSupplier");
    }
}
