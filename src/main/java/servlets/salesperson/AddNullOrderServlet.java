package servlets.salesperson;

import dao.impl.OrderDAO;
import entity.Order;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/salesperson/addNullOrderServlet")
public class AddNullOrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] sumAndNumber = OrderDAO.getInstance().maxNumberAndSum();
        int number = Integer.parseInt(sumAndNumber[0]) + 1;

        int idProduct = 0;
        String product = "null";
        int quantum = 0;
        LocalDate localDate = LocalDate.now();
        double priceFinal = 0.0;
        double sum = 0.0;
        String nameSalesperson = "null";
        String nameShop = "null";
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

        OrderDAO.getInstance().add(order);
        response.sendRedirect(request.getContextPath() + "/salesperson/salespersonWork");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
