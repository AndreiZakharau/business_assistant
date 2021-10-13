package servise.workDB;

import dao.impl.ShopDAO;
import entity.Shops;

public class ShopDB {
    private static ShopDB INSTANCE=null;
    private ShopDB(){}

    public static ShopDB getInstance() {
        if (INSTANCE==null){
            synchronized (ShopDB.class){
                if (INSTANCE==null){
                    INSTANCE=new ShopDB();
                }
            }
        }
        return INSTANCE;
    }
    private static ShopDAO shopDAO = ShopDAO.getInstance;

}
