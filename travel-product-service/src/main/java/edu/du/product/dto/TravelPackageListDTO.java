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
//    private String flightInfo; 미사용
//    private String hotelInfo; 미사용
//    private String tourInfo; 미사용
    private String imageUrl;
    private String date;
}
