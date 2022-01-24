package dto.suppliersDto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class SuppliersDto {
    long id;
    String nameSupplier;
    String contactTel;
    String email;
}
