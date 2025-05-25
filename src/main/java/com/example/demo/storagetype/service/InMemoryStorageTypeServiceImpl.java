package com.example.demo.storagetype.service;

import com.example.demo.storagetype.model.StorageTypeModel;
import com.example.demo.storagetype.repository.InMemoryStorageTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InMemoryStorageTypeServiceImpl implements StorageTypeService {

    private final InMemoryStorageTypeRepository storageTypeRepository;

    public InMemoryStorageTypeServiceImpl(InMemoryStorageTypeRepository storageTypeRepository) {
        this.storageTypeRepository = storageTypeRepository;
    }

    @Override
    public List<StorageTypeModel> findAllStorageTypes() {
        return storageTypeRepository.findAll();
    }

    @Override
    public StorageTypeModel findStorageTypeById(Long id) {
        return storageTypeRepository.findById(id).orElse(null);
    }

    @Override
    public List<StorageTypeModel> findStorageTypeByName(String typeName) {
        return storageTypeRepository.findByTypeName(typeName);
    }

    @Override
    public StorageTypeModel addStorageType(StorageTypeModel storageType) {
        return storageTypeRepository.save(storageType);
    }

    @Override
    public StorageTypeModel updateStorageType(StorageTypeModel storageType) {
        return storageTypeRepository.save(storageType);
    }

    @Override
    public void deleteStorageType(Long id) {
        storageTypeRepository.deleteById(id);
    }

    @Override
    public List<StorageTypeModel> findStorageTypesWithPagination(int page, int size) {
        return storageTypeRepository.findStorageTypesWithPagination(page, size);
    }
}