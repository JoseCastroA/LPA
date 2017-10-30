<%-- 
    Document   : add
    Created on : 15-sept-2017, 17:39:41
    Author     : Camilo
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>UH!215</title>
        <link href="<c:url value="/resources/Css/bootstrap-3.3.7-dist/css/bootstrap.min.css"/>" rel="stylesheet"/>
    </head>
    <body>
        <div class="container">
            <ol class="breadcrumb">
                <li><a href="TipoProductoHome.htm">Home</a></li>
                <li class="active">Agregar</li>
            </ol>
            <div class="panel panel-primary">
                <div class="panel-heading">Agregar</div>
                <div class="panel-body">
                    <form:form method="POST" commandName="Producto">
                        <form:errors path="*" element="div" cssClass="alert alert-danger" />
                        <p>
                            <form:label path="Nombre">Tipo de producto</form:label>
                            <form:input path="Nombre" cssClass="form-control" />
                        </p>
                        <p>
                            <label class="control-label">Tipo de linea</label>
                                        <form:select path="id_tipo_linea" class="form-control" cssClass="form-control">
                                        <form:option value="0" disabled="true">Seleccione</form:option>
                                        <form:options items="${id_tipo_linea}" />
                                        </form:select>
                        </p>
                        <hr />
                        <input type="submit" value="Enviar" class="btn btn-danger" />
                    </form:form>
                </div>
            </div>
        </div>
    </body>
</html>
