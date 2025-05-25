package com.example.demo.coolingtype.model;

import com.example.demo.coolingsystem.model.CoolingSystemModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Entity
@Table(name = "cooling_types",
        uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class CoolingTypeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Название типа охлаждения обязательно")
    private String name;

    @OneToMany(mappedBy = "coolingType", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CoolingSystemModel> coolingSystems;

    public CoolingTypeModel() {
    }

    public CoolingTypeModel(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public @NotBlank(message = "Type name is required") String getName() {
        return name;
    }

    public void setName(@NotBlank(message = "Type name is required") String name) {
        this.name = name;
    }
    public List<CoolingSystemModel> getCoolingSystems() {
        return coolingSystems;
    }

    public void setCoolingSystems(List<CoolingSystemModel> coolingSystems) {
        this.coolingSystems = coolingSystems;
    }
}