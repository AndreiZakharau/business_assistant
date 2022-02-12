package validator;

import entity.Person;
import entity.Suppliers;

public class ValidatorPhone {
    public static final String INPUT_REG_PHONE = "^[+]\\d{11,12}$";

    public boolean isValidPhonePerson(Person person) {
        return person.getTelephoneNumber() != null && person.getTelephoneNumber().matches(INPUT_REG_PHONE);
    }
    public boolean isValidPhoneSupplier(Suppliers suppliers) {
        return suppliers.getContactTel() != null && suppliers.getContactTel().matches(INPUT_REG_PHONE);
    }
}
