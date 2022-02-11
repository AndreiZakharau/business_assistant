package service;

import dao.impl.ExpiredProductDAO;
import dao.impl.ProductDAO;
import dto.expiredProductDto.CreateExpiredDto;
import dto.expiredProductDto.ExpiredDto;
import entity.ExpiredProduct;
import entity.Products;
import lombok.NoArgsConstructor;
import mapper.impl.ExpiredMapper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class ExpiredService {
    private static ExpiredService instance = new ExpiredService();

    public static ExpiredService getInstance() {
        return instance;
    }

    private final ExpiredProductDAO expiredProductDAO = ExpiredProductDAO.getInstance();

    public ExpiredProduct addExpiredProduct(CreateExpiredDto createExpiredDto) {
        ExpiredProduct expiredProduct = ExpiredMapper.getInstance().mapCreateExpired(createExpiredDto);
        ExpiredProductDAO.getInstance().add(expiredProduct);
        Products products = ProductDAO.getInstance().finByID(expiredProduct.getNameProductExpired());
        ProductDAO.getInstance().delete(products);
        return expiredProduct;
    }

    public List<ExpiredDto> getAllExpiredProduct() {
        getExpiredProduct();
        return expiredProductDAO.findAll().stream().map(expiredProduct -> ExpiredDto.builder()
                .id(expiredProduct.getId())
                .nameProductExpired(expiredProduct.getNameProductExpired())
                .balance(expiredProduct.getBalance())
                .purchasePrice(expiredProduct.getPurchasePrice())
                .localDate(expiredProduct.getLocalDate())
                .build()).collect(Collectors.toList());
    }

    public ExpiredProduct getExpiredProduct() {

        ExpiredProduct expiredProduct = new ExpiredProduct();
        List<Products> products = ProductDAO.getInstance().findAll();
        LocalDate localDate = LocalDate.now();
        for (Products p : products) {
            if (p.getDate().toString().equals(localDate.toString())) {
                expiredProduct.setNameProductExpired(p.getId());
                expiredProduct.setBalance(p.getCount());
                expiredProduct.setPurchasePrice(p.getPrice());
                expiredProduct.setLocalDate(LocalDate.now());
                ExpiredProductDAO.getInstance().add(expiredProduct);
            }
        }
        return expiredProduct;
    }
}
