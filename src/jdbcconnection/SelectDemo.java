/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdbcconnection;

import java.sql.*;
/**
 *
 * @author lenovo
 */
public class SelectDemo {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/college","root","2022");
            PreparedStatement ps = con.prepareStatement("SELECT * FROM students");
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                System.out.println("Name : "+rs.getString("name"));
                System.out.println("Age : "+rs.getString("age"));
                System.out.println("------------------------------------------------------------------");
            }
           
        } catch (Exception e) {
            System.out.println("e");
        }
    }
    
}
