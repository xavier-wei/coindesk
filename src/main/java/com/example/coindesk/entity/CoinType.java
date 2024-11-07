package com.example.coindesk.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "coin_type")
public class CoinType {

    @Id
    @Column(name = "code",length = 4)
    private String code;

    @Column(name = "symbol",length = 15)
    private String symbol;

    @Column(name = "rate",length = 20)
    private String rate;

    @Column(name = "description_en",length = 100)
    private String descriptionEn;

    @Column(name = "description_ch",length = 100)
    private String descriptionCh;

    @Column(name = "rate_float",precision = 10, scale = 4)
    private BigDecimal rateFloat;

    @Column(name = "update_time")
    private LocalDateTime updateTime;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getDescriptionEn() {
        return descriptionEn;
    }

    public void setDescriptionEn(String descriptionEn) {
        this.descriptionEn = descriptionEn;
    }

    public String getDescriptionCh() {
        return descriptionCh;
    }

    public void setDescriptionCh(String descriptionCh) {
        this.descriptionCh = descriptionCh;
    }

    public BigDecimal getRateFloat() {
        return rateFloat;
    }

    public void setRateFloat(BigDecimal rateFloat) {
        this.rateFloat = rateFloat;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "CoinType{" +
                "code='" + code + '\'' +
                ", symbol='" + symbol + '\'' +
                ", rate='" + rate + '\'' +
                ", descriptionEn='" + descriptionEn + '\'' +
                ", descriptionCh='" + descriptionCh + '\'' +
                ", rateFloat=" + rateFloat +
                ", updateTime=" + updateTime +
                '}';
    }
}
