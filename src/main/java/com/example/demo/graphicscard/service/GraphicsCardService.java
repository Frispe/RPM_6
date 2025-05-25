package com.example.demo.graphicscard.service;

import com.example.demo.graphicscard.model.GraphicsCardModel;

import java.util.List;

public interface GraphicsCardService {
    List<GraphicsCardModel> findAllGraphicsCards();
    GraphicsCardModel findGraphicsCardById(long id);
    GraphicsCardModel findGraphicsCardByModel(String model);
    GraphicsCardModel addGraphicsCard(GraphicsCardModel card);
    GraphicsCardModel updateGraphicsCard(GraphicsCardModel card);
    void deleteGraphicsCard(long id);
    List<GraphicsCardModel> findGraphicsCardsWithPagination(int page, int size);
}