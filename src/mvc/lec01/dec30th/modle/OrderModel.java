/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.lec01.dec30th.modle;

import java.util.ArrayList;
import mvc.lec01.dec30th.dto.OrderDetailDto;
import mvc.lec01.dec30th.dto.OrderDto;
import mvc.lec01.dec30th.DB.DBConection;
import java.sql.Connection;
import java.sql.PreparedStatement;


/**
 *
 * @author kavindi
 */
public class OrderModel {

    public String placeOrder(OrderDto orderDto, ArrayList<OrderDetailDto> orderDetailDtos)throws Exception {
        Connection connection = DBConection.getInstance().getConnection();
        try {
            connection.setAutoCommit(false);

            String orderSql = "INSERT INTO Orders VALUES(?,?,?)";
            PreparedStatement orderStatement = connection.prepareStatement(orderSql);
            orderStatement.setString(1, orderDto.getOrderId());
            orderStatement.setString(2, orderDto.getOrderDate());
            orderStatement.setString(3, orderDto.getCustId());

            boolean isOrderSaved = orderStatement.executeUpdate() > 0;

            if (isOrderSaved) {
                boolean isOrderDetailSave = true;
                String orderDetailSql = "INSERT INTO orderdetail VALUES(?,?,?,?)";
                for (OrderDetailDto orderDetailDto : orderDetailDtos) {
                    PreparedStatement orderDetailStatement = connection.prepareStatement(orderDetailSql);
                    orderDetailStatement.setString(1, orderDto.getOrderId());
                    orderDetailStatement.setString(2, orderDetailDto.getItemId());
                    orderDetailStatement.setInt(3, orderDetailDto.getQty());
                    orderDetailStatement.setDouble(4, orderDetailDto.getDiscount());

                    if (!(orderDetailStatement.executeUpdate() > 0)) {
                        isOrderDetailSave = false;
                    }
                }

                if (isOrderDetailSave) {

                    boolean isItemUpdated = true;
                    String itemSql = "UPDATE item SET QtyOnHand = QtyOnHand - ? WHERE ItemCode = ?";
                    for (OrderDetailDto orderDetailDto : orderDetailDtos) {
                        PreparedStatement itemStetement = connection.prepareStatement(itemSql);
                        itemStetement.setInt(1, orderDetailDto.getQty());
                        itemStetement.setString(2, orderDetailDto.getItemId());

                        if (!(itemStetement.executeUpdate() > 0)) {
                            isItemUpdated = false;
                        }
                    }
                    
                    if(isItemUpdated){
                        connection.commit();
                        return "Success";
                    } else {
                        connection.rollback();
                        return "Item update Error";
                    }

                } else {
                    connection.rollback();
                    return "Order Detail Save Error";
                }

            } else {
                connection.rollback();
                return "Order Save Error";
            }

        } catch (Exception e) {
            connection.rollback();
            e.printStackTrace();
            return e.getMessage();
        } finally {
            connection.setAutoCommit(true);
        }
    }
       
}
