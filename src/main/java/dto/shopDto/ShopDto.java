package dto.shopDto;


import lombok.*;

@Value
@Builder
public class ShopDto {
    long id;
    String nameShop;
    String address;

}
