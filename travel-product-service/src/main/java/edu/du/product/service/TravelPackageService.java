package edu.du.product.service;

import edu.du.product.dto.TravelPackageListDTO;
import edu.du.product.entity.TravelPackage;
import edu.du.product.repository.TravelPackageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TravelPackageService {
    private final TravelPackageRepository repository;

    public Page<TravelPackageListDTO> getPackages(String sort, int page, int size) {
        String[] sortParams = sort.split(",");
        String sortBy = sortParams[0];
        Sort.Direction direction = sortParams.length > 1 && sortParams[1].equalsIgnoreCase("asc")
                ? Sort.Direction.ASC
                : Sort.Direction.DESC;

        Pageable pageable = PageRequest.of(page, size, Sort.by(direction, sortBy));

        return repository.findAll(pageable)
                .map(pkg -> TravelPackageListDTO.builder()
                        .id(pkg.getId())
                        .title(pkg.getTitle())
                        .description(pkg.getDescription())
                        .price(pkg.getPrice())
                        .flightInfo(pkg.getFlightInfo())
                        .hotelInfo(pkg.getHotelInfo())
                        .tourInfo(pkg.getTourInfo())
                        .imageUrl(pkg.getImageUrl())
                        .build());
    }

    public List<TravelPackageListDTO> searchPackages(String keyword, Integer minPrice, Integer maxPrice) {
        return repository.findAll().stream()
                .filter(pkg -> keyword == null || pkg.getTitle().contains(keyword))
                .filter(pkg -> minPrice == null || pkg.getPrice() >= minPrice)
                .filter(pkg -> maxPrice == null || pkg.getPrice() <= maxPrice)
                .map(pkg -> TravelPackageListDTO.builder()
                        .id(pkg.getId())
                        .title(pkg.getTitle())
                        .description(pkg.getDescription())
                        .price(pkg.getPrice())
                        .flightInfo(pkg.getFlightInfo())
                        .hotelInfo(pkg.getHotelInfo())
                        .tourInfo(pkg.getTourInfo())
                        .imageUrl(pkg.getImageUrl())
                        .build())
                .collect(Collectors.toList());
    }

}
