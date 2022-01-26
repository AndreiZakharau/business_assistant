package dto.personDto;

import entity.Role;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class PersonDto {
    long id;
    String name;
    String lastName;
    String telephoneNumber;
    Role role;
    long shop;
}
