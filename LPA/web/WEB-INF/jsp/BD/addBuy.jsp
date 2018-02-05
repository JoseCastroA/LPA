<%-- 
    Document   : add
    Created on : 15-sept-2017, 17:39:41
    Author     : Camilo
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
    <head>
        <script type="text/javascript" src="jquery-1.2.6.min.js"></script>
        <script type="text/javascript" src="resources/Js/Javascriptprueba.js"  ></script>
        <meta charset="UTF-8">
        <title>LPA TEMPLATE</title>
       <link href="<c:url value="/resources/Css/bootstrap-3.3.7-dist/css/bootstrap.min.css"/>" rel="stylesheet"/>
    </head>
    <body>
        <div class="container">
        <h1>Añadir un producto</h1>
             <ol class="breadcrumb">
                <li><a href="admBuys.htm">Administrar Carrito</a></li>
                <li class="active">Añadir producto</li>
            </ol>
            <div class="panel panel-primary">
                <div class="panel-heading">Añadir producto</div>
                <div class="panel-body">
                    <form:form action="COMPRA_add.htm" method="post">
                        <form:errors path="*" element="div" cssClass="alert alert-danger" />
                        <c:forEach items="${Datos}" var="dato">
                        <table width="100%" border="0">
                          <tbody items="${Datos}" var="dato">
                          <input type="hidden" id="Id" name="Id" value="${dato.id}"/>
                            
                            <tr>
                                
                              <td style="width:50%">
                                <p>
                                
                                   <img src="<c:url value="/resources/Images/${dato.imagen}" />" width="80%" align="rigth"/>
                                   
                        </p>
                              </td>
                              <td style="width:50%">   
                                <p id="Informacion" style="vertical-align:text-top;width:100%">
                                    <c:out value="Nombre: "/>
                            		<c:out value="${dato.nombre}"/>
                                        <input type="hidden" id="Nombre" name="Nombre" value="${dato.nombre}"/>
                            
                        		</p>    
                                <p id="Fecha">
                            		<c:out value="Precio: "/>
                                        <c:out value="${dato.precio}"/>
                                         <input type="hidden" id="Precio" name="Precio"  value="${dato.precio}"/>
                             
                        		</p>                                  
                              	<p id="NombreNovedad">
                                        <c:out value="Informacion: "/>
                            		<c:out  value="${dato.informacion}" />
                        		</p>
                                <p id="NombreNovedad">
                                        <c:out value="Disponibles: "/>
                            		<c:out value="${dato.disponibles}"/>
                                        <input type="hidden" id="Disponibles" name="Disponibles" value="${dato.disponibles}"/>
                        		</p>
                                        
                                        <p > 
                                            <textarea class="form-control" name="Cantidad" id="Cantidad" placeholder="Cantidad a comprar..."></textarea>
                              </td>
                            </tr>
                          </tbody>
                        </table>
                        <hr />
                        </c:forEach>
                        <input type="submit" value="Añadir al carro" class="btn btn-danger"/>
                        <input type="button" value="Atras" class="btn btn-danger" onClick="document.location.href='admBuys.htm'" align="rigth"/>
                        
                    </form:form>
                </div>
            </div>
        </div>
    </body>
</html>
