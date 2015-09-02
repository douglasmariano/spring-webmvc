<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<td>${separador.id}</td>
<td>${separador.descricao}</td>
<td>Finalizada</td>
<td><fmt:formatDate value="${separador.dataFinalizacao.time}"
    pattern="dd/MM/yyyy" /></td>
<td><a href="mostraTarefa?id=${separador.id}">Alterar</a></td>
<td><a href="removeTarefa?id=${separador.id}">Remover</a></td>
