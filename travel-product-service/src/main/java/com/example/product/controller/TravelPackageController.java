package com.example.product.controller;

import com.example.product.entity.TravelPackage;
import com.example.product.service.TravelPackageService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/packages")
@RequiredArgsConstructor
public class TravelPackageController {
    private final TravelPackageService service;

    @GetMapping
    public Page<TravelPackage> getPackages(
            @RequestParam(defaultValue = "popular") String sort,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return service.getPackages(sort, page, size);
    }
}