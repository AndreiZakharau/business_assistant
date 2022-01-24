package dto.shopDto;

import entity.Shops;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CreateShopDto {
    String nameShop;
    String address;
}
