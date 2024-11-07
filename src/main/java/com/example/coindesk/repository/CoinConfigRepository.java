package com.example.coindesk.repository;


import com.example.coindesk.entity.CoinConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface  CoinConfigRepository extends JpaRepository<CoinConfig, Long> {

    Optional<CoinConfig> findByDescriptionEn(String descriptionEn);
}
