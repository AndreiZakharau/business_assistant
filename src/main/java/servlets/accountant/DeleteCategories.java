package servlets.accountant;

import dao.impl.CategoriesDAO;
import dto.categoriesDto.CategoriesDto;
import entity.Categories;
import jframes.DeleteObject;
import service.CategoriesService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/accountant/deleteCategories")
public class DeleteCategories extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<CategoriesDto> categoriesList = CategoriesService.getInstance().getAllCategories();
        request.setAttribute("categories",categoriesList);

        getServletContext().getRequestDispatcher("/accountant/deleteCategories.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        CategoriesDto categoriesDto = CategoriesDto.builder()
                .id(Long.parseLong(request.getParameter("id")))
                .build();
        CategoriesService.getInstance().deleteCategory(categoriesDto);

        response.sendRedirect(request.getContextPath()+"/accountant/deleteCategories");
    }
}
