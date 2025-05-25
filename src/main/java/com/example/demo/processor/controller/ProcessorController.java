package com.example.demo.processor.controller;

import com.example.demo.brand.model.BrandModel;
import com.example.demo.brand.service.BrandService;
import com.example.demo.processor.model.ProcessorModel;
import com.example.demo.processor.service.ProcessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/processorList")
public class ProcessorController {

    @Autowired
    private ProcessorService processorService;

    @Autowired
    private BrandService brandService;

    @GetMapping
    public String getAllProcessors(@RequestParam(defaultValue = "0") int page, Model model) {
        int size = 10;
        List<ProcessorModel> processors = processorService.findProcessorsWithPagination(page, size);
        List<BrandModel> brands = brandService.findAllBrands();

        model.addAttribute("processors", processors);
        model.addAttribute("brands", brands);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages",
                (int) Math.ceil((double) processorService.findAllProcessors().size() / size));
        return "processorList";
    }

    @PostMapping("/add")
    public String addProcessor(@RequestParam Long brandId,
                               @RequestParam String model,
                               @RequestParam String socket,
                               @RequestParam double frequency,
                               @RequestParam double price) {
        BrandModel brand = brandService.findBrandById(brandId.intValue());
        ProcessorModel newProcessor = new ProcessorModel(0, brand, model, socket, frequency, price);
        processorService.addProcessor(newProcessor);
        return "redirect:/processorList?page=0";
    }

    @PostMapping("/update")
    public String updateProcessor(@RequestParam long id,
                                  @RequestParam Long brandId,
                                  @RequestParam String model,
                                  @RequestParam String socket,
                                  @RequestParam double frequency,
                                  @RequestParam double price) {
        BrandModel brand = brandService.findBrandById(brandId.intValue());
        ProcessorModel updatedProcessor = new ProcessorModel(id, brand, model, socket, frequency, price);
        processorService.updateProcessor(updatedProcessor);
        return "redirect:/processorList?page=0";
    }

    @PostMapping("/delete")
    public String deleteProcessor(@RequestParam long id) {
        processorService.deleteProcessor(id);
        return "redirect:/processorList?page=0";
    }

    @GetMapping("/searchById")
    public String searchProcessorById(@RequestParam long id, Model model) {
        ProcessorModel processor = processorService.findProcessorById(id);
        model.addAttribute("processors", processor != null ? List.of(processor) : List.of());
        model.addAttribute("currentPage", 0);
        model.addAttribute("totalPages", 1);
        return "processorList";
    }

    @GetMapping("/searchByModel")
    public String searchProcessorByModel(@RequestParam String model, Model modelAttr) {
        ProcessorModel processor = processorService.findProcessorByModel(model);
        modelAttr.addAttribute("processors", processor != null ? List.of(processor) : List.of());
        modelAttr.addAttribute("currentPage", 0);
        modelAttr.addAttribute("totalPages", 1);
        return "processorList";
    }
}