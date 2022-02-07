package com.zjl.spring_cloud_explore.spring_cloud_order.repository;


import com.zjl.spring_cloud_explore.spring_cloud_order.model.OrderPO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author zhou
 * @className OrderRepository
 * @date 2022/02/07 10:49
 * @description
 **/
public interface OrderRepository extends JpaRepository<OrderPO,Long> {
}
