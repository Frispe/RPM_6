package com.example.demo.motherboard.controller;

import com.example.demo.brand.model.BrandModel;
import com.example.demo.brand.service.BrandService;
import com.example.demo.motherboard.model.MotherboardModel;
import com.example.demo.motherboard.service.MotherboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/motherboardList")
public class MotherboardController {

    @Autowired
    private MotherboardService motherboardService;

    @Autowired
    private BrandService brandService;

    @GetMapping
    public String getAllMotherboards(@RequestParam(defaultValue = "0") int page, Model model) {
        int size = 10;
        List<MotherboardModel> motherboards = motherboardService.findMotherboardsWithPagination(page, size);
        List<BrandModel> brands = brandService.findAllBrands();

        model.addAttribute("motherboards", motherboards);
        model.addAttribute("brands", brands);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages",
                (int) Math.ceil((double) motherboardService.findAllMotherboards().size() / size));
        return "motherboardList";
    }

    @PostMapping("/add")
    public String addMotherboard(@RequestParam Long brandId,
                                 @RequestParam String model,
                                 @RequestParam String chipset,
                                 @RequestParam double price) {
        BrandModel brand = brandService.findBrandById(brandId.intValue());
        MotherboardModel newMotherboard = new MotherboardModel(0, brand, model, chipset, price);
        motherboardService.addMotherboard(newMotherboard);
        return "redirect:/motherboardList?page=0";
    }

    @PostMapping("/update")
    public String updateMotherboard(@RequestParam long id,
                                    @RequestParam Long brandId,
                                    @RequestParam String model,
                                    @RequestParam String chipset,
                                    @RequestParam double price) {
        BrandModel brand = brandService.findBrandById(brandId.intValue());
        MotherboardModel updatedMotherboard = new MotherboardModel(id, brand, model, chipset, price);
        motherboardService.updateMotherboard(updatedMotherboard);
        return "redirect:/motherboardList?page=0";
    }

    @PostMapping("/delete")
    public String deleteMotherboard(@RequestParam long id) {
        motherboardService.deleteMotherboard(id);
        return "redirect:/motherboardList?page=0";
    }

    @GetMapping("/searchById")
    public String searchMotherboardById(@RequestParam long id, Model model) {
        MotherboardModel motherboard = motherboardService.findMotherboardById(id);
        model.addAttribute("motherboards", motherboard != null ? List.of(motherboard) : List.of());
        model.addAttribute("currentPage", 0);
        model.addAttribute("totalPages", 1);
        return "motherboardList";
    }

    @GetMapping("/searchByModel")
    public String searchMotherboardByModel(@RequestParam String model, Model modelAttr) {
        MotherboardModel motherboard = motherboardService.findMotherboardByModel(model);
        modelAttr.addAttribute("motherboards", motherboard != null ? List.of(motherboard) : List.of());
        modelAttr.addAttribute("currentPage", 0);
        modelAttr.addAttribute("totalPages", 1);
        return "motherboardList";
    }
}