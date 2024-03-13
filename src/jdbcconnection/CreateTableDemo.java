/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdbcconnection;
import java.sql.*;
import java.util.Scanner;
/**
 *
 * @author lenovo
 */
public class CreateTableDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter table name (to be created) : ");
        String table_name = sc.next();
        
        System.out.print("Enter first field name : ");
        String field1 = sc.next();
      
        System.out.print("Enter second field name : ");
        String field2 = sc.next();
      
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/college","root","2022");
            PreparedStatement ps = con.prepareStatement("CREATE TABLE '"+table_name+"'('"+field1+"' int, '"+field2+"' varchar(20));");
     
           int returned_value = ps.executeUpdate();
                 
            if(returned_value > 0){
               System.out.println("Table created successfully..............");
           }
           else{
               System.out.println("Table creation failed....................");
           }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
}
