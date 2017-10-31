<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"   %>
<%@taglib  prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Modificar tipo usuario</title>
        <link href="<c:url value="/resources/Css/bootstrap-3.3.7-dist/css/bootstrap.min.css"/>" rel="stylesheet"/>
    </head>
    <body>
        <div class="container">
            <ol class="breadcrumb">
                <li><a href="<c:url value="/home.htm" />">Home</a></li> 
                <li class="active">Editar</li>
            </ol>
            
                <div class="panel-heading">Editar</div>
                
                      <form:form method="POST" commandName="Usuario">
                        <form:errors path="*" element="div" cssClass="alert alert-danger" />
                        <table width="100%" border="0">
                          <tbody >
                            <tr>
                              <td>
                               	<p>
                            		<form:label path="Nombre" >Nombre novedad:</form:label>
                        		</p>
                                <p>
                            		<form:input path="Nombre" cssClass="form-control" style="width:60%" />
                        		</p>                 
                              </td>
                            </tr>
                          </tbody>
                        </table>
                        <hr />
                        <input type="submit" value="Actualizar Novedad" class="btn btn-danger"/>
                         <input type="button" value="Cancelar" class="btn btn-danger" onClick="document.location.href='homeTipoDeUsuarios.htm'"/>
                    </form:form>
                
            
        </div>
    </body>
</html>

