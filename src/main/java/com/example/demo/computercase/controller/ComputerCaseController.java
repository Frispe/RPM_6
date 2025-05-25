package com.example.demo.computercase.controller;

import com.example.demo.brand.model.BrandModel;
import com.example.demo.brand.service.BrandService;
import com.example.demo.computercase.model.ComputerCaseModel;
import com.example.demo.computercase.service.ComputerCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/computerCaseList")
public class ComputerCaseController {

    @Autowired
    private ComputerCaseService computerCaseService;

    @Autowired
    private BrandService brandService;

    @GetMapping
    public String getAllComputerCases(@RequestParam(defaultValue = "0") int page, Model model) {
        int size = 10;
        List<ComputerCaseModel> computerCases = computerCaseService.findComputerCaseWithPagination(page, size);
        List<BrandModel> brands = brandService.findAllBrands();

        model.addAttribute("computerCases", computerCases);
        model.addAttribute("brands", brands);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages",
                (int) Math.ceil((double) computerCaseService.findAllComputerCases().size() / size));
        return "computerCaseList";
    }

    @PostMapping("/add")
    public String addComputerCase(@RequestParam long brandId,
                                  @RequestParam String model,
                                  @RequestParam String formFactor,
                                  @RequestParam double price) {
        BrandModel brand = brandService.findBrandById((int)brandId);
        ComputerCaseModel newComputerCase = new ComputerCaseModel();
        newComputerCase.setBrand(brand);
        newComputerCase.setModel(model);
        newComputerCase.setFormFactor(formFactor);
        newComputerCase.setPrice(price);
        computerCaseService.addComputerCase(newComputerCase);
        return "redirect:/computerCaseList?page=0";
    }

    @PostMapping("/update")
    public String updateComputerCase(@RequestParam long id,
                                     @RequestParam long brandId,
                                     @RequestParam String model,
                                     @RequestParam String formFactor,
                                     @RequestParam double price) {
        BrandModel brand = brandService.findBrandById((int)brandId);
        ComputerCaseModel updatedComputerCase = new ComputerCaseModel();
        updatedComputerCase.setId(id);
        updatedComputerCase.setBrand(brand);
        updatedComputerCase.setModel(model);
        updatedComputerCase.setFormFactor(formFactor);
        updatedComputerCase.setPrice(price);
        computerCaseService.updateComputerCase(updatedComputerCase);
        return "redirect:/computerCaseList?page=0";
    }

    @PostMapping("/delete")
    public String deleteComputerCase(@RequestParam long id) {
        computerCaseService.deleteComputerCase(id);
        return "redirect:/computerCaseList?page=0";
    }

    @GetMapping("/searchById")
    public String searchComputerCaseById(@RequestParam long id, Model model) {
        ComputerCaseModel computerCase = computerCaseService.findComputerCaseById(id);
        List<BrandModel> brands = brandService.findAllBrands();

        model.addAttribute("computerCases", computerCase != null ? List.of(computerCase) : List.of());
        model.addAttribute("brands", brands);
        model.addAttribute("currentPage", 0);
        model.addAttribute("totalPages", 1);
        return "computerCaseList";
    }

    @GetMapping("/searchByModel")
    public String searchComputerCaseByModel(@RequestParam String model, Model modelAttr) {
        ComputerCaseModel computerCase = computerCaseService.findComputerCaseByModel(model);
        List<BrandModel> brands = brandService.findAllBrands();

        modelAttr.addAttribute("computerCases", computerCase != null ? List.of(computerCase) : List.of());
        modelAttr.addAttribute("brands", brands);
        modelAttr.addAttribute("currentPage", 0);
        modelAttr.addAttribute("totalPages", 1);
        return "computerCaseList";
    }
}