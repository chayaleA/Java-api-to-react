package com.example.chayalesson2webapi.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Product {
    private String nameProduct;
    @Id
    private int id;
    private int cost;

    public Product(){

    }
    public Product(int id,int cost,String nameProduct){
        this.id = id;
        this.cost = cost;
        this.nameProduct = nameProduct;
    }
    public int getCost() {
        return cost;
    }

    public int getId() {
        return id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }


}
