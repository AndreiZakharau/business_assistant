package servlets.accountant;

import dto.suppliersDto.CreateSuppliersDto;
import service.SupplierService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/accountant/addSuppliers")
public class AddSuppliers extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/jsp/accountant/addSuppliers.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        CreateSuppliersDto createSuppliersDto = CreateSuppliersDto.builder()
                .nameSupplier(request.getParameter("name"))
                .contactTel(request.getParameter("contact_tel"))
                .email(request.getParameter("email"))
                .build();
        SupplierService.getInstance().addSupplier(createSuppliersDto);


        response.sendRedirect(request.getContextPath() + "/accountant/addSuppliers");

    }
}
