package com.example.demo.storagetype.repository;

import com.example.demo.storagetype.model.StorageTypeModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InMemoryStorageTypeRepository extends JpaRepository<StorageTypeModel, Long> {
    List<StorageTypeModel> findByTypeName(String typeName);

    default List<StorageTypeModel> findStorageTypesWithPagination(int page, int size) {
        Pageable pageable = Pageable.ofSize(size).withPage(page);
        Page<StorageTypeModel> storageTypePage = findAll(pageable);
        return storageTypePage.getContent();
    }
}