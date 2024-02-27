/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.lec01.dec30th.controler;
import mvc.lec01.dec30th.modle.OrderModel;
import mvc.lec01.dec30th.dto.*;
import java.util.ArrayList;

/**
 *
 * @author kavindi
 */
public class OrderController {
    
    private OrderModel orderModel;
    
     public OrderController() {
        this.orderModel = new OrderModel();
    }
    
      public String placeOrder(OrderDto orderDto, ArrayList<OrderDetailDto> orderDetailDtos) throws Exception{
        return orderModel.placeOrder(orderDto, orderDetailDtos);
    }
}
