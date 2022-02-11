package validator.notNull.impl;

import dao.impl.ShopDAO;
import entity.Shops;
import validator.notNull.Validator;

public class ValidityShop implements Validator<Shops> {

    private static ValidityShop instance = new ValidityShop();

    ValidityShop() {
    }

    @Override
    public boolean notNull(Shops shops) {
        boolean result = false;
        while (ShopDAO.getInstance().finByID(shops.getId()) != null) {
            result = true;
        }
        return result;
    }

    @Override
    public boolean notCopyName(Shops shops) {
        boolean result = false;
        Shops shop = ShopDAO.getInstance().finByName(shops.getNameShop());
        if (shop.getNameShop() == null) {
            result = true;
        }
        return result;
    }

    public static ValidityShop getInstance() {
        return instance;
    }


}

