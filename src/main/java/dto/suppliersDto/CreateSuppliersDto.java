package dto.suppliersDto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder

public class CreateSuppliersDto {

    String nameSupplier;
    String contactTel;
    String email;
}