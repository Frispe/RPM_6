package com.example.demo.brand.controller;

import com.example.demo.brand.model.BrandModel;
import com.example.demo.brand.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/brandList")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @GetMapping
    public String getAllBrands(@RequestParam(defaultValue = "0") int page, Model model) {
        int size = 10;
        List<BrandModel> brands = brandService.findBrandsWithPagination(page, size);
        model.addAttribute("brands", brands);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages",
                (int) Math.ceil((double) brandService.findAllBrands().size() / size));
        return "brandList";
    }

    @PostMapping("/add")
    public String addBrand(@RequestParam String name) {
        BrandModel newBrand = new BrandModel(0, name);
        brandService.addBrand(newBrand);
        return "redirect:/brandList?page=0";
    }

    @PostMapping("/update")
    public String updateBrand(@RequestParam int id,
                              @RequestParam String name) {
        BrandModel updatedBrand = new BrandModel(id, name);
        brandService.updateBrand(updatedBrand);
        return "redirect:/brandList?page=0";
    }

    @PostMapping("/delete")
    public String deleteBrand(@RequestParam int id) {
        brandService.deleteBrand(id);
        return "redirect:/brandList?page=0";
    }

    @GetMapping("/searchById")
    public String searchBrandById(@RequestParam int id, Model model) {
        BrandModel brand = brandService.findBrandById(id);
        model.addAttribute("brands", brand != null ? List.of(brand) : List.of());
        model.addAttribute("currentPage", 0);
        model.addAttribute("totalPages", 1);
        return "brandList";
    }

    @GetMapping("/searchByName")
    public String searchBrandByName(@RequestParam String name, Model model) {
        BrandModel brand = brandService.findBrandByName(name);
        model.addAttribute("brands", brand != null ? List.of(brand) : List.of());
        model.addAttribute("currentPage", 0);
        model.addAttribute("totalPages", 1);
        return "brandList";
    }
}