package servlets;

import dao.impl.DirectorDAO;
import entity.Director;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/enter_director.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        Director director = DirectorDAO.getInstance().finDirectorByLoginAndPassword(login, password);

        if (director.getLogin().equals(login)) {
            if (director.getPassword().equals(password)) {
                if (session.getAttribute("login") == null && session.getAttribute("password") == null) {
                    session.setAttribute("login", login);
                    session.setAttribute("password", password);
                }
                getServletContext().getRequestDispatcher("/jsp/director/director.jsp").forward(request, response);
            } else {
                System.out.println("Не верный пароль"); //TODO
            }
        } else {
            System.out.println("Не верный Login"); //TODO
        }

    }
}
