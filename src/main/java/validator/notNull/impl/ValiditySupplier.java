package validator.notNull.impl;

import dao.impl.SuppliersDAO;
import entity.Suppliers;
import validator.notNull.Validator;

public class ValiditySupplier implements Validator<Suppliers> {

    private static ValiditySupplier instance = new ValiditySupplier();

    ValiditySupplier() {
    }

    @Override
    public boolean notNull(Suppliers suppliers) {
        boolean result = false;
        while (SuppliersDAO.getInstance().finByID(suppliers.getId()) != null) {
            result = true;
        }
        return result;
    }

    @Override
    public boolean notCopyName(Suppliers suppliers) {
        boolean result = false;
        Suppliers supplier = SuppliersDAO.getInstance().finByName(suppliers.getNameSupplier());
        if (supplier.getNameSupplier() == null) {
            result = true;
        }
        return result;
    }

    public static ValiditySupplier getInstance() {
        return instance;
    }

}
