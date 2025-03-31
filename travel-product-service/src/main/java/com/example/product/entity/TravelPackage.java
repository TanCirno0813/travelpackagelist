package com.example.product.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TravelPackage {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String description;
    private int price;
    private int viewCount;
    private int reviewCount;
    private String flightInfo;
    private String hotelInfo;
    private String tourInfo;
}
