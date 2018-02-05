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
                <h1>Administración de Compras</h1>
                 <ol class="breadcrumb">
                <li class="active">Home</li>
            </ol>
                <div class="panel panel-primary">
                <div class="panel-heading">Administrar Compras</div>
                <div class="panel-body">
                <p>
                    
                    <a href="viewBuys.htm" class="btn btn-success">Añadir</a>
                </p>
                <table class="table table-bordered table-striped table-hover">
                    <tbody>
                        <c:forEach items="3" var="dato">
                            <tr>
                                <td>
                                    <c:out value="nombre"/>
                                </td>
                                <td>
                                    <c:out value="precio"/>
                                </td>
                                <td>
                                   	<c:out value="cantidad"/>
                                </td>
                                <td>
                                   	<c:out value="jasd"/>
                                </td>
                                <td>
                                	<a href="previewNovedades.htm?id=1" class="glyphicon glyphicon-search"></a>
                                    <a href="editNovedades.htm?id=2" class="glyphicon glyphicon-pencil"></a>
                                    <a href="deleteNovedades.htm?id=2" class="glyphicon glyphicon-trash"></a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                </div>
                </div>
            </div>
        </div>
    </body>
</html>
