package com.example.demo.brand.repository;

import com.example.demo.brand.model.BrandModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InMemoryBrandRepository extends JpaRepository<BrandModel, Long> {
    BrandModel findBrandByName(String name);

    default List<BrandModel> findBrandsWithPagination(int page, int size) {
        Pageable pageable = Pageable.ofSize(size).withPage(page);
        Page<BrandModel> brandPage = findAll(pageable);
        return brandPage.getContent();
    }
}