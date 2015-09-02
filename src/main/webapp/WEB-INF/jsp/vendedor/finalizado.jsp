<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<td>${vendedor.id}</td>
<td>${vendedor.descricao}</td>
<td>Finalizada</td>
<td><fmt:formatDate value="${vendedor.dataFinalizacao.time}"
    pattern="dd/MM/yyyy" /></td>
<td><a href="mostraTarefa?id=${vendedor.id}">Alterar</a></td>
<td><a href="removeTarefa?id=${vendedor.id}">Remover</a></td>
