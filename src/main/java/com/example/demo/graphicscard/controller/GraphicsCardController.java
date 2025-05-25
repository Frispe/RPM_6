package com.example.demo.graphicscard.controller;

import com.example.demo.brand.model.BrandModel;
import com.example.demo.brand.service.BrandService;
import com.example.demo.graphicscard.model.GraphicsCardModel;
import com.example.demo.graphicscard.service.GraphicsCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/graphicsCardList")
public class GraphicsCardController {

    @Autowired
    private GraphicsCardService graphicsCardService;

    @Autowired
    private BrandService brandService;

    @GetMapping
    public String getAllGraphicsCards(@RequestParam(defaultValue = "0") int page, Model model) {
        int size = 10;
        List<GraphicsCardModel> cards = graphicsCardService.findGraphicsCardsWithPagination(page, size);
        List<BrandModel> brands = brandService.findAllBrands();

        model.addAttribute("graphicsCards", cards);
        model.addAttribute("brands", brands);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages",
                (int) Math.ceil((double) graphicsCardService.findAllGraphicsCards().size() / size));
        return "graphicsCardList";
    }

    @PostMapping("/add")
    public String addGraphicsCard(@RequestParam Long brandId,
                                  @RequestParam String model,
                                  @RequestParam int frequency,
                                  @RequestParam int vram,
                                  @RequestParam double price) {
        BrandModel brand = brandService.findBrandById(brandId.intValue());
        GraphicsCardModel newCard = new GraphicsCardModel(0, brand, model, frequency, vram, price);
        graphicsCardService.addGraphicsCard(newCard);
        return "redirect:/graphicsCardList?page=0";
    }

    @PostMapping("/update")
    public String updateGraphicsCard(@RequestParam long id,
                                     @RequestParam Long brandId,
                                     @RequestParam String model,
                                     @RequestParam int frequency,
                                     @RequestParam int vram,
                                     @RequestParam double price) {
        BrandModel brand = brandService.findBrandById(brandId.intValue());
        GraphicsCardModel updatedCard = new GraphicsCardModel(id, brand, model, frequency, vram, price);
        graphicsCardService.updateGraphicsCard(updatedCard);
        return "redirect:/graphicsCardList?page=0";
    }


    @PostMapping("/delete")
    public String deleteGraphicsCard(@RequestParam long id) {
        graphicsCardService.deleteGraphicsCard(id);
        return "redirect:/graphicsCardList?page=0";
    }

    @GetMapping("/searchById")
    public String searchGraphicsCardById(@RequestParam long id, Model model) {
        GraphicsCardModel card = graphicsCardService.findGraphicsCardById(id);
        model.addAttribute("graphicsCards", card != null ? List.of(card) : List.of());
        model.addAttribute("currentPage", 0);
        model.addAttribute("totalPages", 1);
        return "graphicsCardList";
    }

    @GetMapping("/searchByModel")
    public String searchGraphicsCardByModel(@RequestParam String model, Model modelAttr) {
        GraphicsCardModel card = graphicsCardService.findGraphicsCardByModel(model);
        modelAttr.addAttribute("graphicsCards", card != null ? List.of(card) : List.of());
        modelAttr.addAttribute("currentPage", 0);
        modelAttr.addAttribute("totalPages", 1);
        return "graphicsCardList";
    }
}