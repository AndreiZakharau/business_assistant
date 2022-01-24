package dto.productDto;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;
import java.util.Date;

@Value
@Builder
public class ProductDto {

     long id;
     String name;
     int count;
     double price;
     long categories;
     long suppliers;
     LocalDate localDate;
     Date date;
     long shop;
}
