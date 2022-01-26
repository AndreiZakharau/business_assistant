package dto.personDto;

import entity.Role;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CreatePersonDto {
    String name;
    String lastName;
    String telephoneNumber;
    String role;
    String shop;
}
