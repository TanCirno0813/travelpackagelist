package edu.du.detailpage.controller;

import edu.du.detailpage.dto.Detail;
import edu.du.detailpage.service.DetailProxyService;
import edu.du.detailpage.service.DetailService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;



@RestController
@RequestMapping("/packages/detail") // 👈 경로를 Gateway와 일치시키기
@RequiredArgsConstructor
public class DetailController {

    private final DetailService detailService;
    private final DetailProxyService proxyService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getPackageDetail(@PathVariable Long id) {
        Detail dto = proxyService.getPackageById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Detail>> getAllPackages() {
        List<Detail> packages = detailService.findAll();
        return ResponseEntity.ok(packages);
    }
}
