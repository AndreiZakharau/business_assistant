package mapper.impl;

import dto.personDto.CreatePersonDto;
import dto.personDto.PersonDto;
import dto.personDto.PersonNamePhoneDto;
import entity.Person;
import entity.Role;
import mapper.Mapper;


public class PersonMapper implements Mapper<PersonDto, Person> {
    private static PersonMapper instance = new PersonMapper();

    @Override
    public Person mapFrom(PersonDto object) {
    Person person = new Person();
    person.setId(object.getId());
    person.setName(object.getName());
    person.setLastName(object.getLastName());
    person.setTelephoneNumber(object.getTelephoneNumber());
    person.setRole(object.getRole());
    person.setShop(object.getShop());
    return  person;

    }
    public Person mapCreatePerson(CreatePersonDto object){
        Person person = new Person();
        person.setName(object.getName());
        person.setLastName(object.getLastName());
        person.setTelephoneNumber(object.getTelephoneNumber());
        person.setRole(Role.valueOf(object.getRole()));
        person.setShop(Long.parseLong(object.getShop()));
        return person;
    }

    public Person mapPersonNameAndPhone(PersonNamePhoneDto object){
        Person person = new Person();
        person.setName(object.getName());
        person.setLastName(object.getLastName());
        person.setTelephoneNumber(object.getTelephoneNumber());
        return person;
    }
    public static PersonMapper getInstance(){return instance;}
}
