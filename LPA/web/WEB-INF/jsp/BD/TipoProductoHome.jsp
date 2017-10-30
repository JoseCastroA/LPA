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
        <title>UH!215</title>
        <link href="<c:url value="/resources/Css/bootstrap-3.3.7-dist/css/bootstrap.min.css"/>" rel="stylesheet"/>
        <script src="<c:url value="/resources/Js/jquery-3.1.1.min.js"/>"></script>
        <script src="<c:url value="/resources/Css/bootstrap-3.3.7-dist/js/bootstrap.min.js"/>"></script>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <h1>UH!215</h1>
                <p>
                    <a href="TipoLineaHome.htm" class="btn btn-success">Lineas</a>
                </p>
                <p>
                    <a href="TipoProductoAdd.htm" class="btn btn-success">Agregar tipo producto</a>
                </p>
                <table class="table table-bordered table-striped table-hover">
                    <thead>
                        <tr>
                            <th>Identificador</th>
                            <th>Producto</th>
                            <th>Linea</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${Datos}" var="dato">
                            <tr>
                                <td>
                                    <c:out value="${dato.id}"/>
                                </td>
                                <td>
                                    <c:out value="${dato.tipo_producto}"/>
                                </td>
                                <td>
                                    <c:out value="${dato.tipo_linea}"/>
                                </td>
                                <td>
                                    <a href="TipoProductoEdit.htm?id=${dato.id}" class="glyphicon glyphicon-pencil"></a>
                                    <a href="TipoProductoDelete.htm?id=${dato.id}" class="glyphicon glyphicon-trash"></a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
