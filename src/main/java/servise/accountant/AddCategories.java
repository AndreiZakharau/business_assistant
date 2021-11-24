package servise.accountant;

import dao.impl.CategoriesDAO;
import entity.Categories;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/accountant/addCategories")
public class AddCategories extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/accountant/addCategories.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     String nameC = request.getParameter("name");
     Categories categories = new Categories();
     categories.setCategory(nameC);
        CategoriesDAO categoriesDAO = new CategoriesDAO();
        categoriesDAO.add(categories);
        response.sendRedirect(request.getContextPath()+"/accountant/addCategories"); //todo
    }
}
