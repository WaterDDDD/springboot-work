package com.kai.springwork.rowmapper;


import com.kai.springwork.constant.ProductCategory;
import com.kai.springwork.model.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRowMapper implements RowMapper<Product> {
    @Override
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {

        Product product = new Product();
        product.setProductName(rs.getString("product_name"));
        product.setCategory(ProductCategory.valueOf(rs.getString("category").toUpperCase()));
        product.setPrice(rs.getInt("price"));
        product.setStock(rs.getInt("stock"));

        return product;
    }
}
