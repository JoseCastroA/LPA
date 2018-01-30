<%-- 
    Document   : preview
    Created on : 22-oct-2017, 0:37:07
    Author     : CASA
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"   %>
<%@taglib  prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                <li class="active">Visualización</li>
            </ol>
            <div class="panel panel-primary">
                <div class="panel-heading">Visualización</div>
                <div class="panel-body">
                    <form:form method="POST" commandName="Usuario">
                        <form:errors path="*" element="div" cssClass="alert alert-danger" />
                        <c:forEach items="${Datos}" var="dato">
                        <table width="100%" border="0">
                          <tbody items="${Datos}" var="dato">
                            <tr>
                                
                              <td style="width:50%">
                               	<p id="Informacion" style="vertical-align:text-top;width:100%">
                            		<c:out value="${dato.informacion}"/>
                        		</p>
                                <p id="Fecha">
                            		<c:out value="${dato.fecha}"/>
                        		</p>
                              </td>
                              <td style="width:50%">                  	
                              	<p style="text-align:center; padding-right:18%" id="NombreNovedad">
                            		<c:out value="${dato.nombre}"/>
                        		</p>
                               <p>
                                
                                   <img src="<c:url value="/resources/Images/${dato.imagen}" />" width="80%" align="rigth"/>
                        </p>
                              </td>
                            </tr>
                          </tbody>
                        </table>
                        <hr />
                        </c:forEach>
                        <input type="button" value="Atras" class="btn btn-danger" onClick="document.location.href='admNovedades.htm'" align="rigth"/>
                    
                    </form:form>
                </div>
            </div>
        </div>
    </body>
</html>
