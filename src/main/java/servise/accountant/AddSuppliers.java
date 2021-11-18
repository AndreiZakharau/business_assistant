package servise.accountant;

import dao.impl.SuppliersDAO;
import entity.Suppliers;
import jframes.ExistObject;
import jframes.ObjectAdded;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/accountant/addSuppliers")
public class AddSuppliers extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     getServletContext().getRequestDispatcher("/accountant/addSuppliers.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String tel = request.getParameter("contact_tel");
        String email = request.getParameter("email");
        Suppliers suppliers = new Suppliers();
        suppliers.setNameSupplier(name);
        suppliers.setContactTel(tel);
        suppliers.setEmail(email);
        Suppliers supplier = SuppliersDAO.getInstance().finByName(name);
        if(supplier.getNameSupplier() != null && supplier.getNameSupplier().equals(name)){
            new ExistObject();
        }else {
            SuppliersDAO suppliersDAO = new SuppliersDAO();
            suppliersDAO.add(suppliers);
            new ObjectAdded();
        }

        response.sendRedirect(request.getContextPath()+"/accountant/addSuppliers");

    }
}
