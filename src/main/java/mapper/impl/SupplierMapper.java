package mapper.impl;

import dto.suppliersDto.CreateSuppliersDto;
import dto.suppliersDto.SuppliersDto;
import entity.Suppliers;
import mapper.Mapper;

public class SupplierMapper implements Mapper <SuppliersDto, Suppliers> {
    private static SupplierMapper instance = new SupplierMapper();
    public static SupplierMapper getInstance(){return instance;}
    SupplierMapper(){}
    @Override
    public Suppliers mapFrom(SuppliersDto object) {
        Suppliers suppliers = new Suppliers();
        suppliers.setId(object.getId());
        suppliers.setNameSupplier(object.getNameSupplier());
        suppliers.setContactTel(object.getContactTel());
        suppliers.setEmail(object.getEmail());
        return suppliers;
    }

    public  Suppliers mapCreateSuppliers(CreateSuppliersDto object){
        Suppliers suppliers = new Suppliers();
        suppliers.setNameSupplier(object.getNameSupplier());
        suppliers.setContactTel(object.getContactTel());
        suppliers.setEmail(object.getEmail());
        return suppliers;
    }


}
