<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

"
<!-- <td>${pedido.id}</td> -->
<td>${pedido.numped}</td>
<td>${pedido.descricao}</td>
<td>${pedido.separador.nome}</td>
<td>${pedido.vendedor.nome}</td>
<td><fmt:formatDate value="${pedido.dataInicio.time}" pattern="dd/MM/yyyy HH:mm:ss" /></td>
<td>Finalizada</td>
<td><fmt:formatDate value="${pedido.dataFinalizacao.time}" pattern="dd/MM/yyyy HH:mm:ss" /></td>
<td>${pedido.mediaTempo}</td> 

<td><a href="mostraPedido?id=${pedido.id}">Alterar</a></td>
<td><a href="removePedido?id=${pedido.id}">Remover</a></td>
