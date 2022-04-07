/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emp.modelo;
import java.util.*;
import java.sql.*;
import emp.entidades.*;
/**
 *
 * @author Ricardo Burgos
 */
public class DaoDepartamento extends Conexion implements Crud{
    
    PreparedStatement ps;
    ResultSet rs;
    int res=0;
    Departamento dep;
    Empleado emp;
    
    @Override
    public ArrayList<Object> mostrar() throws ClassNotFoundException, 
            SQLException {
        ArrayList<Object> ar = new ArrayList<>();
        ps= super.con().prepareStatement("SELECT * FROM departamento");
        try {
            rs= ps.executeQuery();
            while (rs.next()) {
               dep= new Departamento(rs.getString(2),rs.getInt(1)); 
               ar.add(emp);
            }
        } catch (Exception e) {
        }
        finally{
            ps.close();
            super.con().close();
            }
        return ar;
    }

    @Override
    public int agregar(Object ob) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int modificar(Object ob) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int eliminar(Object ob) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
