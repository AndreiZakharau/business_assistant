package service;

import dao.impl.SuppliersDAO;
import dto.suppliersDto.CreateSuppliersDto;
import dto.suppliersDto.SuppliersDto;
import entity.Suppliers;
import lombok.NoArgsConstructor;
import mapper.impl.SupplierMapper;
import validator.ValidatorEmail;
import validator.ValidatorPhone;
import validator.notNull.impl.ValiditySupplier;

import java.util.List;
import java.util.stream.Collectors;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class SupplierService {
    private static SupplierService instance = new SupplierService();

    public static SupplierService getInstance() {
        return instance;
    }

    private final SuppliersDAO suppliersDAO = SuppliersDAO.getInstance();
    private final ValiditySupplier validitySupplier = ValiditySupplier.getInstance();
    private final SupplierMapper supplierMapper = SupplierMapper.getInstance();
    ValidatorEmail validatorEmail = new ValidatorEmail();
    ValidatorPhone validatorPhone = new ValidatorPhone();

    public boolean deleteSupplier(SuppliersDto suppliersDto) {
        boolean result = false;
        Suppliers suppliers = SupplierMapper.getInstance().mapFrom(suppliersDto);
        if (validitySupplier.notNull(suppliers)) {
            result = suppliersDAO.delete(suppliers);
        }
        return result;
    }

    public Suppliers addSupplier(CreateSuppliersDto createSuppliersDto) {

        Suppliers suppliers = SupplierMapper.getInstance().mapCreateSuppliers(createSuppliersDto);
        if (validitySupplier.notCopyName(suppliers) && validatorPhone.isValidPhoneSupplier(suppliers)) {
            if (suppliers.getEmail() != null && validatorEmail.isValidEmail(suppliers.getEmail())) {
                suppliers.setEmail(suppliers.getEmail());
            } else {
                suppliers.setEmail(null);
            }
            suppliers = SuppliersDAO.getInstance().add(suppliers);
        }
        return suppliers;
    }

    public Suppliers updateSupplier(SuppliersDto suppliersDto) {
        Suppliers suppliers = SupplierMapper.getInstance().mapFrom(suppliersDto);
        if (validitySupplier.notCopyName(suppliers) && validatorPhone.isValidPhoneSupplier(suppliers)) {
            if (suppliers.getEmail() != null && validatorEmail.isValidEmail(suppliers.getEmail())) {
                suppliers.setEmail(suppliers.getEmail());
            } else {
                suppliers.setEmail(null);
            }
            SuppliersDAO.getInstance().update(suppliers);
        }
        return suppliers;
    }

    public List<SuppliersDto> getAllSuppliers() {
        return suppliersDAO.findAll().stream().map(suppliers -> SuppliersDto.builder()
                .id(suppliers.getId())
                .nameSupplier(suppliers.getNameSupplier())
                .contactTel(suppliers.getContactTel())
                .email(suppliers.getEmail())
                .build()).collect(Collectors.toList());
    }
}
