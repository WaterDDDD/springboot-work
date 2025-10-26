package com.kai.springwork.dao;

import com.kai.springwork.model.Product;

import java.util.List;

public interface ProductDao {

    List<Product> getProduct(String keyword);

}
