package com.example.chayalesson2webapi.Controllers;

import com.example.chayalesson2webapi.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.chayalesson2webapi.services.ProductService;
import java.util.List;

@RestController
@RequestMapping("/product")

public class ProductController {

    @Autowired
    ProductService productService;
    @GetMapping public List<Product> GetList(){
           return  productService.GetList();
       }

       @GetMapping("/{id}")
       public Product GetListById(@PathVariable int id){
           return productService.GetListById(id);
       }
//    @GetMapping("/{price}")
//    public List<Product> GetListByPrice(@PathVariable int price){
//        return productService.GetListByPrice(price);
//    }
    @PostMapping
    public  void addProduct(@RequestBody Product p){
        productService.addProduct(p);
    }

   @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id){
       productService.deleteById(id);
   }

   @PutMapping("/{id}")
    public void UpdateList(@PathVariable int id,@RequestBody Product p){
       productService.UpdateList(id,p);
    }
}
