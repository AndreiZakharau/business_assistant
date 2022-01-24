package validator.notNull.impl;

import dao.impl.CategoriesDAO;
import dto.categoriesDto.CreateCategoriesDto;
import entity.Categories;
import validator.notNull.Validator;

import java.util.List;

public class ValidityCategory implements Validator <Categories> {

    private static ValidityCategory instance = new ValidityCategory();
    public static ValidityCategory getInstance() {
        return instance;
    }
    @Override
    public boolean notNull(Categories categories) {
        boolean result = false;
        while (CategoriesDAO.getInstance().finByID(categories.getId())!=null) {
            result = true;
        }
        return result;
    }

    @Override
    public boolean notCopyName(Categories categories) {
        boolean result = false;
      Categories c =  CategoriesDAO.getInstance().finByName(categories.getCategory());
      if (c.getCategory()==null) {
          result = true;
      }
        return result;
    }
}
