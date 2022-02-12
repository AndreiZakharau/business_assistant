package validator.notNull.impl;

import dao.impl.PersonDAO;
import entity.Person;
import validator.notNull.Validator;

public class ValidityPerson implements Validator<Person> {

    private static ValidityPerson instance = new ValidityPerson();

    public static ValidityPerson getInstance() {
        return instance;
    }

    @Override
    public boolean notNull(Person person) {
        boolean result = false;
        while (PersonDAO.getInstance().finByID(person.getId()) != null) {
            result = true;
        }
        return result;
    }

    @Override
    public boolean notCopyName(Person person) {
        boolean result = false;
        Person persons = PersonDAO.getInstance().finByName(person.getName());
        if (persons.getName() == null || persons.getLastName() == null || persons.getTelephoneNumber() == null) {
            result = true;
        }
        return result;
    }

}
