package com.example.chayalesson2webapi.repositories;

import com.example.chayalesson2webapi.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Repository
public class ProductRepository2 {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Product> getProductsInRange(double minPrice,double maxPrice){
        String productsInRangeQuery = "select * from product where price >= '"  + minPrice + "' and price <= '" + maxPrice +"'";
        List<Map<String, Object>> rowsInDB = jdbcTemplate.queryForList(productsInRangeQuery);

        List<Product> products = new ArrayList<>();
        for (Map<String,Object> productRow: rowsInDB){
            Product p = new Product((int) productRow.get("id"),(int)productRow.get("cost"),(String) productRow.get("nameProduct"));
            products.add(p);
        }
        System.out.println(products);
        return products;
    }

}
