package edu.du.detailpage.service;

import edu.du.detailpage.dto.Detail;
import edu.du.detailpage.entity.DetailEntity;
import edu.du.detailpage.repository.DetailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DetailService {
    private final DetailRepository detailRepository;

    public Optional<Detail> findById(Long id) {
        Optional<DetailEntity> detailEntityOptional = detailRepository.findById(id);
        if (detailEntityOptional.isPresent()) {
            DetailEntity detailEntity = detailEntityOptional.get();
            Detail detailDto = convertToDto(detailEntity);
            return Optional.of(detailDto);
        } else {
            return Optional.empty();
        }
    }

    public List<Detail> findAll() {
        List<DetailEntity> entities = detailRepository.findAll();
        return entities.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private Detail convertToDto(DetailEntity detailEntity) {
        Detail detailDto = new Detail();
        detailDto.setId(detailEntity.getId());
        detailDto.setTitle(detailEntity.getTitle());
        detailDto.setDescription(detailEntity.getDescription());
        detailDto.setImageUrl(detailEntity.getImageUrl());
        detailDto.setPrice(detailEntity.getPrice());
        detailDto.setDate(detailEntity.getDate());
        return detailDto;
    }

}
