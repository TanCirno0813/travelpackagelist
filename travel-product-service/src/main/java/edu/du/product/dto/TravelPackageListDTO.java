package edu.du.product.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TravelPackageListDTO {
    private Long id;
    private String title;
    private String description;
    private int price;
    private String flightInfo;
    private String hotelInfo;
    private String tourInfo;
    private String imageUrl;
}
