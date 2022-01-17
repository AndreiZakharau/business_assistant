package servlets.accountant;

import dao.impl.CategoriesDAO;
import entity.Categories;
import jframes.ObjectUpdate;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/accountant/updateCategories")
public class UpdateCategories extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Categories> categories = CategoriesDAO.getInstance().findAll();
        request.setAttribute("categories",categories);
         getServletContext().getRequestDispatcher("/accountant/updateCategories.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        long id = Long.parseLong(request.getParameter("id"));
        String name = request.getParameter("name");
        double interest = Double.parseDouble(request.getParameter("interest"));
        Categories categories = new Categories(id,name,interest);
        CategoriesDAO.getInstance().update(categories);

        new ObjectUpdate();
        response.sendRedirect(request.getContextPath()+ "/accountant/updateCategories");
    }
}
