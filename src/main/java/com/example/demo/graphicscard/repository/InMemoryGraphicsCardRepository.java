package com.example.demo.graphicscard.repository;

import com.example.demo.graphicscard.model.GraphicsCardModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InMemoryGraphicsCardRepository extends JpaRepository<GraphicsCardModel, Long> {
    GraphicsCardModel findGraphicsCardByModel(String model);
    List<GraphicsCardModel> findByBrand_Id(Long brandId);

    default List<GraphicsCardModel> findGraphicsCardsWithPagination(int page, int size) {
        Pageable pageable = Pageable.ofSize(size).withPage(page);
        Page<GraphicsCardModel> graphicsCardPage = findAll(pageable);
        return graphicsCardPage.getContent();
    }
}