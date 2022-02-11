package servlets.accountant;

import dto.categoriesDto.CreateCategoriesDto;
import service.CategoriesService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/accountant/addCategories")
public class AddCategories extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/jsp/accountant/addCategories.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        CreateCategoriesDto createCategoriesDto = CreateCategoriesDto.builder()
                .category(request.getParameter("name"))
                .interest(request.getParameter("interest"))
                .build();
        CategoriesService.getInstance().addCategory(createCategoriesDto);

        response.sendRedirect(request.getContextPath() + "/accountant/addCategories");

    }
}
