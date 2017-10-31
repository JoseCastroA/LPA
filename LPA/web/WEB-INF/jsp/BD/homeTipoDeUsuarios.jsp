
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Administrar tipo usuarios</title>
        <link href="<c:url value="/resources/Css/bootstrap-3.3.7-dist/css/bootstrap.min.css"/>" rel="stylesheet"/>
        <script src="<c:url value="/resources/Js/jquery-3.1.1.min.js"/>"></script>
        <script src="<c:url value="/resources/Css/bootstrap-3.3.7-dist/js/bootstrap.min.js"/>"></script>
    </head>
    <body>
         <div class="container">
            <div class="row">
                <p>
                    <a href="addTipoDeUsuarios.htm" class="btn btn-success">Agregar</a>
                </p>
               
                
                <table class="table table-bordered table-striped table-hover">
                    <thead>
                        <tr>
                            <th>Nombre tipo de eusuario</th>
                            <th>Descipcion tipo de usuario</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${Datos}" var="dato">
                            <tr>
                                <td>
                                    <c:out value="${dato.nombre_tipo_usuario}"/>
                                </td>
                                <td>
                                    <c:out value="${dato.descripcion_tipo_usuario}"/>
                                </td>
                                <td>
                                    <a href="editTipoDeUsuarios.htm?id=${dato.id}" class="glyphicon glyphicon-pencil"></a>
                                    <a href="deleteTipoDeUsuarios.htm?id=${dato.id}" class="glyphicon glyphicon-trash"></a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
