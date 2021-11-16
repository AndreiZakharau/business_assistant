package servise.accountant;

import dao.impl.CategoriesDAO;
import entity.Categories;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/accountant/deleteCategories")
public class DeleteCategories extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Categories> categoriesList = CategoriesDAO.getInstance().findAll();
        request.setAttribute("categories",categoriesList);

        getServletContext().getRequestDispatcher("/accountant/deleteCategories.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        Categories categories = new Categories(id);
        categories.setId(id);
        CategoriesDAO.getInstance().delete(categories);
        response.sendRedirect(request.getContextPath()+"/accountant/deleteCategories");
    }
}
