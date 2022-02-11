package filter;


import dao.impl.PersonDAO;
import entity.Person;
import entity.Role;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = "/accountant/*")
public class SecurityAccountant implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;


        if (isAccountantEnter(httpServletRequest)) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            httpServletResponse.sendRedirect("/enterServlet");
        }
    }

    private boolean isAccountantEnter(HttpServletRequest httpServletRequest) {
        boolean enter = false;
        HttpSession session = httpServletRequest.getSession();

        String name = (String) session.getAttribute("name");
        String lastName = (String) session.getAttribute("lastName");
        String telephoneNumber = (String) session.getAttribute("telephoneNumber");
        Person person = PersonDAO.getInstance().findByNamesAndPhone(name, lastName, telephoneNumber);

        if (person != null && person.getRole() == Role.ACCOUNTANT) {
            enter = true;
        }
        return enter;

    }
}
