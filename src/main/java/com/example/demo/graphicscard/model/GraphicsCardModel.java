package com.example.demo.graphicscard.model;

import com.example.demo.brand.model.BrandModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "GraphicsCard")
public class GraphicsCardModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id")
    private BrandModel brand;

    @NotBlank(message = "Model is required")
    private String model;

    @Positive(message = "Frequency must be positive")
    private int frequency;

    @Positive(message = "VRAM must be positive")
    private int vram;

    @Positive(message = "Price must be positive")
    private double price;

    public GraphicsCardModel() {
    }

    public GraphicsCardModel(long id, BrandModel brand, String model,
                             int frequency, int vram, double price) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.frequency = frequency;
        this.vram = vram;
        this.price = price;
    }

    // Геттеры и сеттеры
    public long getId() { return id; }
    public void setId(long id) { this.id = id; }
    public BrandModel getBrand() { return brand; }
    public void setBrand(BrandModel brand) { this.brand = brand; }
    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }
    public int getFrequency() { return frequency; }
    public void setFrequency(int frequency) { this.frequency = frequency; }
    public int getVram() { return vram; }
    public void setVram(int vram) { this.vram = vram; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
}