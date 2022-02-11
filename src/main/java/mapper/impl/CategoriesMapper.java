package mapper.impl;

import dto.categoriesDto.CategoriesDto;
import dto.categoriesDto.CreateCategoriesDto;
import entity.Categories;
import mapper.Mapper;

public class CategoriesMapper implements Mapper<CategoriesDto, Categories> {
    private static CategoriesMapper instance = new CategoriesMapper();

    public static CategoriesMapper getInstance() {
        return instance;
    }

    CategoriesMapper() {
    }

    @Override
    public Categories mapFrom(CategoriesDto object) {
        Categories categories = new Categories();
        categories.setId(object.getId());
        categories.setCategory(object.getCategory());
        categories.setInterest(object.getInterest());

        return categories;
    }

    public Categories mapCreateCategory(CreateCategoriesDto object) {
        Categories categories = new Categories();
        categories.setCategory(object.getCategory());
        categories.setInterest(Double.parseDouble(object.getInterest()));

        return categories;
    }
}
