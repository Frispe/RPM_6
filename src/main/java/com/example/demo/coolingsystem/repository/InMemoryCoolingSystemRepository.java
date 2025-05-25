package com.example.demo.coolingsystem.repository;

import com.example.demo.coolingsystem.model.CoolingSystemModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InMemoryCoolingSystemRepository extends JpaRepository<CoolingSystemModel, Long> {
    CoolingSystemModel findCoolingSystemByModel(String model);

    default List<CoolingSystemModel> findCoolingSystemsWithPagination(int page, int size) {
        Pageable pageable = Pageable.ofSize(size).withPage(page);
        Page<CoolingSystemModel> coolingSystemPage = findAll(pageable);
        return coolingSystemPage.getContent();
    }
}