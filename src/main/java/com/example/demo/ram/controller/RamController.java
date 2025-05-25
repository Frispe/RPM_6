package com.example.demo.ram.controller;

import com.example.demo.brand.model.BrandModel;
import com.example.demo.brand.service.BrandService;
import com.example.demo.ram.model.RamModel;
import com.example.demo.ram.service.RamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/ramList")
public class RamController {

    @Autowired
    private RamService ramService;

    @Autowired
    private BrandService brandService;

    @GetMapping
    public String getAllRams(@RequestParam(defaultValue = "0") int page, Model model) {
        int size = 10;
        List<RamModel> rams = ramService.findRamsWithPagination(page, size);
        List<BrandModel> brands = brandService.findAllBrands();

        model.addAttribute("rams", rams);
        model.addAttribute("brands", brands);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages",
                (int) Math.ceil((double) ramService.findAllRams().size() / size));
        return "ramList";
    }

    @PostMapping("/add")
    public String addRam(@RequestParam Long brandId,
                         @RequestParam String model,
                         @RequestParam int frequency,
                         @RequestParam int capacity,
                         @RequestParam double price) {
        BrandModel brand = brandService.findBrandById(brandId.intValue());
        RamModel newRam = new RamModel(0, brand, model, frequency, capacity, price);
        ramService.addRam(newRam);
        return "redirect:/ramList?page=0";
    }

    @PostMapping("/update")
    public String updateRam(@RequestParam long id,
                            @RequestParam Long brandId,
                            @RequestParam String model,
                            @RequestParam int frequency,
                            @RequestParam int capacity,
                            @RequestParam double price) {
        BrandModel brand = brandService.findBrandById(brandId.intValue());
        RamModel updatedRam = new RamModel(id, brand, model, frequency, capacity, price);
        ramService.updateRam(updatedRam);
        return "redirect:/ramList?page=0";
    }

    @PostMapping("/delete")
    public String deleteRam(@RequestParam long id) {
        ramService.deleteRam(id);
        return "redirect:/ramList?page=0";
    }

    @GetMapping("/searchById")
    public String searchRamById(@RequestParam long id, Model model) {
        RamModel ram = ramService.findRamById(id);
        model.addAttribute("rams", ram != null ? List.of(ram) : List.of());
        model.addAttribute("currentPage", 0);
        model.addAttribute("totalPages", 1);
        return "ramList";
    }

    @GetMapping("/searchByModel")
    public String searchRamByModel(@RequestParam String model, Model modelAttr) {
        RamModel ram = ramService.findRamByModel(model);
        modelAttr.addAttribute("rams", ram != null ? List.of(ram) : List.of());
        modelAttr.addAttribute("currentPage", 0);
        modelAttr.addAttribute("totalPages", 1);
        return "ramList";
    }
}