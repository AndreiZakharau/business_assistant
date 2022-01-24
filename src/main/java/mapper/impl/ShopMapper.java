package mapper.impl;

import dto.shopDto.CreateShopDto;
import dto.shopDto.ShopDto;
import entity.Shops;
import lombok.NoArgsConstructor;
import mapper.Mapper;
import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class ShopMapper implements Mapper <ShopDto, Shops> {
    private static ShopMapper instance = new ShopMapper();
    public static ShopMapper getInstance() {
        return instance;
    }


    public Shops mapFromCreateShop(CreateShopDto object){
        Shops shops = new Shops();
        shops.setNameShop(object.getNameShop());
        shops.setAddress(object.getAddress());
        return shops;
    }

    @Override
    public Shops mapFrom(ShopDto object) {
        Shops shops = new Shops();
        shops.setId(object.getId());
        shops.setNameShop(object.getNameShop());
        shops.setAddress(object.getAddress());
        return shops;
    }
}
