package com.example.demo.motherboard.model;

import com.example.demo.brand.model.BrandModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "Motherboard")
public class MotherboardModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id")
    private BrandModel brand;

    @NotBlank(message = "Model is required")
    private String model;

    @NotBlank(message = "Chipset is required")
    private String chipset;

    @Positive(message = "Price must be positive")
    private double price;

    public MotherboardModel() {
    }

    public MotherboardModel(long id, BrandModel brand, String model, String chipset, double price) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.chipset = chipset;
        this.price = price;
    }
    public BrandModel getBrand() {
        return brand;
    }
    public void setBrand(BrandModel brand) {
        this.brand = brand;
    }
    public long getId() { return id; }
    public void setId(long id) { this.id = id; }
    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }
    public String getChipset() { return chipset; }
    public void setChipset(String chipset) { this.chipset = chipset; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
}