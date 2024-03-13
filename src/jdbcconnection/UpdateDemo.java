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
public class UpdateDemo {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter name : ");
        String user_name = sc.next();
        System.out.print("Enter age (to be updated) : ");
        int user_age = sc.nextInt();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/college","root","2022");
            PreparedStatement ps = con.prepareStatement("UPDATE students SET age = ? WHERE name = ?");
            ps.setInt(1, user_age);
            ps.setString(2, user_name);
            
           int returned_value = ps.executeUpdate();
           
           if(returned_value>0){
               System.out.println("Age updated Successfully.........");
           }
           else{
               System.out.println("Updation failed...............");
           }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
