package service;

import dao.impl.ShopDAO;
import dto.shopDto.CreateShopDto;
import dto.shopDto.ShopDto;
import entity.Shops;
import lombok.NoArgsConstructor;
import mapper.impl.ShopMapper;
import validator.notNull.impl.ValidityShop;

import java.util.List;
import java.util.stream.Collectors;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class ShopService {

    private static ShopService instance = new ShopService();
    private final ShopDAO shopDAO = ShopDAO.getInstance();
    private final ShopMapper shopMapper = ShopMapper.getInstance();
    private final ValidityShop validityShop = ValidityShop.getInstance();

    public boolean deleteShop(ShopDto shopDto) {
        boolean result = false;
        Shops shops = ShopMapper.getInstance().mapFrom(shopDto);
        if (validityShop.notNull(shops)) {
            result = shopDAO.delete(shops);
        }
        return result;
    }

    public Shops addShop(CreateShopDto createShopDto) {

        Shops shops = ShopMapper.getInstance().mapFromCreateShop(createShopDto);
        if (validityShop.notCopyName(shops)) {
            ShopDAO.getInstance().add(shops);
        }
        return shops;
    }

    public Shops updateShop(ShopDto shopDto) {
        Shops shops = ShopMapper.getInstance().mapFrom(shopDto);
        ShopDAO.getInstance().update(shops);
        return shops;
    }

    public List<ShopDto> getAllShop() {
        return shopDAO.findAll().stream().map(shops -> ShopDto.builder()
                .id(shops.getId())
                .nameShop(shops.getNameShop())
                .address(shops.getAddress())
                .build()
        ).collect(Collectors.toList());
    }

    public static ShopService getInstance() {
        return instance;
    }
}
