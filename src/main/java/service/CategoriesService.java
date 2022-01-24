package service;

import dao.impl.CategoriesDAO;
import dto.categoriesDto.CategoriesDto;
import dto.categoriesDto.CreateCategoriesDto;
import entity.Categories;
import lombok.NoArgsConstructor;
import mapper.impl.CategoriesMapper;
import validator.notNull.impl.ValidityCategory;
import java.util.List;
import java.util.stream.Collectors;
import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class CategoriesService {
    private static CategoriesService instance = new CategoriesService();
    private final CategoriesDAO categoriesDAO = CategoriesDAO.getInstance();
    private final CategoriesMapper categoriesMapper = CategoriesMapper.getInstance();
    private final ValidityCategory validityCategory = ValidityCategory.getInstance();

    public boolean deleteCategory(CategoriesDto categoriesDto) {
        boolean result = false;
        Categories categories = CategoriesMapper.getInstance().mapFrom(categoriesDto);
        if (validityCategory.notNull(categories)) {
            result = categoriesDAO.delete(categories);
        }
        return result;
    }

    public Categories addCategory(CreateCategoriesDto createCategoriesDto){

        Categories categories= CategoriesMapper.getInstance().mapCreateCategory(createCategoriesDto);
        if (validityCategory.notCopyName( categories)){
            CategoriesDAO.getInstance().add(categories);
        }
        return categories;
    }

    public Categories updateCategory(CategoriesDto categoriesDto){
        Categories categories = CategoriesMapper.getInstance().mapFrom(categoriesDto);
        CategoriesDAO.getInstance().update(categories);
        return categories;
    }

    public List<CategoriesDto> getAllCategories(){
        return categoriesDAO.findAll().stream().map(categories -> CategoriesDto.builder()
                .id(categories.getId())
                .category(categories.getCategory())
                .interest(categories.getInterest())
                .build()).collect(Collectors.toList());
    }
    public static CategoriesService getInstance(){
        return instance;
    }
}
