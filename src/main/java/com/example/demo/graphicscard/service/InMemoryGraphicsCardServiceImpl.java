package com.example.demo.graphicscard.service;

import com.example.demo.graphicscard.model.GraphicsCardModel;
import com.example.demo.graphicscard.repository.InMemoryGraphicsCardRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InMemoryGraphicsCardServiceImpl implements GraphicsCardService {

    private final InMemoryGraphicsCardRepository graphicsCardRepository;

    public InMemoryGraphicsCardServiceImpl(InMemoryGraphicsCardRepository graphicsCardRepository) {
        this.graphicsCardRepository = graphicsCardRepository;
    }

    @Override
    public List<GraphicsCardModel> findAllGraphicsCards() {
        return graphicsCardRepository.findAll();
    }

    @Override
    public GraphicsCardModel findGraphicsCardById(long id) {
        return graphicsCardRepository.findById(id).orElse(null);
    }

    @Override
    public GraphicsCardModel findGraphicsCardByModel(String model) {
        return graphicsCardRepository.findGraphicsCardByModel(model);
    }

    @Override
    public GraphicsCardModel addGraphicsCard(GraphicsCardModel card) {
        return graphicsCardRepository.save(card);
    }

    @Override
    public GraphicsCardModel updateGraphicsCard(GraphicsCardModel card) {
        return graphicsCardRepository.save(card);
    }

    @Override
    public void deleteGraphicsCard(long id) {
        graphicsCardRepository.deleteById(id);
    }

    @Override
    public List<GraphicsCardModel> findGraphicsCardsWithPagination(int page, int size) {
        return graphicsCardRepository.findGraphicsCardsWithPagination(page, size);
    }
}