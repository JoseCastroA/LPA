<%-- 
    Document   : home
    Created on : 15-sept-2017, 17:37:50
    Author     : Camilo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>LPA TEMPLATE</title>
       <link href="<c:url value="/resources/Css/bootstrap-3.3.7-dist/css/bootstrap.min.css"/>" rel="stylesheet"/>
        <script src="<c:url value="/resources/Js/jquery-3.1.1.min.js"/>"></script>
        <script src="<c:url value="/resources/Css/bootstrap-3.3.7-dist/js/bootstrap.min.js"/>"></script>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <h1>Listado de productos</h1>
                 <ol class="breadcrumb">
                <li><a href="admBuys.htm">Administrar Carrito</a></li>
                <li class="active">Listado de productos</li>
            </ol>
                <div class="panel panel-primary">
                <div class="panel-heading">Listado de productos</div>
                <div class="panel-body">
                <p>
                    
                    
                </p>
                 <c:forEach items="${Datos}" var="dato">
                <table class="table table-bordered table-striped table-hover">
                    <tbody>
                       
                            <tr>
                                <td style="width: 10px">
                                     <img src="resources/Images/${dato.imagen}" width="170px" />
                                </td>
                                <td>
                                    <li><c:out value="Nombre: "/><c:out value="${dato.nombre}"/></li>
                                    <li><c:out value="Descripcion: "/><c:out value="${dato.informacion}"/></li>
                                </td>
                                <td>
                                    <ul><c:out value="Precio: "/><c:out value="${dato.precio}"/></ul>
                            
                                <a href="addBuy.htm?id=${dato.id}"><img src="resources/Images/agregar.png" width="122px"  style="position: absolute;right: 13%;" />
                                </td>
                            </tr>
                       
                    </tbody>
                </table>
                </c:forEach>
                <input type="button" value="Atras" class="btn btn-danger" onClick="document.location.href='admBuys.htm'" style="right: -95%;position:  relative;"/>
                </div>
                </div>
            </div>
        </div>
    </body>
</html>
