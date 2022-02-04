package servlets.accountant;

import dto.categoriesDto.CategoriesDto;
import service.CategoriesService;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/accountant/updateCategories")
public class UpdateCategories extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<CategoriesDto> categories = CategoriesService.getInstance().getAllCategories();
        request.setAttribute("categories",categories);
         getServletContext().getRequestDispatcher("/accountant/updateCategories.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        CategoriesDto categoriesDto = CategoriesDto.builder().id(Long.parseLong(request.getParameter("id")))
                .category(request.getParameter("name"))
                .interest(Double.parseDouble(request.getParameter("interest")))
                        .build();
        CategoriesService.getInstance().updateCategory(categoriesDto);

        response.sendRedirect(request.getContextPath()+ "/accountant/updateCategories");
    }
}
