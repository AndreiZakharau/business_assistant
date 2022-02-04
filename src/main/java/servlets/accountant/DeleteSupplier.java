package servlets.accountant;

import dto.suppliersDto.SuppliersDto;
import service.SupplierService;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/accountant/deleteSupplier")
public class DeleteSupplier extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<SuppliersDto> suppliersList = SupplierService.getInstance().getAllSuppliers();
        request.setAttribute("suppliers",suppliersList);

        getServletContext().getRequestDispatcher("/accountant/deleteSupplier.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        SuppliersDto suppliersDto = SuppliersDto.builder()
                .id(Long.parseLong(request.getParameter("id")))
                .build();
        SupplierService.getInstance().deleteSupplier(suppliersDto);
        response.sendRedirect(request.getContextPath()+"/accountant/deleteSupplier");
    }
}
