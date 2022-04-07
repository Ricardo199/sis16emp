    R<%-- 
    Document   : vistaEmpleado
    Created on : Sep 20, 2019, 1:01:28 PM
    Author     : Ricardo Burgos
--%>

<%@page import="emp.entidades.*" import="java.util.*" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
    <head>
        <script src="sweetalert2@8.js" type="text/javascript"></script>
        <link href="bootstrap/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <script src="bootstrap/bootstrap/js/bootstrap.js" type="text/javascript"></script>
        <script src="jquery-3.4.1.min.js" type="text/javascript"></script>
        <script>
            $(document).ready(function(){
                $("#del").click(function(){
                   swal.fire({
                     type:"info",
                     title:"Eliminar Empleado",
                     text:"Despues de eliminar no se podra recuperar",
                     showCancelButton:true,
                     calcelButtonColor:"red",
                     cancelButtonText:"Cancelar",
                     confirmButtonColor:"green",
                     confirmButtonText:"Eliminar"
                   }).then(result=>{
                       if(result.value){
                           $("#oc").append("<input type='hidden' name='eliminar'>");
                           $("#f1").submit();
                       }
                   });
                });
            });
        </script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Gestion Empleado</h1>
        <c:if test="${empleado==null}">
            <c:redirect url="ControlEmpleado?mostrar=1"/>
        </c:if>
        <div class="col-5">
            <form name="f1" id="f1" action="ControlEmpleado" method="POST">
            <div id="oc"></div>
            <label>ID Empleado</label>
            <input type="text" name="idEmp" id="idEmp" value="" class="form form-control" />
            <label>Nombre</label>
            <input type="text" name="nombre" id="nombre" value="" class="form form-control"/>
            <label>Departameno</label><br>
            <select name="idDepto" id="departamento">
                <option>default</option>
                <c:if test="${departamento!=null}">
                    <c:forEach var="d" items="${departamento}">
                        <option value='${d.getId_depto()}'>${'d.getNombre()'}</option>
                    </c:forEach>
                </c:if>                
            </select> <br>
            <br><input type="reset" onclick="$('#g').attr('disabled'),false" value="Nuevo" name="Nuevo" class="btn btn-success" />
            <input type="submit" value="Guardar" disabled="true" id="g" name="Guardar" class="btn btn-success"/>
            <input type="submit" value="Modificar" name="Modificar" class="btn btn-success"/>
            <input type="button" value="Eliminar" name="Eliminar" id="del" class="btn btn-success"/>
        </form><br>
            <table class="table">
                <tr>
                    <th>
                        ID
                    </th>
                </tr>
                
                <tr>
                    <th>
                        NOMBRE
                    </th>
                </tr>
                
                <tr>
                    <th>
                        DEPARTAMENTO
                    </th>
                </tr>
                
                <tr>
                    <th>
                        ACCTION
                    </th>
                </tr>
                <c:if test="${empleados!=null}">
                    <c:forEach var="e" items="empleados">
                        <tr><td>${e.getId_emp()}</td><td>${
                        e.getNombre()}</td><td>
                        ${e.getDepto().getId_depto()}</td>
                        <td><input type='button' value='Editar' 
                        class='btn btn-danger' 
                        onclick="$('#idemp').val('${e.getId_emp()}');
                        $('#nombre').val('${e.getNombre()}');
                        $('#depto').val('${e.getDepto().getId_depto()}');"></td>
                        </tr>"
                    </c:forEach>
                </c:if>
            </table>
            <c:if test="${r!=null}">
                <script>swal.fire('Resultado','request.getAttribute("r")','info');</script>
            </c:if>
            <%
                if(request.getAttribute("r")!=null){
                    out.println("");
                }
                if(request.getAttribute("error")!=null){
                    out.println("<script>swal.fire('Error','"+request.getAttribute("r")+"','info');</script>");
                }
            %>
        </div>
    </body>
</html>
