package com.example.demo.storagetype.entity;

import com.example.demo.storagetype.model.StorageTypeModel;

public class StorageTypeEntity extends StorageTypeModel {
    public StorageTypeEntity(int id, String typeName) {
        super((long) id, typeName);
    }
}