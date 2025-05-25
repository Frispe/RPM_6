package com.example.demo.storage.model;

import com.example.demo.brand.model.BrandModel;
import com.example.demo.storagetype.model.StorageTypeModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

@Entity
@Table(name = "Storage")
public class StorageModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "storage_type_id")
    private StorageTypeModel storageType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id")
    private BrandModel brand;

    @NotBlank(message = "Model is required")
    private String model;

    @Positive(message = "Capacity must be positive")
    private int capacity;

    @Positive(message = "Write speed must be positive")
    private int writeSpeed;

    @Positive(message = "Read speed must be positive")
    private int readSpeed;

    @PositiveOrZero(message = "Price must be positive or zero")
    private double price;

    // Конструкторы, геттеры и сеттеры
    public StorageModel(long id, StorageTypeModel storageType, Long brandId, String model, int capacity, int writeSpeed, int readSpeed, double price) {
    }

    public StorageModel(long id, StorageTypeModel storageType, BrandModel brand, String model,
                        int capacity, int writeSpeed, int readSpeed, double price) {
        this.id = id;
        this.storageType = storageType;
        this.brand = brand;
        this.model = model;
        this.capacity = capacity;
        this.writeSpeed = writeSpeed;
        this.readSpeed = readSpeed;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public StorageTypeModel getStorageType() {
        return storageType;
    }

    public void setStorageType(StorageTypeModel storageType) {
        this.storageType = storageType;
    }

    public @NotBlank(message = "Model is required") String getModel() {
        return model;
    }

    public void setModel(@NotBlank(message = "Model is required") String model) {
        this.model = model;
    }

    @Positive(message = "Capacity must be positive")
    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(@Positive(message = "Capacity must be positive") int capacity) {
        this.capacity = capacity;
    }

    @Positive(message = "Write speed must be positive")
    public int getWriteSpeed() {
        return writeSpeed;
    }

    public void setWriteSpeed(@Positive(message = "Write speed must be positive") int writeSpeed) {
        this.writeSpeed = writeSpeed;
    }

    @Positive(message = "Read speed must be positive")
    public int getReadSpeed() {
        return readSpeed;
    }

    public void setReadSpeed(@Positive(message = "Read speed must be positive") int readSpeed) {
        this.readSpeed = readSpeed;
    }

    @PositiveOrZero(message = "Price must be positive or zero")
    public double getPrice() {
        return price;
    }

    public void setPrice(@PositiveOrZero(message = "Price must be positive or zero") double price) {
        this.price = price;
    }

    public BrandModel getBrand() {
        return brand;
    }

    public void setBrand(BrandModel brand) {
        this.brand = brand;
    }

    public StorageModel() {
    }
}