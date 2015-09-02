<html>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<head>
<script type="text/javascript" src="resources/template/plugins/jQuery/jQuery-2.1.3.min.js"></script>
<script type="text/javascript" src="resources/template/plugins/jQueryUI/jquery-ui-1.10.3.js"></script>
<script type="text/javascript" src="resources/template/plugins/jQueryUI/jquery-ui-1.10.3.min.js"></script>



<!-- Bootstrap 3.3.2 -->
<link href="resources/template/bootstrap/css/bootstrap.min.css"	rel="stylesheet" type="text/css" />
<script type="text/javascript"	src="resources/template/bootstrap/js/bootstrap.min.js"></script>


<meta
	content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no'name='viewport'>

<!-- Font Awesome Icons -->
<link href="resources/template/font-awesome/css/font-awesome.css"rel="stylesheet" type="text/css" />

<!-- Theme style -->
<link href="resources/template/dist/css/AdminLTE.min.css"rel="stylesheet" type="text/css" />
<!-- AdminLTE Skins. Choose a skin from the css/skins 
         folder instead of downloading all of them to reduce the load. -->
         
<link href="resources/template/dist/css/skins/_all-skins.min.css"rel="stylesheet" type="text/css" />



<script src="resources/template/stopwatch/dist/timer.jquery.min.js"></script> 
<script src="resources/template/stopwatch/libs/qunit/qunit.js"></script>
<script src="resources/template/stopwatch/libs/blanket.min.js"></script>

</head>
<body>

	<div class="container">
		<form class="form-horizontal" action="efetuaLogin" method="post">
			<div class="form-group">
				<label for="usuario" class="col-sm-2 control-label">Login</label>
				<div class="col-sm-10">
					<!-- <input type="usuario" class="form-control" id="usuario"
						placeholder="Usuario">-->
						<input type="text" name="usuario"><br />
				</div>
			</div>
			<div class="form-group">
				<label for="password" class="col-sm-2 control-label">Senha</label>
				<div class="col-sm-10">
					<!-- <input type="password" class="form-control" id="senha"
						placeholder="Senha">-->
						<input type="password" name="senha"><br />
				</div>
			</div>
			<!-- <div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<div class="checkbox">
					<label> <input type="checkbox"> Remember me
					</label>
				</div>
			</div>
		</div> -->
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">Login</button>
				</div>
			</div>
		</form>
	</div>
</body>
</html>