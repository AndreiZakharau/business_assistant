package dto.categoriesDto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder

public class CategoriesDto {
    long id;
    String category;
    double interest;
}
