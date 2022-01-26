package validator.notNull.impl;

import dao.impl.PersonDAO;
import entity.Person;
import validator.notNull.Validator;

public class ValidityPerson implements Validator<Person> {

    public static final String INPUT_REG_PHONE = "^[+]\\d{11,12}$";

    private static ValidityPerson instance = new ValidityPerson();
    public static ValidityPerson getInstance() {
        return instance;
    }

    @Override
    public boolean notNull(Person person) {
        boolean result = false;
        while (PersonDAO.getInstance().finByID(person.getId()) != null){
            result = true;
        }
        return result;
    }

    @Override
    public boolean notCopyName(Person person) {
        boolean result = false;
        Person persons = PersonDAO.getInstance().finByName(person.getName());
        if (persons.getName() == null || persons.getLastName() == null || persons.getTelephoneNumber() == null ){
            result = true;
        }
        return result;
    }


    public boolean isValidPhone(Person person){
        boolean result = false;
        if (person.getTelephoneNumber() != null && person.getTelephoneNumber().matches(INPUT_REG_PHONE)){
            result = true;
        }else {
            // TODO my EXCEPTION and message
        }
        return result;

    }
}
