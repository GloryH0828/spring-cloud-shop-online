package com.gloryh.controller;

import com.gloryh.entity.Order;
import com.gloryh.entity.OrderItem;
import com.gloryh.entity.OrderVO;
import com.gloryh.repository.OrderItemRepository;
import com.gloryh.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *  order controller
 *
 * @author 黄光辉
 * @since 2020/11/20
 **/
@RestController
@RequestMapping("/order")
public class OrderHandler {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;
    @GetMapping("/findAll/{thisPage}")
    public OrderVO findAll(@PathVariable int thisPage){
        int current =thisPage;
        if (thisPage == 0){
            current =1;
        }
        OrderVO orderVO = new OrderVO(current,orderRepository.count());
        orderVO.setPageSize(4);
       orderVO.setList(orderRepository.findAll(orderVO.getStartIndex(),orderVO.getPageSize()));
       return orderVO;
    }
    @PostMapping("/save")
    public void save(@RequestBody Order order){
        orderRepository.save(order);
        for (OrderItem orderItem:order.getOrderItems()) {
            orderItemRepository.save(orderItem);
        }
    }
    @GetMapping("/findById/{orderId}")
    public Order findById(@PathVariable String orderId){
        return orderRepository.findById(orderId);
    }
    @GetMapping("/findByVipId/{v_id}")
    public List<Order> findByVipId(@PathVariable int v_id){
        return orderRepository.findByVipId(v_id);
    }
    @PutMapping("/updateAddressById/{order_id}/{address_id}")
    public void updateAddressById(@PathVariable String order_id,@PathVariable int address_id){
        orderRepository.updateAddressById(order_id,address_id);
    }
    @PutMapping("/updateStatusByOrderId/{order_id}/{status}")
    public void updateStatusById(@PathVariable String order_id,@PathVariable int status){
        orderRepository.updateStatus(status,order_id);
    }
}
