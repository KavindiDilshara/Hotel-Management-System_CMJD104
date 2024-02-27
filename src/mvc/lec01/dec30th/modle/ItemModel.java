/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.lec01.dec30th.modle;

import mvc.lec01.dec30th.dto.ItemDto;
import java.sql.Connection;
import mvc.lec01.dec30th.DB.DBConection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


/**
 *
 * @author kavindi
 */
public class ItemModel {

    public ItemDto searchItem(String itemId) throws Exception {
    
        Connection connection = DBConection.getInstance().getConnection();
        String sql = "Select * from Item WHERE ItemCode = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, itemId);
        ResultSet rst = statement.executeQuery();
        
        ItemDto dto = null;
       
        while(rst.next()){
            dto = new ItemDto();
            dto.setId(rst.getString("ItemCode"));
            dto.setDescription(rst.getString("Description"));
            dto.setPack(rst.getString("PackSize"));
            dto.setUnitPrice(rst.getDouble("UnitPrice"));
            dto.setQoh(rst.getInt("QtyOnHand"));
        
        }
        
        return dto;
        
    }
    
    
    
}
