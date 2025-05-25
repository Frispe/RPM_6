package com.example.demo.brand.model;
import com.example.demo.computercase.model.ComputerCaseModel;
import com.example.demo.coolingsystem.model.CoolingSystemModel;
import com.example.demo.graphicscard.model.GraphicsCardModel;
import com.example.demo.motherboard.model.MotherboardModel;
import com.example.demo.powersupply.model.PowerSupplyModel;
import com.example.demo.processor.model.ProcessorModel;
import com.example.demo.ram.model.RamModel;
import com.example.demo.storage.model.StorageModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.List;


@Entity
@Table(name = "Brand")
public class BrandModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank(message = "Name is required")
    private String name;

    @OneToMany(mappedBy = "brand", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<StorageModel> storages;

    @OneToMany(mappedBy = "brand", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ProcessorModel> processors;

    @OneToMany(mappedBy = "brand", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<MotherboardModel> motherboards;

    @OneToMany(mappedBy = "brand", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<RamModel> rams;

    @OneToMany(mappedBy = "brand", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<GraphicsCardModel> graphicsCards;

    @OneToMany(mappedBy = "brand", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PowerSupplyModel> powerSupplies;

    @OneToMany(mappedBy = "brand", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ComputerCaseModel> computerCases;


    @OneToMany(mappedBy = "brand", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CoolingSystemModel> coolingSystems;

    // Конструкторы, геттеры и сеттеры
    public BrandModel() {
    }

    public BrandModel(long id, String name) {
        this.id = id;
        this.name = name;
    }
    public List<PowerSupplyModel> getPowerSupplies() {
        return powerSupplies;
    }

    public void setPowerSupplies(List<PowerSupplyModel> powerSupplies) {
        this.powerSupplies = powerSupplies;
    }
    // Добавляем геттер и сеттер для rams
    public List<RamModel> getRams() {
        return rams;
    }
    public List<GraphicsCardModel> getGraphicsCards() {
        return graphicsCards;
    }

    public void setGraphicsCards(List<GraphicsCardModel> graphicsCards) {
        this.graphicsCards = graphicsCards;
    }
    public void setRams(List<RamModel> rams) {
        this.rams = rams;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<StorageModel> getStorages() {
        return storages;
    }

    public List<MotherboardModel> getMotherboards() {
        return motherboards;
    }

    public void setMotherboards(List<MotherboardModel> motherboards) {
        this.motherboards = motherboards;
    }

    public void setStorages(List<StorageModel> storages) {
        this.storages = storages;
    }

    public List<ProcessorModel> getProcessors() {
        return processors;
    }

    public void setProcessors(List<ProcessorModel> processors) {
        this.processors = processors;
    }

    public List<ComputerCaseModel> getComputerCases() {
        return computerCases;
    }

    public void setComputerCases(List<ComputerCaseModel> computerCases) {
        this.computerCases = computerCases;
    }

    public List<CoolingSystemModel> getCoolingSystems() {
        return coolingSystems;
    }

    public void setCoolingSystems(List<CoolingSystemModel> coolingSystems) {
        this.coolingSystems = coolingSystems;
    }
}