package com.example.coindesk.service;

import com.example.coindesk.entity.CoinType;
import com.example.coindesk.repository.CoinTypeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service
public class CoinTypeService {

    private final Logger log = LoggerFactory.getLogger(CoinTypeService.class);

    @Autowired
    private CoinTypeRepository coinTypeRepository;

    // 新增
    @Transactional
    public CoinType createCoinType(CoinType coinType) {
        log.info("CoinTypeService.java - createCoinType - 26 :: " + coinType );
        return coinTypeRepository.save(coinType);
    }

    // 查詢
    public List<CoinType> getAllCoinTypes() {
        return coinTypeRepository.findAll();
    }

    public Optional<CoinType> getCoinTypeByCode(String code) {
        log.info("CoinTypeService.java - getCoinTypeByCode - 36 :: " + code );
        return coinTypeRepository.findById(code);
    }

    // 修改
    @Transactional
    public CoinType updateCoinType(String code, CoinType coinTypeDetails) {
        log.info("CoinTypeService.java - updateCoinType - 43 :: " + code );
        log.info("CoinTypeService.java - updateCoinType - 44 :: " + coinTypeDetails );
        Optional<CoinType> existingCoinType = coinTypeRepository.findById(code);
        if (existingCoinType.isPresent()) {
            CoinType coinType = existingCoinType.get();
            coinType.setSymbol(coinTypeDetails.getSymbol());
            coinType.setRate(coinTypeDetails.getRate());
            coinType.setDescriptionEn(coinTypeDetails.getDescriptionEn());
            coinType.setDescriptionCh(coinTypeDetails.getDescriptionCh());
            coinType.setRateFloat(coinTypeDetails.getRateFloat());
            coinType.setUpdateTime(coinTypeDetails.getUpdateTime());
            return coinTypeRepository.save(coinType);
        } else {
            throw new RuntimeException("CoinType not found with code: " + code);
        }
    }

    // 刪除
    @Transactional
    public void deleteCoinType(String code) {
        log.info("CoinTypeService.java - deleteCoinType - 63 :: " + code );
        coinTypeRepository.deleteById(code);
    }

}
