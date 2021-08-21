<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="beanweb.DonationBoundary"%>
<%@ page import="beanweb.CercaCaritas"%>
<%
Class.forName("com.mysql.jdbc.Driver");
%>


<%
if (request.getParameter("OK") != null) {
	if ("Vestiti".equals(request.getParameter("tipo"))) {
		if ((DonationBoundary.getInstance().creaDonazione(1, request.getParameter("IndirizzoVolontario"),
		request.getParameter("descrizione")) == true)) {
%>
<jsp:forward page="mappa.jsp" />
<%
}
}

if ("Cibo".equals(request.getParameter("tipo"))) {
if ((DonationBoundary.getInstance().creaDonazione(2, request.getParameter("IndirizzoVolontario"),
		request.getParameter("descrizione")) == true)) {
%>
<jsp:forward page="mappa.jsp" />
<%
}
}
}
%>
<%
if (request.getParameter("indietro") != null){
%>
<jsp:forward page="mappa.jsp" />
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

<title>DONAZIONE</title>
<link rel="stylesheet" href="../css/creaDonazioneMappa.css">
<link rel="icon" sizes="64x64" href="../img/favicon.png">
</head>
<body>
	<div class="container">
		<div class="container text-center">
			<h1>La tua donazione è veramente importante</br> per noi e fa la
				differenza!!!</h1>
		</div>
		<form action="creaDonazioneMap.jsp" name="my" method="POST">
			<div style="padding: 3% 0% 0% 0%;" class="container text-center my-5">
				<div class="row">
					<div class="col">
						<label style = "font-size:22px" for="validationCustom01" class="form-label">Indirizzo</label>
						<input style = "border: solid 2px" type="text" class="form-control" id="IndirizzoVolontario"
							name="IndirizzoVolontario" placeholder="via Luigi Settembrini">
					</div>

					<div class="col">
						<label style = "font-size:22px" for="validationCustom02" class="form-label">Inserisci
							breve desrizione del/dei prodotti:</label> <input style = "border: solid 2px" type="text"
							class="form-control" id="descrizione" name="descrizione"
							placeholder="Ho donato 3kg di pasta" />
					</div>
				</div>
			</div>
			<div class="container text-center">
				<div class="row justify" >
					<div class="col" >
						<div>
							<label style = "font-size:22px" for="validationCustom02" class="form-label">Cosa
								vuoi donare?</label> </br>
							<input style = "border: solid 2px" class="form-check-input" type="checkbox" name="tipo"
								value="Vestiti"> <label style = "font-size:22px" class="form-check-label"
								for="invalidCheck"> Vestiti </label>
						</div>
						<div>
							<input style = "border: solid 2px" class="form-check-input" type="checkbox" name="tipo"
								value="Cibo"> <label style = "font-size:22px" class="form-check-label"
								for="invalidCheck">&nbsp;&nbsp;Cibo</label>
						</div>
						</div>
					</div>
		<div id="popup8" class="overlay">
			<div class="popup">

				<div class="content">
					<h3 class="fw-bold">Sei sicuro di voler confermare?</h3>
					<p>Se confermi non potrai più modificare la donazione.</p>
					<div class="content text-center">
						<button class="btn btn-outline-light"
								type="submit" name="OK" value="OK">OK</button>
							<button class="btn btn-outline-light"
								type="submit" name="" value="">ANNULLA</button>
					</div>
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

			<!-- Option 2: Separate Popper and Bootstrap JS -->
		

		</form>
		
		</div>
			<div class="container my-4 text-center">
			<div class="row">
				<div class="col">
					<a href="mappa.jsp"><button
							class="btn btn-warning" type="submit" name="INDIETRO"
							value="INDIETRO">Indietro</button></a>
				</div>
				<div class="col"></div>
				<div class="col"></div>
				<div class="col">
					<a class="button" href="#popup8"><button type="submit"
							class="btn btn-light" name="INVIA" value="INVIA">INVIA</button></a>
				</div>
			</div>
	</div>
</body>
</html>