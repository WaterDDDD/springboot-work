package com.kai.springwork.controller;

import com.kai.springwork.dao.ProductDao;
import com.kai.springwork.dao.impl.ProductDaoImpl;
import com.kai.springwork.model.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;


import java.io.IOException;
import java.util.List;


@WebServlet("/getProducts")
public class ProductServlet extends HttpServlet {

    @Autowired
    private ProductDao productDao;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String keyword = request.getParameter("name");

        List<Product> products = productDao.getProduct(keyword);

        request.setAttribute("products", products);
        request.setAttribute("keyword", keyword);
        request.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request, response);

    }
}
