package servlets.salesperson;

import dao.impl.OrderDAO;
import entity.Order;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet("/salesperson/printOrder")
public class PrintOrder extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Order> orderList = OrderDAO.getInstance().maxNumber();
        request.setAttribute("orders", orderList);
        String[]sumAndNumber=OrderDAO.getInstance().maxNumberAndSum();
        String number = sumAndNumber[0];
        String summa = sumAndNumber[1];
        request.setAttribute("maxNumber",number);
        request.setAttribute("sum",summa);
        getServletContext().getRequestDispatcher("/salesperson/order.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        int number = Integer.parseInt(request.getParameter("number"));
        int idProduct = Integer.parseInt(request.getParameter("idProduct"));
        String product = request.getParameter("product");
        int quantum = Integer.parseInt(request.getParameter("quantum"));
        LocalDate localDate = LocalDate.now();
        double priceFinal = Double.parseDouble(request.getParameter("priceFinal"));
        double sum = Double.parseDouble(request.getParameter("sum"));
        String nameSalesperson = request.getParameter("nameSalesperson");
        String nameShop = request.getParameter("nameShop");
        Order order = new Order(number, idProduct, product, quantum, localDate, priceFinal, sum, nameSalesperson, nameShop);
        order.setNumber(number);
        order.setId(idProduct);
        order.setProduct(product);
        order.setQuantum(quantum);
        order.setLocalDate(localDate);
        order.setPriceFinal(priceFinal);
        order.setSum(sum);
        order.setNameSalesperson(nameSalesperson);
        order.setNameShop(nameShop);

        OrderDAO.getInstance().update(order);


        response.sendRedirect(request.getContextPath()+"/salesperson/printOrder");

    }
}