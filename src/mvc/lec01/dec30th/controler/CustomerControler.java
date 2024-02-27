/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.lec01.dec30th.controler;
import mvc.lec01.dec30th.modle.CustomerModle;
import mvc.lec01.dec30th.dto.CustomerDto;
import java.util.ArrayList;


/**
 *
 * @author kavindi
 */
public class CustomerControler {
    private CustomerModle customermodle;
    
    public CustomerControler(){
     customermodle = new CustomerModle();
    }
    
    public String saveCustomer(CustomerDto customerdto) throws Exception{
       return customermodle.saveCustomer(customerdto);
    }
    
    public ArrayList<CustomerDto> getAllCustomer() throws Exception{
        return customermodle.getAllCustomer();
    }

    public CustomerDto searchCustomer(String id)throws Exception {
        return customermodle.searchCustomer(id);
        
    }

    public String updateCustomer(CustomerDto dto) throws Exception {
        return customermodle.updateCustomer(dto);
    }

    public String deleteCustomer(String id) throws Exception {
        return customermodle.deleteCustomer(id);
    }
}
