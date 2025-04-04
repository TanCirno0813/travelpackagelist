package edu.du.product.service;

import edu.du.product.dto.TravelPackageListDTO;
import edu.du.product.entity.TravelPackage;
import edu.du.product.repository.TravelPackageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Comparator;
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
                        .date(pkg.getDate())
                        .imageUrl(pkg.getImageUrl())
                        .build());
    }

    public List<TravelPackageListDTO> searchPackages(String keyword, Integer minPrice, Integer maxPrice, String duration,String sort) {
        String[] sortParams = sort != null ? sort.split(",") : new String[]{"id", "desc"};
        String sortBy = sortParams[0];
        boolean isAsc = sortParams.length > 1 && sortParams[1].equalsIgnoreCase("asc");

        List<TravelPackageListDTO> results = repository.findAll().stream()
                .filter(pkg -> (keyword == null || keyword.isEmpty()) || pkg.getTitle().contains(keyword))
                .filter(pkg -> minPrice == null || pkg.getPrice() >= minPrice)
                .filter(pkg -> maxPrice == null || pkg.getPrice() <= maxPrice)
                .filter(pkg -> (duration == null || duration.isEmpty()) || pkg.getDate().equals(duration)) // ⭐️ 기간 필터 추가
                .map(pkg -> TravelPackageListDTO.builder()
                        .id(pkg.getId())
                        .title(pkg.getTitle())
                        .description(pkg.getDescription())
                        .price(pkg.getPrice())
                        .date(pkg.getDate())
                        .imageUrl(pkg.getImageUrl())
                        .build())
                .collect(Collectors.toList());

        // 정렬 적용
        Comparator<TravelPackageListDTO> comparator = switch (sortBy) {
            case "price" -> Comparator.comparing(TravelPackageListDTO::getPrice);
            case "title" -> Comparator.comparing(TravelPackageListDTO::getTitle);
            default -> Comparator.comparing(TravelPackageListDTO::getId);
        };

        if (!isAsc) {
            comparator = comparator.reversed();
        }

        return results.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }

    public ResponseEntity<TravelPackageListDTO> getPackageDetail(@PathVariable Long id) {
        TravelPackage entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("패키지 없음"));
        TravelPackageListDTO dto = TravelPackageListDTO.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .description(entity.getDescription())
                .price(entity.getPrice())
                .imageUrl(entity.getImageUrl())
                .date(entity.getDate())
                .build();
        return ResponseEntity.ok(dto);
    }
}
