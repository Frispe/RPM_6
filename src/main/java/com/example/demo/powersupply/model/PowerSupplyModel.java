package com.example.demo.powersupply.model;

import com.example.demo.brand.model.BrandModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

@Entity
@Table(name = "PowerSupply")
public class PowerSupplyModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id")
    private BrandModel brand;

    @NotBlank(message = "Model is required")
    private String model;

    @Positive(message = "Power must be positive")
    private int power;

    @NotBlank(message = "Certification is required")
    private String certification;

    @PositiveOrZero(message = "Price must be positive or zero")
    private double price;

    public PowerSupplyModel() {
    }

    public PowerSupplyModel(long id, BrandModel brand, String model,
                            int power, String certification, double price) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.power = power;
        this.certification = certification;
        this.price = price;
    }

    // Геттеры и сеттеры
    public long getId() { return id; }
    public void setId(long id) { this.id = id; }
    public BrandModel getBrand() { return brand; }
    public void setBrand(BrandModel brand) { this.brand = brand; }
    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }
    public int getPower() { return power; }
    public void setPower(int power) { this.power = power; }
    public String getCertification() { return certification; }
    public void setCertification(String certification) { this.certification = certification; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
}