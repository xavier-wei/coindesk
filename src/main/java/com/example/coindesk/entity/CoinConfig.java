package com.example.coindesk.entity;


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "coin_config")
public class CoinConfig {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description_en")
    private String descriptionEn;

    @Column(name = "description_ch")
    private String descriptionCh;

    @Column(name = "update_time")
    private LocalDateTime updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "CoinConfig{" +
                "id=" + id +
                ", descriptionEn='" + descriptionEn + '\'' +
                ", descriptionCh='" + descriptionCh + '\'' +
                ", updateTime=" + updateTime +
                '}';
    }
}
