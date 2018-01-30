<%-- 
    Document   : edit
    Created on : 15-sept-2017, 17:38:15
    Author     : Camilo
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"   %>
<%@taglib  prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>LPA TEMPLATE</title>
        <link href="<c:url value="/resources/Css/bootstrap-3.3.7-dist/css/bootstrap.min.css"/>" rel="stylesheet"/>
    </head>
    <body>
        <div class="container">
        <h1>Administración de novedades</h1>
            <ol class="breadcrumb">
                <li><a href="admNovedades.htm">Home</a></li>
                <li class="active">Actualizar</li>
            </ol>
            <div class="panel panel-primary">
                <div class="panel-heading">Actualizar</div>
                <div class="panel-body">
                    <form:form method="POST" commandName="Usuario">
                        <form:errors path="*" element="div" cssClass="alert alert-danger" />
                        <table width="100%" border="0">
                          <tbody >
                            <tr>
                              <td>
                               	<p>
                            		<form:label path="Informacion">Nombre novedad:</form:label>
                        		</p>
                                <p>
                            		<form:input path="Nombre" cssClass="form-control" style="width:60%" />
                        		</p>
                                <p>
                            		<form:label path="Imagen">Cargar Imagen:</form:label>
                        		</p>
                                <p>
                                <form:input path="Imagen" cssClass="form-control" style="width:60%" type="file" />
                                </p>
                              </td>
                              <td>                  	
                              	<p>
                            		<form:form method="post" enctype="multipart/form-data"
                                modelAttribute="uploadedFile" action="fileUpload.htm">
                                    <table>
                                    <tr>
                                            <td><input type="file" name="file" />
                                            </td>
                                    </tr>
                                    </table>
                                </form:form>
                        		</p>
                               <p>
                                  <form:textarea path="Informacion" cssClass="form-control"  style="width:80%;resize:none" rows="6" />
                        </p>
                              </td>
                            </tr>
                          </tbody>
                        </table>
                        <hr />
                        <input type="submit" value="Actualizar Novedad" class="btn btn-danger"/>
                         <input type="button" value="Cancelar" class="btn btn-danger" onClick="document.location.href='admNovedades.htm'"/>
                    </form:form>
                </div>
            </div>
        </div>
    </body>
</html>
