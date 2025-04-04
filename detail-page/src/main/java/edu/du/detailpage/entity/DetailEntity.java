package edu.du.detailpage.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
//@Table(name = "PackageDetail")
public class DetailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    @Column(name = "image_url")
    private String imageUrl;
    private int price;
    private String date;
}
