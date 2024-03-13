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
public class DeleteDemo {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter name (to be deleted) : ");
        String user_name = sc.next();
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/college","root","2022");
           //PreparedStatement ps = con.prepareStatement("DELETE FROM students WHERE age = 18");
           PreparedStatement ps = con.prepareStatement("DELETE FROM students WHERE name = ?");
           ps.setString(1, user_name);
           int returned_value =   ps.executeUpdate();
           
           if(returned_value > 0){
               System.out.println("Name deleted successfully..............");
           }
           else{
               System.out.println("Deletion failed....................");
           }
          
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
}
