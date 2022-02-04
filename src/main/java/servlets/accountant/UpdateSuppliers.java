package servlets.accountant;


import dto.suppliersDto.SuppliersDto;
import service.SupplierService;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/accountant/updateSuppliers")
public class UpdateSuppliers extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<SuppliersDto> suppliers = SupplierService.getInstance().getAllSuppliers();
        request.setAttribute("suppliers",suppliers);

        getServletContext().getRequestDispatcher("/accountant/updateSuppliers.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        SuppliersDto suppliersDto = SuppliersDto.builder()
                .id( Long.parseLong(request.getParameter("id")))
                .nameSupplier(request.getParameter("name"))
                .contactTel(request.getParameter("contact_tel"))
                .email(request.getParameter("email"))
                .build();
        SupplierService.getInstance().updateSupplier(suppliersDto);

        response.sendRedirect(request.getContextPath()+"/accountant/updateSuppliers");
    }
}
