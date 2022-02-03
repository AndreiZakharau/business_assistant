package dto.expiredProductDto;

import entity.Products;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;

@Value
@Builder
public class ExpiredDto {
     long id;
     long nameProductExpired;
     int balance;
     double purchasePrice;
     LocalDate localDate;

}
