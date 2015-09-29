<html>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<head>
<script type="text/javascript"
	src="resources/template/plugins/jQuery/jQuery-2.1.3.min.js"></script>
<script type="text/javascript"
	src="resources/template/plugins/jQueryUI/jquery-ui-1.10.3.js"></script>
<script type="text/javascript"
	src="resources/template/plugins/jQueryUI/jquery-ui-1.10.3.min.js"></script>



<!-- Bootstrap 3.3.2 -->
<link href="resources/template/bootstrap/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="resources/template/bootstrap/js/bootstrap.min.js"></script>


<meta
	content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no'
	name='viewport'>

<!-- Font Awesome Icons -->
<link href="resources/template/font-awesome/css/font-awesome.css"
	rel="stylesheet" type="text/css" />

<!-- Theme style -->
<link href="resources/template/dist/css/AdminLTE.min.css"
	rel="stylesheet" type="text/css" />
<!-- AdminLTE Skins. Choose a skin from the css/skins 
         folder instead of downloading all of them to reduce the load. -->

<link href="resources/template/dist/css/skins/_all-skins.min.css"
	rel="stylesheet" type="text/css" />



<script src="resources/template/stopwatch/dist/timer.jquery.min.js"></script>
<script src="resources/template/stopwatch/libs/qunit/qunit.js"></script>
<script src="resources/template/stopwatch/libs/blanket.min.js"></script>

<script>
        function activateDatePicker() {
            $( "#datepicker" ).datepicker();
        }
    </script>


</head>
<body>
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
					aria-expanded="false">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Separador</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">Menu <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="listaSeparadores">Separador</a></li>
							<li><a href="listaPedidos">Pedido</a></li>
						</ul></li>
				</ul>

				<ul class="nav navbar-nav navbar-right">
					<li><a href="novoPedido">Nova Separação</a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">Dropdown <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="#">Action</a></li>
							<li><a href="#">Another action</a></li>
							<li><a href="#">Something else here</a></li>
							<li role="separator" class="divider"></li>
							<li><a href="logout">Sair</a></li>
						</ul></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>
	<table class="container-fluid" border="1" width="20%">

		<thead>
			<th class="col-md-4">Id</th>
			<th class="col-md-4">Nome</th>
			<th class="col-md-4">Media</th>
		</thead>

		<tbody>
			<c:forEach items="${separadores}" var="separador">
				<tr id="separador_${separador.id}">
					<td>${separador.id}</td>
					<td>${separador.nome}</td>
					<td>${separador.mediaSeparacao}</td>
				</tr>
			</c:forEach>
		</tbody>

	</table>
	
    <input type="text" id="datepicker" onclick="activateDatePicker()">


	<script type="text/javascript">
    function finalizaAgora(id) {    	
      $.post("finalizaPedido", {'id' : id}, function(time) {
        // selecionando o elemento html através da 
        // ID e alterando o HTML dele 
        $("#pedido_"+id).html(time);
      });
    }
  </script>

	<br />

	<br />

	<div class="panel-body">
		<div class="container">
			<table id="tabelaPedidos" border="1" width="100%"
				class="table table-condensed">
				<div class="panel panel-default">
					<div class="panel-heading">
						<script language=javascript type="text/javascript">
dayName = new Array ("domingo", "segunda", "terça", "quarta", "quinta", "sexta", "sábado")
monName = new Array ("janeiro", "fevereiro", "março", "abril", "maio", "junho", "julho","agosto","setembro", "outubro", "novembro", "dezembro")
now = new Date
</script>
						<script language=javascript type="text/javascript">document.write ("<h3> " + dayName[now.getDay() ] + ", " + now.getDate () + " de " + monName [now.getMonth() ]   +  " de "  + now.getFullYear () + ". </h3>")
</script>
					</div>
					<thead>
						<tr>
							<!-- 			<th>Id</th> -->
							<th>Pedido</th>
							<th>Descricao</th>
							<th>Separador</th>
							<th>Vendedor</th>
							<th>Data de Inicio</th>
							<th>Finalizado?</th>
							<th>Data de Finalização</th>
							<th>Tempo Final</th>
							<th>Menu</th>

							<th></th>
						</tr>
					</thead>

					<tbody>
						<c:forEach items="${pedidos}" var="pedido">
							<tr id="pedido_${pedido.id}">
								<!-- 		<td>${pedido.id}</td> -->
								<td>${pedido.numped}</td>
								<td>${pedido.descricao}</td>
								<td>${pedido.separador.nome}</td>
								<td>${pedido.vendedor.nome}</td>
								<td><fmt:formatDate value="${pedido.dataInicio.time}"
										pattern="dd/MM/yyyy HH:mm:ss" /></td>

								<c:if test="${pedido.finalizado eq true}">
									<td>Finalizado</td>
								</c:if>

								<c:if test="${pedido.finalizado eq false}">
									<td id="pedido_status_${pedido.id}"><a href="#"
										onClick="finalizaAgora(${pedido.id})"> Finalizar </a></td>
								</c:if>

								<td><fmt:formatDate value="${pedido.dataFinalizacao.time}"
										pattern="dd/MM/yyyy HH:mm:ss" /></td>


								<script>
					
						</script>

								<td>${pedido.mediaTempo}</td>


								<td><a href="mostraPedido?id=${pedido.id}">Alterar</a></td>
								<td><a href="removePedido?id=${pedido.id}">Remover</a></td>
							</tr>
						</c:forEach>

					</tbody>
				</div>
				</div>
			</table>
			<script type="text/javascript">
    function adicionaAjax() {
        $.ajax({
            url : 'novoPedido.html',
            success : function(data) {
                $('#adiciona').html(data);
            }
        });
    }
</script>

</body>

</html>