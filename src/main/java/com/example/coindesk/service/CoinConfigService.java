package com.example.coindesk.service;


import com.example.coindesk.repository.CoinConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.coindesk.entity.CoinConfig;
import java.util.Optional;
import java.util.List;


@Service
public class CoinConfigService {

    @Autowired
    private CoinConfigRepository coinConfigRepository;

    public String getCurrencyNameInChinese(String code) {
        return coinConfigRepository.findByDescriptionEn(code)
                .map(CoinConfig::getDescriptionCh)
                .orElse("未知");
    }


    public List<CoinConfig> getAllCoinConfigs() {
        return coinConfigRepository.findAll();
    }

    public Optional<CoinConfig> getCoinConfigById(Long id) {
        return coinConfigRepository.findById(id);
    }

    public CoinConfig createCoinConfig(CoinConfig coinConfig) {
        return coinConfigRepository.save(coinConfig);
    }

    public CoinConfig updateCoinConfig(Long id, CoinConfig coinConfigDetails) {
        CoinConfig coinConfig = coinConfigRepository.findById(id).orElseThrow(() -> new RuntimeException("CoinConfig not found"));
        coinConfig.setDescriptionEn(coinConfigDetails.getDescriptionEn());
        coinConfig.setDescriptionCh(coinConfigDetails.getDescriptionCh());
        coinConfig.setUpdateTime(coinConfigDetails.getUpdateTime());
        return coinConfigRepository.save(coinConfig);
    }

    public void deleteCoinConfig(Long id) {
        coinConfigRepository.deleteById(id);
    }


}
