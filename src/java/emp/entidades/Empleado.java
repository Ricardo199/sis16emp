/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emp.entidades;

/**
 *
 * @author Ricardo Burgos
 */
public class Empleado {
    private int id_emp;
    private String nombre;
    private Departamento depto;

    public Empleado() {
    }

    public Empleado(int id_emp, String nombre, Departamento depto) {
        this.id_emp = id_emp;
        this.nombre = nombre;
        this.depto = depto;
    }

    public Empleado(int id_emp, String nombre) {
        this.id_emp = id_emp;
        this.nombre = nombre;
    }

    public Empleado(String nombre, Departamento depto) {
        this.nombre = nombre;
        this.depto = depto;
    }

    public Empleado(int id_emp) {
        this.id_emp = id_emp;
    }

    public int getId_emp() {
        return id_emp;
    }

    public void setId_emp(int id_emp) {
        this.id_emp = id_emp;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Departamento getDepto() {
        return depto;
    }

    public void setDepto(Departamento depto) {
        this.depto = depto;
    }
    
    
}
