package com.example.demo.storagetype.model;

import com.example.demo.storage.model.StorageModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Entity
@Table(name = "storage_type")
public class StorageTypeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Type name is required")
    @Column(name = "type_name", nullable = false, unique = true)
    private String typeName;

    @OneToMany(mappedBy = "storageType", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<StorageModel> storages;

    public List<StorageModel> getStorages() {
        return storages;
    }

    public void setStorages(List<StorageModel> storages) {
        this.storages = storages;
    }

    public StorageTypeModel() {
    }

    public StorageTypeModel(Long id, String typeName) {
        this.id = id;
        this.typeName = typeName;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}