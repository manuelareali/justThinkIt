<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="beanweb.PromuoviEventoGenerale"%>

<%
Class.forName("com.mysql.jdbc.Driver");
%>
<%
if (request.getParameter("CONFERMA") != null) {
	if(request.getParameter("Tipologia").equals("Tutto")){
		if(PromuoviEventoGenerale.getInstance().confermaEventoPressed(request.getParameter("NomeEvento"), "Tutto", Float.parseFloat("0"), request.getParameter("NoteEvento")) == true){ 
			
%>
<jsp:forward page="gestisciEventiCaritas.jsp" />
<%			
	}
	}
		else if (request.getParameter("Tipologia").equals("Vestiti")) {
	 		if(PromuoviEventoGenerale.getInstance().confermaEventoPressed(request.getParameter("NomeEvento"), "Vestiti", Float.parseFloat("0"), request.getParameter("NoteEvento")) == true){
%>
<jsp:forward page="gestisciEventiCaritas.jsp" />
<%
}
		}

else if (request.getParameter("Tipologia").equals("Cibo")) {
	if(PromuoviEventoGenerale.getInstance().confermaEventoPressed(request.getParameter("NomeEvento"), "Cibo", Float.parseFloat("0"), request.getParameter("NoteEvento"))==true){
	%>
<jsp:forward page="gestisciEventiCaritas.jsp" />
<%
}}
 else {
 }
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

<title>PROMUOVI EVENTO</title>
<link rel="stylesheet" href="../css/proponiEvento.css">
<link rel="icon" sizes="64x64" href="../img/favicon.png">
</head>
<body>
	<div class="container">
		<div class="container text-center">
			<h1>Proponi un evento al Negozio!</h1>
		</div>
		<form action="creaEventoGenerale.jsp" name="my" method="POST">
			<div style= "padding: 3%">
			<div  class="container text-center my-5">
				<div class="row justify-content-center">
					<div class="col">
						<label style = "font-size: 22px;" for="validationCustom01" class="form-label">Nome
							Evento</label> <input style = "border: solid 2px;" type="text" class="form-control" id="NomeEvento"
							name="NomeEvento" placeholder="DoniAmo" />
					</div>

					
				</div>
			</div>
			<div class="container">
				<div class="row justify-content-center">
					<div class="col">
						<div>
							<input style = "border: solid 2px;" class="form-check-input" type="checkbox" name="Tipologia"
								value="Vestiti"> <label style = "font-size: 22px;" class="form-check-label"
								for="invalidCheck"> Vestiti </label>
						</div>
						<div>
							<input style = "border: solid 2px;" class="form-check-input" type="checkbox" name="Tipologia"
								value="Cibo"> <label style = "font-size: 22px;" class="form-check-label"
								for="invalidCheck">Cibo</label>
						</div>
						<div>
							<input style = "border: solid 2px;" class="form-check-input" type="checkbox" name="Tipologia"
								value="Tutto"> <label style = "font-size: 22px;" class="form-check-label"
								for="invalidCheck">Tutto</label>
						</div>
					</div>
					<div class="col">
						<label style = "font-size: 22px;" for="validationCustom02" class="form-label">Note
							Evento</label>
						<textarea style = "border: solid 2px; height: 150px;" class="form-control" id="NoteEvento" name="NoteEvento"></textarea>
					</div>
				</div>
			</div>
			</div>
			<div class = "conferma">
			<button class="btn btn-light" type="submit"   name ="CONFERMA" value = "CONFERMA">Conferma</button>
			</div>
			
			
			<!-- Optional JavaScript; choose one of the two! -->

			<!-- Option 1: Bootstrap Bundle with Popper -->
			<script
				src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
				integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
				crossorigin="anonymous"></script>


		</form>
		<div class = "indietro">
			<a href= "gestisciEventiCaritas.jsp"><button class="btn btn-warning" type="submit" name="indietro"
					value="indietro">Indietro</button></a>
					</div>
	</div>
</body>
</html>