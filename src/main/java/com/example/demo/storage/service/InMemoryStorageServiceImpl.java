// InMemoryStorageServiceImpl.java
package com.example.demo.storage.service;

import com.example.demo.storage.model.StorageModel;
import com.example.demo.storage.repository.InMemoryStorageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InMemoryStorageServiceImpl implements StorageService {

    private final InMemoryStorageRepository storageRepository;

    public InMemoryStorageServiceImpl(InMemoryStorageRepository storageRepository) {
        this.storageRepository = storageRepository;
    }

    @Override
    public List<StorageModel> findAllStorages() {
        return storageRepository.findAll();
    }

    @Override
    public StorageModel findStorageById(long id) {
        return storageRepository.findById(id).orElse(null);
    }

    @Override
    public StorageModel findStorageByModel(String model) {
        return storageRepository.findStorageByModel(model);
    }

    @Override
    public List<StorageModel> findByStorageType(Long storageTypeId) {
        return storageRepository.findByStorageType_Id(storageTypeId);
    }

    @Override
    public StorageModel addStorage(StorageModel storage) {
        return storageRepository.save(storage);
    }

    @Override
    public StorageModel updateStorage(StorageModel storage) {
        return storageRepository.save(storage);
    }

    @Override
    public void deleteStorage(long id) {
        storageRepository.deleteById(id);
    }

    @Override
    public List<StorageModel> findStoragesWithPagination(int page, int size) {
        return storageRepository.findStoragesWithPagination(page, size);
    }

    @Override
    public List<StorageModel> findByBrand(Long brandId) {
        return storageRepository.findByBrand_Id(brandId);
    }
}