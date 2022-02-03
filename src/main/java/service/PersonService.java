package service;

import dao.impl.PersonDAO;
import dto.personDto.CreatePersonDto;
import dto.personDto.PersonDto;
import dto.personDto.PersonNamePhoneDto;
import entity.Person;
import lombok.NoArgsConstructor;
import mapper.impl.PersonMapper;
import validator.notNull.impl.ValidityPerson;
import java.util.List;
import java.util.stream.Collectors;
import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class PersonService {
    private static PersonService instance = new PersonService();
    private final PersonDAO personDAO = PersonDAO.getInstance();
    private final PersonMapper personMapper = PersonMapper.getInstance();
    private final ValidityPerson validityPerson = ValidityPerson.getInstance();
    public static PersonService getInstance() {
        return instance;
    }
    public boolean deletePerson(PersonDto personDto){
        boolean result = false;
        Person person = PersonMapper.getInstance().mapFrom(personDto);
        if (validityPerson.notNull(person)){
            result = personDAO.delete(person);
        }
        return result;
    }

    public Person addPerson(CreatePersonDto createPersonDto){
        Person person = PersonMapper.getInstance().mapCreatePerson(createPersonDto);
        if (validityPerson.notCopyName(person) && validityPerson.isValidPhone(person)){
            PersonDAO.getInstance().add(person);
        }
        return person;
    }

    public  Person updatePerson(PersonDto personDto){
        Person person = PersonMapper.getInstance().mapFrom(personDto);
        if (validityPerson.isValidPhone(person)){
        PersonDAO.getInstance().update(person);
        }
        return person;
    }

    public List<PersonDto> getAllPerson(){
        return personDAO.findAll().stream().map(person -> PersonDto.builder()
                .id(person.getId())
                .name(person.getName())
                .lastName(person.getLastName())
                .telephoneNumber(person.getTelephoneNumber())
                .role(person.getRole())
                .shop(person.getShop())
                .build()).collect(Collectors.toList());
    }

    public Person enterPerson(PersonNamePhoneDto personNamePhoneDto){
        Person person = PersonMapper.getInstance().mapPersonNameAndPhone(personNamePhoneDto);
        if (validityPerson.isValidPhone(person)) {
            person = personDAO.finByName(person.getName());
        }else {

        }
         return person;
    }
}
