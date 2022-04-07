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
public class DaoEmpleado extends Conexion implements Crud{
    
    PreparedStatement ps;
    ResultSet rs;
    int res=0;
    Departamento dep;
    Empleado emp;
    
    @Override
    public ArrayList<Object> mostrar() throws ClassNotFoundException, 
            SQLException{
        ArrayList<Object> ar = new ArrayList<>();
        ps= super.con().prepareStatement("SELECT * FROM empleado, departamento "
                + "WHERE empleado.id_dep=departamento.id_dep");
        try {
            rs= ps.executeQuery();
            while (rs.next()) {
               dep= new Departamento(rs.getString(5),rs.getInt(4));
               //tambien es valido rs.getInt("id_dep")
               emp= new Empleado(rs.getInt(1),rs.getString(2) , dep);
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
    public int agregar(Object ob) throws ClassNotFoundException,SQLException{
        emp= (Empleado) ob;
        ps= super.con().prepareStatement("INSERT INTO empleado(nombre,id_dep)"
                + "VALUES(?,?)");
        ps.setString(1, emp.getNombre());
        ps.setInt(2, emp.getDepto().getId_depto());
        try {
            res= ps.executeUpdate();
        } catch (Exception e) {
        }finally{
            ps.close();
            super.con().close();
        }
            return res;
    }

    @Override
    public int modificar(Object ob) throws ClassNotFoundException,SQLException{
        emp= (Empleado) ob;
        ps= super.con().prepareStatement("UPDATE empleado set nombre=?, "
                + "id_dep=? WHERE id_emp=?");
        ps.setString(1, emp.getNombre());
        ps.setInt(2, emp.getDepto().getId_depto());
        ps.setInt(3, emp.getId_emp());
        try {
            res= ps.executeUpdate();
        } catch (Exception e) {
        }finally{
        ps.close();
        super.con().close();
        }
        return res;
    }

    @Override
    public int eliminar(Object ob) throws ClassNotFoundException, SQLException {
       emp= (Empleado) ob;
        ps= super.con().prepareStatement("DELETE FROM empleado WHERE id_emp=?");
        ps.setInt(1, emp.getId_emp());
        try {
            res= ps.executeUpdate();
        } catch (Exception e) {
        }finally{
        ps.close();
        super.con().close();
        }
        return res;
    }
    
}
