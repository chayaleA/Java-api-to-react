package com.example.chayalesson2webapi.services;

import com.example.chayalesson2webapi.entities.Product;
import com.example.chayalesson2webapi.repositories.ProductRepository;
import com.example.chayalesson2webapi.repositories.ProductRepository2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductRepository2 productRepository2;
    public List<Product> GetList(){
        return (List<Product>)productRepository.findAll();
    }



    public Product GetListById( int id){
        return productRepository.findById(id).orElse(null);
    }

   public List<Product> GetListByPrice(double minPrice, double maxPrice){
       return (List<Product>)productRepository2.getProductsInRange(minPrice,maxPrice);
   }

    public  void addProduct(Product p){
        productRepository.save(p);
    }


    public void deleteById( int id){
        productRepository.deleteById(id);
    }

    public void UpdateList( int id,Product p){
        Product existProduct = productRepository.findById(id).orElse(null);
        if(existProduct == null)
            productRepository.save(p);
        else
        {
            existProduct.setNameProduct(p.getNameProduct());
            productRepository.save(p);
        }
    }
}
