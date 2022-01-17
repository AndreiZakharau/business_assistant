package servlets.accountant;

import dao.impl.SuppliersDAO;
import entity.Suppliers;
import jframes.ObjectUpdate;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/accountant/updateSuppliers")
public class UpdateSuppliers extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Suppliers> suppliers = SuppliersDAO.getInstance().findAll();
        request.setAttribute("suppliers",suppliers);

        getServletContext().getRequestDispatcher("/accountant/updateSuppliers.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        long id = Long.parseLong(request.getParameter("id"));
        String name = request.getParameter("name");
        String phone = request.getParameter("contact_tel");
        String email = request.getParameter("email");
        Suppliers suppliers = new Suppliers(id,name,phone,email);
        suppliers.setId(id);
        suppliers.setNameSupplier(name);
        suppliers.setContactTel(phone);
        suppliers.setEmail(email);
        SuppliersDAO.getInstance().update(suppliers);

        new ObjectUpdate();
        response.sendRedirect(request.getContextPath()+"/accountant/updateSuppliers");
    }
}
