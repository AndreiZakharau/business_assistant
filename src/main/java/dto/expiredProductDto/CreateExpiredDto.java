package dto.expiredProductDto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CreateExpiredDto {
    String nameProductExpired;
    String balance;
    String purchasePrice;
    String localDate;
}
