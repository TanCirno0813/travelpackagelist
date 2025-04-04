package edu.du.detailpage.service;

import edu.du.detailpage.dto.Detail;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class DetailProxyService {

    private final RestTemplate restTemplate;

    public Detail getPackageById(Long id) {
        return restTemplate.getForObject(
                "http://travel-product-service/packages/" + id,
                Detail.class
        );
    }
}