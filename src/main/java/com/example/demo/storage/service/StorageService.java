// StorageService.java
package com.example.demo.storage.service;

import com.example.demo.storage.model.StorageModel;

import java.util.List;

public interface StorageService {
    List<StorageModel> findAllStorages();
    StorageModel findStorageById(long id);
    StorageModel findStorageByModel(String model);
    List<StorageModel> findByStorageType(Long storageTypeId);
    StorageModel addStorage(StorageModel storage);
    StorageModel updateStorage(StorageModel storage);
    void deleteStorage(long id);
    List<StorageModel> findStoragesWithPagination(int page, int size);
    List<StorageModel> findByBrand(Long brandId);
}