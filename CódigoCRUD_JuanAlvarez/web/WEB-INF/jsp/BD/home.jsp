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
                <h1>LPA TEMPLATE</h1>
                <p>
                    <a href="add.htm" class="btn btn-success">Agregar</a>
                </p>
                <table class="table table-bordered table-striped table-hover">
                    <thead>
                        <tr>
                            <th>Identificador</th>
                            <th>Ocupacion</th>
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
                                    <c:out value="${dato.nombre_ocupacion}"/>
                                </td>
                                <td>
                                    <a href="edit.htm?id=${dato.id}" class="glyphicon glyphicon-pencil"></a>
                                    <a href="delete.htm?id=${dato.id}" class="glyphicon glyphicon-trash"></a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
