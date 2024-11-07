package com.example.coindesk.repository;


import com.example.coindesk.entity.CoinType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoinTypeRepository extends JpaRepository<CoinType,String> {

}
