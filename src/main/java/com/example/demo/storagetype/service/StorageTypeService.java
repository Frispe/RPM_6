package com.example.demo.storagetype.service;

import com.example.demo.storagetype.model.StorageTypeModel;

import java.util.List;

public interface StorageTypeService {
    List<StorageTypeModel> findAllStorageTypes();
    StorageTypeModel findStorageTypeById(Long id);
    List<StorageTypeModel> findStorageTypeByName(String typeName);
    StorageTypeModel addStorageType(StorageTypeModel storageType);
    StorageTypeModel updateStorageType(StorageTypeModel storageType);
    void deleteStorageType(Long id);
    List<StorageTypeModel> findStorageTypesWithPagination(int page, int size);
}