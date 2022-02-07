package com.zjl.spring_cloud_explore.spring_cloud_account.repository;

import com.zjl.spring_cloud_explore.spring_cloud_account.model.AccountPO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;

/**
 * @author zhou
 * @className AccountRepository
 * @date 2022/02/07 10:43
 * @description
 **/
public interface AccountRepository extends JpaRepository<AccountPO,Long> {

    @Modifying
    @Query(value = "update AccountPO as a set a.money = a.money - :money where a.id = :customerId and a.money > :money")
    int subMoney(@Param("customerId") Long customerId,@Param("money") BigDecimal money);

}
