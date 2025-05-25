// InMemoryStorageRepository.java
package com.example.demo.storage.repository;

import com.example.demo.storage.model.StorageModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InMemoryStorageRepository extends JpaRepository<StorageModel, Long> {
    StorageModel findStorageByModel(String model);
    List<StorageModel> findByStorageType_Id(Long storageTypeId);
    List<StorageModel> findByBrand_Id(Long brandId);

    default List<StorageModel> findStoragesWithPagination(int page, int size) {
        Pageable pageable = Pageable.ofSize(size).withPage(page);
        Page<StorageModel> storagePage = findAll(pageable);
        return storagePage.getContent();
    }
}