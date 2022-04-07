/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emp.modelo;
import java.sql.*;

/**
 *
 * @author Ricardo Burgos
 */
public class Conexion {
    private String driver="com.mysql.jdb.Driver";
    private String url="jdbc:mysql://localhost:3306/sis16emp";
    private String user="root";
    private String pass="";
    
    public Connection con()throws SQLException, ClassNotFoundException{
        Class.forName(driver);
        return DriverManager.getConnection(url+user+pass);
    }
}
