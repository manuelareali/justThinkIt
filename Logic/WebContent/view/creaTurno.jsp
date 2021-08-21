<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="beanweb.CreaTurnoBoundary"%>
<%
Class.forName("com.mysql.jdbc.Driver");
if (request.getParameter("OK") != null) {
	if(request.getParameter("oraInizio") != request.getParameter("oraFine") ){
		if (CreaTurnoBoundary.getInstance().creaTurnoPressed(request.getParameter("nome_giorno"),
				request.getParameter("oraInizio"), request.getParameter("oraFine"), request.getParameter("numMaxParte"),
				request.getParameter("note")) == true) {
%>
<jsp:forward page="gestisciTurniCaritas.jsp" />
<%
	}
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
<link rel="stylesheet" href="../css/creaTurno.css">
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
								Inizio Turno</label> 
								<select style = "border: solid 2px;" class="form-select" id="oraInizio"						
								name="oraInizio">
								<option value="7:00">7:00</option>
								<option value="7:30">7:30</option>
								<option value="8:00">8:00</option>
								<option value="8:30">8:30</option>
								<option value="9:00">9:00</option>
								<option value="9:30">9:30</option>
								<option value="10:00">10:00</option>
								<option value="10:30">10:30</option>
								<option value="11:00">11:00</option>
								<option value="11:30">11:30</option>
								<option value="12:00">12:00</option>
								<option value="12:30">12:30</option>
								<option value="13:00">13:00</option>
								<option value="13:30">13:30</option>
								<option value="14:00">14:00</option>
								<option value="14:30">14:30</option>
								<option value="15:00">15:00</option>
								<option value="15:30">15:30</option>
								<option value="16:00">16:00</option>
								<option value="16:30">16:30</option>
								<option value="17:00">17:00</option>
								<option value="17:30">17:30</option>
								<option value="18:00">18:00</option>
								<option value="18:30">18:30</option>
								<option value="19:00">19:00</option>
								<option value="19:30">19:30</option>
								<option value="20:00">20:00</option>
								<option value="20:30">20:30</option>
								<option value="21:00">21:00</option>
								<option value="21:30">21:30</option>
							</select>

						</div>
						<div class="col">
							<label  style = "font-size: 20px" for="validationCustom04" class="form-label">Ora
								Fine Turno</label><select style = "border: solid 2px;" class="form-select" id="oraFine"						
								name="oraFine">
								<option value="7:30">7:30</option>
								<option value="8:00">8:00</option>
								<option value="8:30">8:30</option>
								<option value="9:00">9:00</option>
								<option value="9:30">9:30</option>
								<option value="10:00">10:00</option>
								<option value="10:30">10:30</option>
								<option value="11:00">11:00</option>
								<option value="11:30">11:30</option>
								<option value="12:00">12:00</option>
								<option value="12:30">12:30</option>
								<option value="13:00">13:00</option>
								<option value="13:30">13:30</option>
								<option value="14:00">14:00</option>
								<option value="14:30">14:30</option>
								<option value="15:00">15:00</option>
								<option value="15:30">15:30</option>
								<option value="16:00">16:00</option>
								<option value="16:30">16:30</option>
								<option value="17:00">17:00</option>
								<option value="17:30">17:30</option>
								<option value="18:00">18:00</option>
								<option value="18:30">18:30</option>
								<option value="19:00">19:00</option>
								<option value="19:30">19:30</option>
								<option value="20:00">20:00</option>
								<option value="20:30">20:30</option>
								<option value="21:00">21:00</option>
								<option value="21:30">21:30</option>
								<option value="22:00">22:00</option>
							</select>

						</div>
					</div>
					<div class="container text-center my-5">
						<label  style = "font-size: 20px" for="validationCustom05" class="form-label">Note</label>
						<textarea  style = "border: solid 2px; height: 150px;" class="form-control" id="note" name="note"
							placeholder="Bisogna essere puntuali!"></textarea>
					</div>
				</div>



			</div>

			<div id="popup5" class="overlay">
			<div class="popup">

				<div class="content">
					<h3 class="fw-bold">Sei sicuro di voler confermare?</h3>
					<p>I dati inseriti non potranno essere modificati.</p>
					<div class="content text-center">
						<button class="btn btn-outline-light"
								type="submit" name="OK" value="OK">OK</button>
							<button class="btn btn-outline-light"
								type="submit" name="" value="">ANNULLA</button>
					</div>
				</div>

			</div>
		</div>
			

		

			<!-- Optional JavaScript; choose one of the two! -->

			<!-- Option 1: Bootstrap Bundle with Popper -->
			<script
				src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
				integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
				crossorigin="anonymous"></script>

		

		</form>
		
		<div class = "container my-4">
			<div class = "row">
			<div class = "col">
			<a class="button" href="gestisciTurniCaritas.jsp"><button class="btn btn-warning" type="submit" name="indietro"
					value="indietro">Indietro</button></a>
			</div>
			<div class = "col"></div>
			<div class = "col"></div>
			<div class = "col">
			<a class="button" href="#popup5"><button class="btn btn-light" type="submit"   name ="CONFERMA" value = "CONFERMA">Conferma</button></a>
			</div>
			</div>
			</div>
		
	</div>
</body>
</html>