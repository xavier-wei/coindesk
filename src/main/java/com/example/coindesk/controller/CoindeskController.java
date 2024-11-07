package com.example.coindesk.controller;


import com.example.coindesk.entity.CoinType;
import com.example.coindesk.service.CoinTypeService;
import com.example.coindesk.service.CoindeskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/coindesk")
public class CoindeskController {

    @Autowired
    private CoindeskService coindeskService;

    @Autowired
    private CoinTypeService coinTypeService;

    // 取得 Coindesk 原始 JSON 資料
    @GetMapping("/coindesk-data")
    public ResponseEntity<String> getCoindeskApiData() {
        return ResponseEntity.ok(coindeskService.getCoindeskApiData());
    }

    @GetMapping("/converted")
    public ResponseEntity<Map<String, Object>> getConvertedCoindeskData() {
        return ResponseEntity.ok(coindeskService.getConvertedCoindeskData());
    }

    // 新增
    @PostMapping("/create")
    public ResponseEntity<CoinType> createCoinType(@RequestBody CoinType coinType) {
        return ResponseEntity.ok(coinTypeService.createCoinType(coinType));
    }

    // 查詢所有
    @GetMapping("/all")
    public ResponseEntity<List<CoinType>> getAllCoinTypes() {
        return ResponseEntity.ok(coinTypeService.getAllCoinTypes());
    }

    // 查詢單一幣別
    @GetMapping("/{code}")
    public ResponseEntity<Optional<CoinType>> getCoinTypeByCode(@PathVariable String code) {
        return ResponseEntity.ok(coinTypeService.getCoinTypeByCode(code));
    }

    // 修改
    @PutMapping("/update/{code}")
    public ResponseEntity<CoinType> updateCoinType(@PathVariable String code, @RequestBody CoinType coinTypeDetails) {
        return ResponseEntity.ok(coinTypeService.updateCoinType(code, coinTypeDetails));
    }

    // 刪除
    @DeleteMapping("/delete/{code}")
    public ResponseEntity<String> deleteCoinType(@PathVariable String code) {
        coinTypeService.deleteCoinType(code);
        return ResponseEntity.ok("CoinType deleted successfully");
    }
}


