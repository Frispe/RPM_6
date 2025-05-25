package com.example.demo.ram.model;

import com.example.demo.brand.model.BrandModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

@Entity
@Table(name = "RAM")
public class RamModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id")
    private BrandModel brand;

    @NotBlank(message = "Model is required")
    private String model;

    @Positive(message = "Frequency must be positive")
    private int frequency; // in MHz

    @Positive(message = "Capacity must be positive")
    private int capacity; // in GB

    @PositiveOrZero(message = "Price must be positive or zero")
    private double price;

    public RamModel() {
    }

    public RamModel(long id, BrandModel brand, String model,
                    int frequency, int capacity, double price) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.frequency = frequency;
        this.capacity = capacity;
        this.price = price;
    }

    // Геттеры и сеттеры для brand
    public BrandModel getBrand() {
        return brand;
    }

    public void setBrand(BrandModel brand) {
        this.brand = brand;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public @NotBlank(message = "Model is required") String getModel() {
        return model;
    }

    public void setModel(@NotBlank(message = "Model is required") String model) {
        this.model = model;
    }

    @Positive(message = "Frequency must be positive")
    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(@Positive(message = "Frequency must be positive") int frequency) {
        this.frequency = frequency;
    }

    @Positive(message = "Capacity must be positive")
    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(@Positive(message = "Capacity must be positive") int capacity) {
        this.capacity = capacity;
    }

    @PositiveOrZero(message = "Price must be positive or zero")
    public double getPrice() {
        return price;
    }

    public void setPrice(@PositiveOrZero(message = "Price must be positive or zero") double price) {
        this.price = price;
    }
}