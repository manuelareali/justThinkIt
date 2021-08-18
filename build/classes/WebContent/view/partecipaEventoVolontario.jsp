<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="beanweb.PartecipaEventoBoundary"%>

<%Class.forName("com.mysql.jdbc.Driver"); %>
<%
	if (request.getParameter("PARTECIPA")!= null){
		if (PartecipaEventoBoundary.getInstance().partecipaEvento(request.getParameter("Importo"),request.getParameter("carta")) == true){
			
		}
%>
	<jsp:forward page="mappa.jsp"/>
<%
	}
%> 
    


<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">

<title>PARTECIPA EVENTO VOLONTARIO</title>
<link rel="stylesheet" href="../css/partecipaEvento.css">
<link rel="icon" sizes="64x64" href="../img/favicon.png">
</head>
<body>
	<div class="container">
		<div class="container text-center my-4">
			<h1>Gli eventi sono accessibili a chiunque, ma sarebbe gradito un piccolo contributo</h1>
			<h6>*facoltativo, si pu&ograve; partecipare ugualmente all'evento</h6>
		</div>
		<form action="partecipaEventoVolontario.jsp" name="my" method="POST">

			
			<div class="container text-center my-5" style = "padding: 7%">
				<div class="row">
					<div class="col">
						<label style = "font-size:22px;" for="validationCustom01" class="form-label">*Quanto vuoi donare?</label> <input style = "border: solid 2px;" type="text" class="form-control" id = "Importo"  name="Importo" placeholder="10.00&euro;"/>
					</div>
					<div class="col">
						<label style = "font-size:22px;"  for="validationCustom02" class="form-label">*Carta di Credito</label> <input  style = "border: solid 2px;" type="text" class="form-control" id = "cartaDicredito"  name="Email" placeholder="67966869869790"/>
					</div>

				</div>
				</div>
				
				<div class="completa">
				<button type="submit" class="btn btn-light" name= "PARTECIPA" value="PARTECIPA">Partecipa</button>
			</div>

			<!-- Optional JavaScript; choose one of the two! -->

			<!-- Option 1: Bootstrap Bundle with Popper -->
			<script
				src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
				integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
				crossorigin="anonymous"></script>


		</form>
		<div class="indietro">
				<a href= "mappa.jsp"><button class="btn btn-warning" type="submit" name="INDIETRO"
					value="INDIETRO">Indietro</button></a>
				</div>
				
	</div>
</body>
</html>