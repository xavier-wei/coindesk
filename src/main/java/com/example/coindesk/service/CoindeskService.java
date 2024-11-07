package com.example.coindesk.service;


import com.example.coindesk.util.CoindeskUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@Service
public class CoindeskService {


    @Autowired
    private CoinConfigService coinConfigService;


    // 取得 Coindesk 原始 JSON 資料
    public String getCoindeskApiData() {
        RestTemplate restTemplate = new RestTemplate();
        String coindeskApiUrl = "https://api.coindesk.com/v1/bpi/currentprice.json";
        ResponseEntity<String> response = restTemplate.getForEntity(coindeskApiUrl, String.class);
        return response.getBody();
    }

    /**
     * 取得轉換後的 Coindesk 資料。
     *
     * 1. 呼叫 Coindesk API，取當前資訊。
     * 2. 解析 API 回應的 JSON 資料。
     * 3. 轉換資料結構，返回包含更新時間和幣別相關資訊的 Map。
     *
     * @return 一個 Map，包含更新時間和幣別相關資訊：
     *         - "updatedTime":  更新時間 (格式為 yyyy/MM/dd HH:mm:ss)
     *         - "currencyInfo": 幣別相關資訊的 Map，每個幣別代碼對應的資料，包括：
     *         - "currencyCode": 幣別代碼
     *         - "currencyName": 幣別名稱
     *         - "rateFloat":    匯率浮點數
     */
    public Map<String, Object> getConvertedCoindeskData() {
        // 呼叫 Coindesk API
        RestTemplate restTemplate = new RestTemplate();
        String coindeskApiUrl = "https://api.coindesk.com/v1/bpi/currentprice.json";
        ResponseEntity<String> response = restTemplate.getForEntity(coindeskApiUrl, String.class);

        // 解析 JSON 資料
        CoindeskUtil.CoindeskResponse coindeskResponse = CoindeskUtil.parseJson(response.getBody());

        // 資料轉換
        Map<String, Object> convertedData = new HashMap<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        convertedData.put("updatedTime", coindeskResponse.getTime().getUpdatedISO().format(formatter));

        // 幣別相關資訊
        Map<String, Object> currencyInfo = new HashMap<>();
        coindeskResponse.getBpi().forEach((currencyCode, bpi) -> {
            Map<String, Object> currencyData = new HashMap<>();
            currencyData.put("currencyCode", bpi.getCode());
            currencyData.put("currencyName", coinConfigService.getCurrencyNameInChinese(bpi.getCode()));
            currencyData.put("rateFloat", bpi.getRateFloat());
            currencyInfo.put(currencyCode, currencyData);
        });
        convertedData.put("currencyInfo", currencyInfo);

        return convertedData;
    }
}
