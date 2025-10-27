package com.kai.springwork.dao.impl;


import com.kai.springwork.dao.ProductDao;
import com.kai.springwork.model.Product;
import com.kai.springwork.rowmapper.ProductRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.stereotype.Component;



import java.util.List;

@Component
public class ProductDaoImpl implements ProductDao {

    private final JdbcTemplate jdbcTemplate;

    public ProductDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Product> getProduct(String keyword) {

        String sql = "SELECT product_name, category, price, stock FROM commodity " +
                "WHERE product_name LIKE ? OR category LIKE ?";
        String search = "%" + keyword + "%";

        return jdbcTemplate.query(sql, new Object[]{search, search}, new ProductRowMapper());

    }
}
