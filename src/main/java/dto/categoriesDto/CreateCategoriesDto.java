package dto.categoriesDto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder

public class CreateCategoriesDto {
    String category;
    String interest;
}
