
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Agregar tipo usuario</title>
        <link href="<c:url value="/resources/Css/bootstrap-3.3.7-dist/css/bootstrap.min.css"/>" rel="stylesheet"/>
    </head>
    <body>
        <div class="container">
            <ol class="breadcrumb">
                <li><a href="home.htm">Home</a></li>
                <li class="active">Agregar</li>
            </ol>
            <div class="panel panel-primary">
                <div class="panel-heading">Agregar</div>
                <div class="panel-body">
                    <form:form method="POST" commandName="tipoUsuario">
                        <form:errors path="*" element="div" cssClass="alert alert-danger" />
                        <p>
                            <form:label path="Nombre">Nombre tipo de usuario</form:label>
                            <form:input path="Nombre" cssClass="form-control" />
                            <form:label path="Descripcion">Descripcion tipo de usuario</form:label>
                            <form:input path="Descripcion" cssClass="form-control" />
                        </p>
                        <hr />
                        <input type="submit" value="Enviar" class="btn btn-danger" />
                    </form:form>
                </div>
            </div>
        </div>
    </body>
</html>

