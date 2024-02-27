/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.lec01.dec30th.controler;
import mvc.lec01.dec30th.dto.ItemDto;
import mvc.lec01.dec30th.modle.ItemModel;
/**
 *
 * @author kavindi
 */
public class ItemController {
    
   private ItemModel itemModel;
    
    public ItemController(){
        itemModel = new ItemModel();
    }

    public ItemDto searchItem(String itemId) throws Exception {
        return itemModel.searchItem(itemId);
    }
    
    
    
    
    
    
}
