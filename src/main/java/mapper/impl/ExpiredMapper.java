package mapper.impl;

import dto.expiredProductDto.CreateExpiredDto;
import dto.expiredProductDto.ExpiredDto;
import entity.ExpiredProduct;
import mapper.Mapper;

import java.time.LocalDate;

public class ExpiredMapper implements Mapper<ExpiredDto, ExpiredProduct> {
    private static ExpiredMapper instance = new ExpiredMapper();
    public static ExpiredMapper getInstance(){return instance;}


    @Override
    public ExpiredProduct mapFrom(ExpiredDto object) {
        ExpiredProduct expiredProduct = new ExpiredProduct();
        expiredProduct.setId(object.getId());
        expiredProduct.setNameProductExpired(object.getNameProductExpired());
        expiredProduct.setBalance(object.getBalance());
        expiredProduct.setPurchasePrice(object.getPurchasePrice());
        expiredProduct.setLocalDate(object.getLocalDate());
        return expiredProduct;
    }

    public ExpiredProduct mapCreateExpired(CreateExpiredDto object) {
        ExpiredProduct expiredProduct = new ExpiredProduct();
        expiredProduct.setNameProductExpired(Long.parseLong(object.getNameProductExpired()));
        expiredProduct.setBalance(Integer.parseInt(object.getBalance()));
        expiredProduct.setPurchasePrice(Double.parseDouble(object.getPurchasePrice()));
        expiredProduct.setLocalDate((LocalDate.parse(object.getLocalDate())));
        return expiredProduct;
    }
}
