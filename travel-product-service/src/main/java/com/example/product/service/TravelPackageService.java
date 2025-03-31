package com.example.product.service;

import com.example.product.entity.TravelPackage;
import com.example.product.repository.TravelPackageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TravelPackageService {
    private final TravelPackageRepository repository;

    public Page<TravelPackage> getPackages(String sort, int page, int size) {
        Sort sorting = switch (sort) {
            case "price" -> Sort.by(Sort.Direction.ASC, "price");
            case "review" -> Sort.by(Sort.Direction.DESC, "reviewCount");
            default -> Sort.by(Sort.Direction.DESC, "viewCount");
        };
        Pageable pageable = PageRequest.of(page, size, sorting);
        return repository.findAll(pageable);
    }
}
