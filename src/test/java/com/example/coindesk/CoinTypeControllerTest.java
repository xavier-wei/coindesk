package com.example.coindesk;


import com.example.coindesk.controller.CoindeskController;
import com.example.coindesk.entity.CoinType;
import com.example.coindesk.service.CoindeskService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class CoinTypeControllerTest {


    @Autowired
    CoindeskController coinTypeController;


    // 測試查詢幣別對應表資料API
    @Test
    public void testGetAllCoinTypes() {
        ResponseEntity<List<CoinType>> response = coinTypeController.getAllCoinTypes();
        assertNotNull(response);
        assertNotNull(response.getBody());
        System.out.println("查詢幣別對應表資料: " + response.getBody());
    }

    // 測試新增幣別對應表資料API
    @Test
    public void testCreateCoinType() {
        CoinType coinType = new CoinType();
        coinType.setCode("USD");
        coinType.setSymbol("&#36");
        coinType.setRate("1.0");
        coinType.setDescriptionEn("United States Dollar");
        coinType.setDescriptionCh("美國美元");
        coinType.setRateFloat(new java.math.BigDecimal("1.0"));
        coinType.setUpdateTime(java.time.LocalDateTime.now());
        ResponseEntity<CoinType> response = coinTypeController.createCoinType(coinType);
        assertNotNull(response);
        assertNotNull(response.getBody());
        System.out.println("新增幣別對應表資料: " + response.getBody());
    }

    // 測試更新幣別對應表資料API
    @Test
    public void testUpdateCoinType() {
        CoinType coinTypeDetails = new CoinType();
        coinTypeDetails.setSymbol("&#36");
        coinTypeDetails.setRate("1.2");
        coinTypeDetails.setDescriptionEn("Updated United States Dollar");
        coinTypeDetails.setDescriptionCh("更新後的美國美元");
        coinTypeDetails.setRateFloat(new java.math.BigDecimal("1.2"));
        coinTypeDetails.setUpdateTime(java.time.LocalDateTime.now());
        ResponseEntity<CoinType> response = coinTypeController.updateCoinType("USD", coinTypeDetails);
        assertNotNull(response);
        assertNotNull(response.getBody());
        System.out.println("更新幣別對應表資料: " + response.getBody());
    }

    // 測試刪除幣別對應表資料API
    @Test
    public void testDeleteCoinType() {
        ResponseEntity<String> response = coinTypeController.deleteCoinType("USD");
        assertNotNull(response);
        assertEquals("CoinType deleted successfully", response.getBody());
        System.out.println("刪除幣別對應表資料: " + response.getBody());
    }

    // 測試呼叫coindesk API
    @Test
    public void testGetCoindeskApiData() {
        ResponseEntity<String> response = coinTypeController.getCoindeskApiData();
        assertNotNull(response);
        assertNotNull(response.getBody());
        System.out.println("Coindesk API 資料: " + response.getBody());
    }

    // 測試呼叫資料轉換的API
    @Test
    public void testGetConvertedCoindeskData() {
        ResponseEntity<Map<String, Object>> response = coinTypeController.getConvertedCoindeskData();
        assertNotNull(response);
        assertNotNull(response.getBody());
        System.out.println("測試呼叫資料轉換的API資料: " + response.getBody());
    }
}
