package com.example.demo.processor.model;

import com.example.demo.brand.model.BrandModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

import java.util.List;

@Entity
@Table(name = "Processor")
public class ProcessorModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id")
    private BrandModel brand;

    @NotBlank(message = "Model is required")
    private String model;

    @NotBlank(message = "Socket is required")
    private String socket;

    @Positive(message = "Frequency must be positive")
    private double frequency; // в GHz

    @PositiveOrZero(message = "Price must be positive or zero")
    private double price;

    public ProcessorModel() {
    }

    public ProcessorModel(long id, BrandModel brand, String model,
                          String socket, double frequency, double price) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.socket = socket;
        this.frequency = frequency;
        this.price = price;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BrandModel getBrand() {
        return brand;
    }

    public void setBrand(BrandModel brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSocket() {
        return socket;
    }

    public void setSocket(String socket) {
        this.socket = socket;
    }

    public double getFrequency() {
        return frequency;
    }

    public void setFrequency(double frequency) {
        this.frequency = frequency;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}