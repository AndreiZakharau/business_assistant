package dto.productDto;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;
import java.util.Date;

@Value
@Builder
public class CreateProductDto {
    String name;
    String count;
    String price;
    String categories;
    String suppliers;
    String localDate;
    Date date;
    String shop;
}
