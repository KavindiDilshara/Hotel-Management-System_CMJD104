/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.lec01.dec30th;
import mvc.lec01.dec30th.view.CustomerView;
import mvc.lec01.dec30th.view.OrderView;


/**
 *
 * @author kavindi
 */
public class Main {
    public static void main(String args[]){
        System.out.println("Hello");
        new CustomerView().setVisible(true);
       new OrderView().setVisible(true);
    }
}
