<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="beanweb.PrenotaTurnoBoundary"%>

<%
Class.forName("com.mysql.jdbc.Driver");
if (request.getParameter("OK") != null) {
	if (PrenotaTurnoBoundary.getInstance().prenotaTurno(request.getParameter("nome_giorno"),
	request.getParameter("ora_inizio"), request.getParameter("ora_fine"),
	request.getParameter("Curriculum")) == true) {
%>
<jsp:forward page="mappa.jsp" />
<%
}
	else{
		%>
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

<title>PRENOTA TURNO</title>
<link rel="stylesheet" href="../css/prenotaTurnoMap.css">
<link rel="icon" sizes="64x64" href="../img/favicon.png">
</head>
<body>
	<div class="container">
		<div class="container text-center">
			<h1>Grazie al tuo sostegno moltissime persone te ne saranno
				grate e potranno essere aiutate!</h1>
			<h6>*dopo aver inviato la richiesta verrà inoltrata una notifica
				se accettata</h6>
		</div>
		<form action="prenotaTurnoMap.jsp" name="my" method="POST">

			<div style="padding: 2%">
				<div class="container text-center my-5">
					<div class="row">
						<div class="col">
							<label style="font-size: 22px;" for="validationCustom01"
								class="form-label">Giorni di Prenotazione</label> <select
								style="border: solid 2px" class="form-select" id="nome_giorno"
								name="nome_giorno">
								<option value="Lunedi">Lunedi</option>
								<option value="Martedi">Martedi</option>
								<option value="Mercoledi">Mercoledi</option>
								<option value="Giovedi">Giovedi</option>
								<option value="Venerdi">Venerdi</option>
								<option value="Sabato">Sabato</option>
								<option value="Domenica">Domenica</option>
							</select>
						</div>
						<div class="col">
							<label style="font-size: 22px;" for="validationCustom02"
								class="form-label">Orari Disponibili</label> <select
								style="border: solid 2px" class="form-select" id="ora_inizio"
								name="ora_inizio">
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
							<label style="font-size: 22px;" for="validationCustom02"
								class="form-label">Orari Disponibili</label> <select
								style="border: solid 2px" class="form-select" id="ora_fine"
								name="ora_fine">
								
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
								<option value="7:00">22:00</option>
							</select>

						</div>
					</div>
				</div>


				<div class="container text-center my-5">
					<label style="font-size: 22px;" for="validationCustom03"
						class="form-label">Inserisci link al cv</label> <input
						style="border: solid 2px" class="form-control" type="text"
						id="Curriculum" name="Curriculum" placeholder="es.www.github.it" />
				</div>
			</div>

			<div id="popup13" class="overlay">
			<div class="popup">

				<div class="content">
					<h3 class="fw-bold">Sei sicuro di voler confermare?</h3>
					<p>Se confermi non potrai cambiare gli orari di prenotazione.</p>
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
		
			
		<div class="container my-4">
			<div class="row">
				<div class="col">
					<a href="mappa.jsp"><button
							class="btn btn-warning" type="submit" name="INDIETRO"
							value="INDIETRO">Indietro</button></a>
				</div>
				<div class="col"></div>
				<div class="col"></div>
				<div class="col">
					<a class="button" href="#popup13"><button type="submit"
							class="btn btn-light" name="INVIA" value="INVIA">INVIA</button></a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>