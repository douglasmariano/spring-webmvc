<html>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<head>

<script type="text/javascript" src="resources/template/plugins/jQueryUI/jquery-ui-1.10.3.min.js"></script>
<script type="text/javascript" src="resources/template/plugins/jQuery/jQuery-2.1.3.min.js"></script>

<!-- Bootstrap 3.3.2 -->
<link href="resources/template/bootstrap/css/bootstrap.min.css"	rel="stylesheet" type="text/css" />

<meta
	content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no'name='viewport'>
<!-- Bootstrap 3.3.2 -->
<link href="resources/template/bootstrap/css/bootstrap.min.css"rel="stylesheet" type="text/css" />
<!-- Font Awesome Icons -->
<link href="resources/template/font-awesome/css/font-awesome.css"rel="stylesheet" type="text/css" />

<!-- Theme style -->
<link href="resources/template/dist/css/AdminLTE.min.css"rel="stylesheet" type="text/css" />
<!-- AdminLTE Skins. Choose a skin from the css/skins 
         folder instead of downloading all of them to reduce the load. -->
         
<link href="resources/template/dist/css/skins/_all-skins.min.css"rel="stylesheet" type="text/css" />

<script type="text/javascript"	src="resources/template/bootstrap/js/bootstrap.min.js"></script>

<script src="resources/template/stopwatch/dist/timer.jquery.min.js"></script> 
<script src="resources/template/stopwatch/libs/qunit/qunit.js"></script>
<script src="resources/template/stopwatch/libs/blanket.min.js"></script>



</head>
<body>
		<nav class="navbar navbar-default">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">Separador</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Menu <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="listaSeparadores">Separador</a></li>
            <li><a href="listaPedidos">Pedido</a></li>
          </ul>
        </li>
      </ul>
      
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#">Link</a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">Action</a></li>
            <li><a href="#">Another action</a></li>
            <li><a href="#">Something else here</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">Separated link</a></li>
          </ul>
        </li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>



	<a href="novoSeparador">Criar novo separador</a>

	<br />
	<br />

	<table>
		
			<th>Id</th>
			<th>Nome</th>
			
	<c:forEach items="${separadores}" var="separador">
<tr id="separador_${separador.id}">
  <td>${separador.id}</td>
  <td>${separador.nome}</td>
  
  
				<td><a href="mostraSeparador?id=${separador.id}">Alterar</a></td>
				<td><a href="removeSeparador?id=${separador.id}">Remover</a></td>
			</tr>
		</c:forEach>
	</table>
	<a href="adicionaSeparador">Nova Separador</a>
</body>
</html>