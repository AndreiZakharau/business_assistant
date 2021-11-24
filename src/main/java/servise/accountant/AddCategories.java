package servise.accountant;

import dao.impl.CategoriesDAO;
import entity.Categories;
import jframes.ExistObject;
import jframes.ObjectAdded;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

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
        Categories category = CategoriesDAO.getInstance().finByName(nameC);

        if( category.getCategory()!=null && category.getCategory().equals(nameC)){
            new ExistObject();
        }else {
         CategoriesDAO categoriesDAO = new CategoriesDAO();
         categoriesDAO.add(categories);
         new ObjectAdded();
         }

        response.sendRedirect(request.getContextPath()+"/accountant/addCategories");

    }
}
