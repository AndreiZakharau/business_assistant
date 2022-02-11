package mapper.impl;

import dto.productDto.CreateProductDto;
import dto.productDto.ProductDto;
import entity.Products;
import mapper.Mapper;

import java.time.LocalDate;

public class ProductMapper implements Mapper<ProductDto, Products> {
    private static ProductMapper instance = new ProductMapper();

    @Override
    public Products mapFrom(ProductDto object) {
        Products products = new Products();
        products.setId(object.getId());
        products.setName(object.getName());
        products.setCount(object.getCount());
        products.setPrice(object.getPrice());
        products.setLocalDate(object.getLocalDate());
        products.setDate(object.getDate());
        products.setCategories(object.getCategories());
        products.setSuppliers(object.getSuppliers());
        products.setShop(object.getShop());
        return products;
    }

    public Products mapCreateProduct(CreateProductDto object) {
        Products products = new Products();
        products.setName(object.getName());
        products.setCount(Integer.parseInt(object.getCount()));
        products.setPrice(Double.parseDouble(object.getPrice()));
        products.setLocalDate(LocalDate.parse(object.getLocalDate()));
        products.setDate(object.getDate());
        products.setCategories(Long.parseLong(object.getCategories()));
        products.setSuppliers(Long.parseLong(object.getSuppliers()));
        products.setShop(Long.parseLong(object.getShop()));
        return products;
    }

    public static ProductMapper getInstance() {
        return instance;
    }
}
