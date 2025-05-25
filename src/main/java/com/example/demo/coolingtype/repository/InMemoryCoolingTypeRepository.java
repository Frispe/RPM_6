package com.example.demo.coolingtype.repository;

import com.example.demo.coolingtype.model.CoolingTypeModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InMemoryCoolingTypeRepository extends JpaRepository<CoolingTypeModel, Long> {
    CoolingTypeModel findCoolingTypeByName(String name);

    default List<CoolingTypeModel> findCoolingTypesWithPagination(int page, int size) {
        Pageable pageable = Pageable.ofSize(size).withPage(page);
        Page<CoolingTypeModel> pageResult = findAll(pageable);
        return pageResult.getContent();
    }
}