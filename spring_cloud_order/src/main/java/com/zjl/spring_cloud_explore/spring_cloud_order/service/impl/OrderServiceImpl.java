package com.zjl.spring_cloud_explore.spring_cloud_order.service.impl;

import com.zjl.commons.util.constant.ResultCode;
import com.zjl.commons.util.error.BusinessException;
import com.zjl.commons.util.response.WebResponse;
import com.zjl.spring_cloud_explore.spring_cloud_order.fegin.AccountFeignClient;
import com.zjl.spring_cloud_explore.spring_cloud_order.fegin.StockFeignClient;
import com.zjl.spring_cloud_explore.spring_cloud_order.model.OrderPO;
import com.zjl.spring_cloud_explore.spring_cloud_order.repository.OrderRepository;
import com.zjl.spring_cloud_explore.spring_cloud_order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author zhou
 * @version 1.0
 * @className OrderServiceImpl
 * @description
 * @date 2022/02/07 10:42
 **/
@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private AccountFeignClient accountFeignClient;

    @Autowired
    private StockFeignClient stockFeignClient;

    @Override
    public OrderPO create(Long customerId, Integer productCount, String productSn) {
        //获取总价
        BigDecimal totalPrice = this.getTotal(productSn, productCount);
        //账户扣减
        accountFeignClient.subMoney(customerId,totalPrice);
        //创建订单
        OrderPO orderPO = new OrderPO();
        orderPO.setAccountId(customerId);
        orderPO.setNumber(productCount);
        orderPO.setProductSn(productSn);
        orderPO.setTotalPrice(totalPrice);
        orderRepository.save(orderPO);
        return orderPO;
    }

    /**
     * @description 计算订单价格
     * @author zhou
     * @create 2022/2/7 17:44
     * @param productCount 商品数量
     * @param productSn 商品编号
     * @return java.math.BigDecimal
     **/
    private BigDecimal getTotal(String productSn,Integer productCount){
        //计算订单价格
        WebResponse webResponse = stockFeignClient.queryMoney(productSn);
        if (webResponse.getCode().equals(ResultCode.SUCCESS.getCode())){
            BigDecimal price = (BigDecimal) webResponse.getData();
            return price.multiply(new BigDecimal(productCount));
        }else {
            //异常
            throw new BusinessException(webResponse.getCode(),webResponse.getMsg());
        }
    }
}
