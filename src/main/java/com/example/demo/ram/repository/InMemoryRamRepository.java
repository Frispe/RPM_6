package com.example.demo.ram.repository;

import com.example.demo.ram.model.RamModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InMemoryRamRepository extends JpaRepository<RamModel, Long> {
    RamModel findRamByModel(String model);
    List<RamModel> findByBrand_Id(Long brandId);

    default List<RamModel> findRamsWithPagination(int page, int size) {
        Pageable pageable = Pageable.ofSize(size).withPage(page);
        Page<RamModel> ramPage = findAll(pageable);
        return ramPage.getContent();
    }
}