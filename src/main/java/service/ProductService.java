package service;

import dao.impl.ProductDAO;
import dto.productDto.CreateProductDto;
import dto.productDto.ProductDto;
import entity.Products;
import lombok.NoArgsConstructor;
import mapper.impl.ProductMapper;
import validator.notNull.impl.ValidityProduct;

import java.util.List;
import java.util.stream.Collectors;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class ProductService {
    private static ProductService instance = new ProductService();

    public static ProductService getInstance() {
        return instance;
    }

    private final ProductDAO productDAO = ProductDAO.getInstance();
    private final ProductMapper productMapper = ProductMapper.getInstance();
    private final ValidityProduct validityProduct = ValidityProduct.getInstance();

    public boolean deleteProduct(ProductDto productDto) {
        boolean result = false;
        Products products = ProductMapper.getInstance().mapFrom(productDto);
        if (validityProduct.notNull(products)) {
            result = productDAO.delete(products);
        }
        return result;
    }

    public Products addProduct(CreateProductDto createProductDto) {
        Products products = ProductMapper.getInstance().mapCreateProduct(createProductDto);
        if (validityProduct.notCopyName(products)) {
            ProductDAO.getInstance().add(products);
        }
        return products;
    }

    public Products updateProduct(ProductDto productDto) {
        Products products = ProductMapper.getInstance().mapFrom(productDto);
        ProductDAO.getInstance().update(products);
        return products;
    }

    public List<ProductDto> getAllProducts() {
        return productDAO.findAll().stream().map(products -> ProductDto.builder()
                .id(products.getId())
                .name(products.getName())
                .categories(products.getCategories())
                .count(products.getCount())
                .price(products.getPrice())
                .localDate(products.getLocalDate())
                .date(products.getDate())
                .suppliers(products.getSuppliers())
                .shop(products.getShop())
                .build()).collect(Collectors.toList());
    }
}
