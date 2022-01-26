package validator.notNull.impl;

import dao.impl.ProductDAO;
import entity.Products;
import validator.notNull.Validator;

public class ValidityProduct implements Validator <Products> {
    private static ValidityProduct instance = new ValidityProduct();
    public static ValidityProduct getInstance(){
        return instance;
    }

    @Override
    public boolean notNull(Products products) {
        boolean result = false;
        while (ProductDAO.getInstance().finByID(products.getId())!=null) {
            result = true;
        }
        return result;
    }

    @Override
    public boolean notCopyName(Products products) {
        boolean result = false;
        Products product = ProductDAO.getInstance().finByName(products.getName());
        if (product.getName()==null){
            result = true;
        }
        return result;    }
}
