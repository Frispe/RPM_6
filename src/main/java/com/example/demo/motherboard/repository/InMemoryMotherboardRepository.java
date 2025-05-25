package com.example.demo.motherboard.repository;

import com.example.demo.motherboard.model.MotherboardModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InMemoryMotherboardRepository extends JpaRepository<MotherboardModel, Long> {
    MotherboardModel findMotherboardByModel(String model);
    List<MotherboardModel> findByBrand_Id(Long brandId);

    default List<MotherboardModel> findMotherboardsWithPagination(int page, int size) {
        Pageable pageable = Pageable.ofSize(size).withPage(page);
        Page<MotherboardModel> motherboardPage = findAll(pageable);
        return motherboardPage.getContent();
    }
}