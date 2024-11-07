package com.example.coindesk;

import com.example.coindesk.controller.CoinConfigController;
import com.example.coindesk.entity.CoinConfig;
import com.example.coindesk.entity.CoinType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class CoinConfigControllerTest {

    @Autowired
    private CoinConfigController coinConfigController;

    // 測試查詢幣別
    @Test
    public void testGetAllCoinTypes() {
        ResponseEntity<List<CoinConfig>> response = coinConfigController.getAllCoinConfigs();
        assertNotNull(response);
        assertNotNull(response.getBody());
        System.out.println("查詢幣別資料: " + response.getBody());
    }

    // 測試新增幣別
    @Test
    public void testCreateCoinType() {
        CoinConfig coinConfig = new CoinConfig();
        coinConfig.setDescriptionEn("USD");
        coinConfig.setDescriptionCh("美國美元");
        coinConfig.setUpdateTime(java.time.LocalDateTime.now());

        ResponseEntity<CoinConfig> response = coinConfigController.createCoinConfig(coinConfig);
        assertNotNull(response);
        assertNotNull(response.getBody());
        System.out.println("新增幣別資料: " + response.getBody());
    }

    // 測試修改幣別
    @Test
    public void testUpdateCoinType() {
        CoinConfig initialConfig = new CoinConfig();
        initialConfig.setDescriptionEn("USD");
        initialConfig.setDescriptionCh("美國美元");
        initialConfig.setUpdateTime(java.time.LocalDateTime.now());

        ResponseEntity<CoinConfig> createResponse = coinConfigController.createCoinConfig(initialConfig);
        assertNotNull(createResponse);
        assertNotNull(createResponse.getBody());
        Long idToUpdate = createResponse.getBody().getId();

        CoinConfig coinConfig = new CoinConfig();
        coinConfig.setId(idToUpdate);
        coinConfig.setDescriptionEn("USD");
        coinConfig.setDescriptionCh("更新後的美國美元");
        coinConfig.setUpdateTime(java.time.LocalDateTime.now());

        ResponseEntity<CoinConfig> response = coinConfigController.updateCoinConfig(idToUpdate, coinConfig);

        assertNotNull(response);
        assertNotNull(response.getBody());
        System.out.println("更新幣別資料: " + response.getBody());
    }

    // 測試刪除幣別
    @Test
    public void testDeleteCoinType() {

        CoinConfig coinConfig = new CoinConfig();
        coinConfig.setDescriptionEn("USD");
        coinConfig.setDescriptionCh("美國美元");
        coinConfig.setUpdateTime(java.time.LocalDateTime.now());
        coinConfigController.createCoinConfig(coinConfig);


        ResponseEntity<String> response = coinConfigController.deleteCoinConfig(coinConfig.getId());
        assertNotNull(response);
        assertEquals("CoinConfig deleted successfully", response.getBody());
    }

}
