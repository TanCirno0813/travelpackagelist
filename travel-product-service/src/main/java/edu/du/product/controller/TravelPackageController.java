package edu.du.product.controller;

import edu.du.product.dto.TravelPackageListDTO;
import edu.du.product.entity.TravelPackage;
import edu.du.product.service.TravelPackageService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/packages")
@RequiredArgsConstructor
public class TravelPackageController {
    private final TravelPackageService service;

    @GetMapping
    public ResponseEntity<Page<TravelPackageListDTO>> getPackages(
            @RequestParam(defaultValue = "id,desc") String sort,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return ResponseEntity.ok(service.getPackages(sort, page, size));
    }

    @GetMapping("/search")
    public ResponseEntity<List<TravelPackageListDTO>> searchPackages(
            @RequestParam(required = false) String keyword,
            @RequestParam(required = false) Integer minPrice,
            @RequestParam(required = false) Integer maxPrice,
            @RequestParam(required = false) String duration,
            @RequestParam(defaultValue = "id,desc") String sort
    ) {
        return ResponseEntity.ok(service.searchPackages(keyword, minPrice, maxPrice, duration,sort));
    }
    @GetMapping("/{id}")
    public ResponseEntity<TravelPackageListDTO> getPackageById(@PathVariable Long id) {
        return service.getPackageDetail(id);
    }
}