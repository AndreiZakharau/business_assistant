package dto.personDto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class PersonNamePhoneDto {
    String name;
    String lastName;
    String telephoneNumber;
}
