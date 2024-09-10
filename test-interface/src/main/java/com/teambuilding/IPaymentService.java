package com.teambuilding;

/**
 * 支付接口
 */
public interface IPaymentService {


    /**
     * 根据订单id支付
     * @param id
     * @return
     */
    String payment(Integer id);


}
