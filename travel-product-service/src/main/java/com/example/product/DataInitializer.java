package com.example.product;

import com.example.product.entity.TravelPackage;
import com.example.product.repository.TravelPackageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final TravelPackageRepository repository;

    @Override
    public void run(String... args) throws Exception {
        // 데이터가 이미 있다면 생략
        if (repository.count() == 0) {
            repository.save(TravelPackage.builder()
                    .title("오사카 3박 4일 자유여행")
                    .description("자유 일정 포함")
                    .price(499000)
                    .viewCount(120)
                    .reviewCount(10)
                    .flightInfo("대한항공 직항")
                    .hotelInfo("오사카 호텔 3박")
                    .tourInfo("오사카성, 도톤보리")
                    .build());

            repository.save(TravelPackage.builder()
                    .title("다낭 풀빌라 패키지")
                    .description("풀빌라 숙박 포함")
                    .price(799000)
                    .viewCount(200)
                    .reviewCount(25)
                    .flightInfo("베트남 항공")
                    .hotelInfo("다낭 풀빌라 3박")
                    .tourInfo("바나힐, 호이안 투어")
                    .build());
        }
    }
}
