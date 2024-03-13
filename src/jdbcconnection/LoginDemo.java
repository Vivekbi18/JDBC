/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdbcconnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;

/**
 *
 * @author lenovo
 */
public class LoginDemo {
    
    public static void main(String[] args) {
 
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            System.out.print("Enter Name : ");
            String user_name = br.readLine();
            System.out.print("Enter Age : ");
                int user_age = Integer.parseInt(br.readLine());
            
//            String user_name = "Vivek";
//                int user_age = 21;
              Class.forName("com.mysql.cj.jdbc.Driver");
              Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/college","root","2022");
//              PreparedStatement ps = con.prepareStatement("SELECT * FROM students WHERE name = '"+user_name+"' AND age = '"+user_age+"'");
                                                 //or
              PreparedStatement ps = con.prepareStatement("SELECT * FROM students WHERE name = ? AND age = ?"); 
              ps.setString(1, user_name);
              ps.setInt(2, user_age);

              ResultSet rs = ps.executeQuery();
                  
                  if(rs.next()){
                      System.out.println("Logged in Successfully.....................");
                      System.out.println("Welcome : "+rs.getString("name"));
                  }
                  else{
                       System.out.println("Incorrect Username or Password.....................");
             }

        }
        catch (Exception e) {
            System.out.println(e);
        }
      
    }
    
}
