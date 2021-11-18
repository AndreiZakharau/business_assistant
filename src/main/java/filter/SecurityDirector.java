package filter;

import dao.impl.DirectorDAO;
import entity.Director;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = "/director/*")
public class SecurityDirector implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        if(isDirectorEnter(httpServletRequest)){
            filterChain.doFilter(servletRequest,servletResponse);
        }else {
            httpServletResponse.sendRedirect("/enter_director.jsp");
        }
    }

    private boolean isDirectorEnter(HttpServletRequest httpServletRequest){
        boolean enter = false;
        HttpSession session = httpServletRequest.getSession();
        String login = (String) session.getAttribute("login");
        String password = (String) session.getAttribute("password");
        Director director = DirectorDAO.getInstance().finDirectorByLoginAndPassword(login,password);

        if(director.getPassword() != null && director.getPassword() != null && director.getLogin().equals(login) && director.getPassword().equals(password)) {
            enter = true;
        }
        return enter;
    }
}
