package com.example.coindesk.controller;

import com.example.coindesk.entity.CoinConfig;
import com.example.coindesk.service.CoinConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/coin-config")
public class CoinConfigController {

    @Autowired
    private CoinConfigService coinConfigService;

    // 查詢所有
    @GetMapping
    public ResponseEntity<List<CoinConfig>> getAllCoinConfigs() {
        List<CoinConfig> coinConfigs = coinConfigService.getAllCoinConfigs();
        return ResponseEntity.ok(coinConfigs);
    }

    // 查詢單一
    @GetMapping("/{id}")
    public ResponseEntity<CoinConfig> getCoinConfigById(@PathVariable Long id) {
        return coinConfigService.getCoinConfigById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // 新增
    @PostMapping
    public ResponseEntity<CoinConfig> createCoinConfig(@RequestBody CoinConfig coinConfig) {
        return ResponseEntity.ok(coinConfigService.createCoinConfig(coinConfig));
    }

    // 修改
    @PutMapping("/{id}")
    public ResponseEntity<CoinConfig> updateCoinConfig(@PathVariable Long id, @RequestBody CoinConfig coinConfigDetails) {
        try {
            CoinConfig updatedCoinConfig = coinConfigService.updateCoinConfig(id, coinConfigDetails);
            return ResponseEntity.ok(updatedCoinConfig);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // 删除
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCoinConfig(@PathVariable Long id) {
        coinConfigService.deleteCoinConfig(id);
        return ResponseEntity.ok("CoinConfig deleted successfully");
    }
}
