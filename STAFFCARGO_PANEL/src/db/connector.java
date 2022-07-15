/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import com.sun.jdi.connect.spi.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Finn
 */
public class connector {
    public static Connection getConnection() throws Exception
         
    {
          Class.forName("oracle.jdbc.driver.OracleDriver");
     Connection cn=(Connection)
             DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","username","password");
     
     
       return cn;
    }
}
