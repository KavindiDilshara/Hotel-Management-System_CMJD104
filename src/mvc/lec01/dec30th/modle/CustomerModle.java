/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.lec01.dec30th.modle;
import mvc.lec01.dec30th.dto.CustomerDto;
import mvc.lec01.dec30th.DB.DBConection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;


/**
 *Customer behivours (methods) and activities connect with customer table on DB
 * @author kavindi
 */
public class CustomerModle {
    
    public String saveCustomer(CustomerDto customerdto) throws ClassNotFoundException,SQLException{
        Connection connection = DBConection.getInstance().getConnection();      
        
    String sql = "INSERT INTO Customer VALUES(?,?,?,?,?,?,?,?,?)";    
    PreparedStatement statement = connection.prepareStatement(sql);
    statement.setString(1, customerdto.getCustID());
    statement.setString(2, customerdto.getTitle());
    statement.setString(3, customerdto.getName());
    statement.setString(4, customerdto.getDob());
    statement.setDouble(5, customerdto.getSalary());
    statement.setString(6, customerdto.getAddress());
    statement.setString(7, customerdto.getCity());
    statement.setString(8, customerdto.getProvince());
    statement.setString(9, customerdto.getZip());
    
    return statement.executeUpdate() > 0 ? "Success":"Fail";
    }
   
    public ArrayList<CustomerDto> getAllCustomer() throws Exception {
    Connection connection = DBConection.getInstance().getConnection();
    String sql = "SELECT * FROM Customer";
    PreparedStatement statement = connection.prepareStatement(sql);
    ResultSet rst = statement.executeQuery(sql);
    
    ArrayList<CustomerDto> customerDtos = new ArrayList<>();
    
    while(rst.next()){
        CustomerDto dto = new CustomerDto();
            dto.setCustID(rst.getString("CustID"));
            dto.setTitle(rst.getString("CustTitle"));
            dto.setName(rst.getString("CustName"));
            dto.setDob(rst.getString("DOB"));
            dto.setSalary(rst.getDouble("salary"));
            dto.setAddress(rst.getString("CustAddress"));
            dto.setCity(rst.getString("City"));
            dto.setProvince(rst.getString("Province"));
            dto.setZip(rst.getString("PostalCode"));
    
            customerDtos.add(dto);
    }
        return customerDtos;
    }

    public CustomerDto searchCustomer(String id)throws Exception {
        Connection connection = DBConection.getInstance().getConnection();
        String sql = "SELECT * FROM Customer WHERE CustID=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, id);
        ResultSet rst = statement.executeQuery();
        
        CustomerDto dto = null;
        
        while(rst.next()){
            dto = new CustomerDto();
            dto.setCustID(rst.getString("CustID"));
            dto.setTitle(rst.getString("CustTitle"));
            dto.setName(rst.getString("CustName"));
            dto.setDob(rst.getString("DOB"));
            dto.setSalary(rst.getDouble("salary"));
            dto.setAddress(rst.getString("CustAddress"));
            dto.setCity(rst.getString("City"));
            dto.setProvince(rst.getString("Province"));
            dto.setZip(rst.getString("PostalCode"));
        }
        
        return dto;       
    }

    public String updateCustomer(CustomerDto dto)throws Exception {
    Connection connection = DBConection.getInstance().getConnection();
    String sql = "UPDATE Customer SET CustTitle = ? , CustName = ? , DOB = ? , salary = ? ,CustAddress = ? ,City = ? , Province = ? , PostalCode = ? WHERE CustID = ?";
    PreparedStatement statement = connection.prepareStatement(sql);
    statement.setString(1, dto.getTitle());
    statement.setString(2, dto.getName());
    statement.setString(3, dto.getDob());
    statement.setDouble(4, dto.getSalary());
    statement.setString(5, dto.getAddress());
    statement.setString(6, dto.getCity());
    statement.setString(7, dto.getProvince());
    statement.setString(8, dto.getZip());
    statement.setString(9, dto.getCustID());
    
   
     return statement.executeUpdate()> 0 ? "Update Success" : "Update Fail";
    }

    public String deleteCustomer(String id) throws Exception {
        Connection connection = DBConection.getInstance().getConnection();
        String sql = "DELETE FROM Customer WHERE CustID = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,id);
        
        return statement.executeUpdate()> 0 ? "Delete Success" : "Delete Fail";
    }
    
    
    
        
    
}
