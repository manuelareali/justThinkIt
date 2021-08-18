<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="beanweb.CreaTurnoBoundary"%>
<%
Class.forName("com.mysql.jdbc.Driver");
if (request.getParameter("creaTurno") != null) {
	if (CreaTurnoBoundary.getInstance().creaTurnoPressed(request.getParameter("nome_giorno"),
	request.getParameter("oraInizio"), request.getParameter("oraFine"), request.getParameter("numMaxParte"),
	request.getParameter("note")) == true) {
%>
<jsp:forward page="gestisciTurniCaritas.jsp" />
<%
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

<title>CREA TURNO</title>
<link rel="stylesheet" href="../css/creaTurni.css">
<link rel="icon" sizes="64x64" href="../img/favicon.png">
</head>
<body>
	<div class="container">
		<div class="container text-center">
			<h1>Crea Turno Lavorativo</h1>
		</div>
		<form action="creaTurno.jsp" name="my" method="POST">

			<div style="padding: 3%">
				<div class="container text-center my-5">
					<div class="row">
						<div class="col">
							<label style = "font-size: 20px" for="validationCustom01" class="form-label">Che
								Giorno?</label> <select style = "border: solid 2px;" class="form-select" id="nome_giorno"
								name="nome_giorno">
								<option value="Lunedì">Luned&igrave;</option>
								<option value="Martedì">Marted&igrave;</option>
								<option value="Mercoledì">Mercoled&igrave;</option>
								<option value="Giovedì">Gioved&igrave;</option>
								<option value="Venerdì"">Venerd&igrave;</option>
								<option value="Sabato">Sabato</option>
								<option value="Domenica">Domenica</option>
							</select>
						</div>
						<div class="col">
							<label  style = "font-size: 20px" for="validationCustom02" class="form-label">Numero
								Max Partecipanti</label> <input   style = "border: solid 2px;" class="form-control" type="text"
								id="numMaxParte" name="numMaxParte" placeholder="es 340" />

						</div>
						<div class="col">
							<label  style = "font-size: 20px" for="validationCustom03" class="form-label">Ora
								Inizio Turno</label> <input  style = "border: solid 2px;" class="form-control" type="text"
								id="oraInizio" name="oraInizio" placeholder="es 12:00" />

						</div>
						<div class="col">
							<label  style = "font-size: 20px" for="validationCustom04" class="form-label">Ora
								Fine Turno</label> <input  style = "border: solid 2px;" class="form-control" type="text" id="oraFine"
								name="oraFine" placeholder="es 12:00" />

						</div>
					</div>
					<div class="container text-center my-5">
						<label  style = "font-size: 20px" for="validationCustom05" class="form-label">Note</label>
						<textarea  style = "border: solid 2px; height: 150px;" class="form-control" id="note" name="note"
							placeholder="Bisogna essere puntuali!"></textarea>
					</div>
				</div>



			</div>

			

			<div class="completa">
				<button type="submit" class="btn btn-light" name="creaTurno"
					value="creaTurno">Crea Turno</button>
			</div>

			<!-- Optional JavaScript; choose one of the two! -->

			<!-- Option 1: Bootstrap Bundle with Popper -->
			<script
				src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
				integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
				crossorigin="anonymous"></script>

		

		</form>
		
		<div class="indietro">
				<a href="gestisciTurniCaritas.jsp"><button class="btn btn-warning" type="submit"
						name="indietro" value="indietro">Indietro</button></a>
			</div>
	</div>
</body>
</html>