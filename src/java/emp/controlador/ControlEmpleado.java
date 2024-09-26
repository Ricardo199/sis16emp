/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emp.controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import emp.entidades.*;
import emp.modelo.*;

/**
 *
 * @author Ricardo Burgos
 */
public class ControlEmpleado extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            DaoEmpleado ob1 = new DaoEmpleado();
            DaoDepartamento ob2 = new DaoDepartamento();
            RequestDispatcher res;
            Empleado emp;
            int r;
            if(request.getParameter("mostrar")!=null){
                try {
                    request.setAttribute("empleado", ob1.mostrar());
                    request.setAttribute("departamento", ob2.mostrar());
                } catch (Exception e) {
                    request.setAttribute("error", e.getMessage());
                }
            }
            if(request.getParameter("guardar")!=null){
                try {
                       request.setAttribute("empleado", ob1.mostrar());
                       request.setAttribute("departamento", ob2.mostrar());                     
                      emp = new Empleado(request.getParameter("nombre"),new Departamento(Integer.parseInt(request.getParameter("idDepto"))));
                      r= ob1.agregar(emp);
                      if(r>0){
                          request.setAttribute("r", "El registro fue creado correctamente");
                      }else{
                          request.setAttribute("r", "El registro no fue creado correctamente");
                      }
                } catch (Exception e) {
                    request.setAttribute("error", e.getMessage());
                }
            }            
            if(request.getParameter("modificar")!=null){
                try {
                      emp= new Empleado(Integer.parseInt(request.getParameter("idEmp")), request.getParameter("nombre"), new Departamento(Integer.parseInt(request.getParameter("idDepto"))));
                      r= ob1.modificar(emp);
                      if(r>0){
                          request.setAttribute("r", "El registro fue modificado correctamente");
                      }else{
                          request.setAttribute("r", "El registro no fue modificado correctamente");
                      }
                } catch (Exception e) {
                    request.setAttribute("error", e.getMessage());
                }
            }
            if(request.getParameter("eliminar")!=null){
                try {
                      emp= new Empleado(Integer.parseInt(request.getParameter("idEmp")));
                      r= ob1.eliminar(emp);
                      if(r>0){
                          request.setAttribute("r", "El registro fue eliminado correctamente");
                      }else{
                          request.setAttribute("r", "El registro no fue eliminado correctamente");
                      }
                } catch (Exception e) {
                    request.setAttribute("error", e.getMessage());
                }
            }
            res=request.getRequestDispatcher("vistaEmpleado.jsp");
            res.forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
