<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="beanweb.ProponiOffertaCaritas"%>

<%
Class.forName("com.mysql.jdbc.Driver");
%>
<%
if (request.getParameter("OK") != null) {
		if (ProponiOffertaCaritas.getInstance().conferma(Float.parseFloat(request.getParameter("PrezzoEvento")), request.getParameter("NoteEvento"), request.getParameter("DataEvento")) == true){
%>
	<jsp:forward page="eventiPropostiNegozi.jsp" />
<%
}
		else{
%>
	<jsp:forward page="offerteNegozi.jsp" />
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

<title>PROMUOVI EVENTO</title>
<link rel="stylesheet" href="../css/proponiEventi.css">
<link rel="icon" sizes="64x64" href="../img/favicon.png">
</head>
<body>
	<div class="container">
		<div class="container text-center">
			<h1>Proponi un' offerta alla Caritas!</h1>
		</div>
		<form action="offerteNegozi.jsp" name="my" method="POST">
			<div style="padding: 3%">
				<div class="container text-center my-5">
					<div class="row justify-content-center">
						<div class="col">
							<label style="font-size: 22px;" for="validationCustom02"
								class="form-label">Prezzo Evento</label> <input
								style="border: solid 2px;" type="text" class="form-control"
								id="PrezzoEvento" name="PrezzoEvento" placeholder="500&euro;" />
						</div>
						<div class="col">
							<label style="font-size: 22px;" for="validationCustom01"
								class="form-label">Data Evento </label> <input
								style="border: solid 2px;" type="text" class="form-control"
								id="DatEvento" name="DataEvento" placeholder="12/05/2021" />
						</div>
					</div>
				</div>
				<div class="container">
					<div class="row justify-content-center">
						<div class="col">
							<label style="font-size: 22px;" for="validationCustom02"
								class="form-label">Note Evento</label>
							<textarea style="border: solid 2px; height: 150px;"
								class="form-control" id="NoteEvento" name="NoteEvento"></textarea>
						</div>
					</div>
				</div>
			</div>


			<div id="popup1" class="overlay">
				<div class="popup">

					<div class="content">
						<h3 class="fw-bold">Sei sicuro di voler confermare?</h3>
						<p>L'offerta verrà eliminata se l'ID evento non è corretto.</p>
						<div class="content text-center">
							<button class="btn btn-outline-light" type="submit" name="OK"
								value="OK">OK</button>
							<a href="registrazioneCaritas.jsp"><button
									class="btn btn-outline-light" type="submit" name="" value="">ANNULLA</button></a>
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
		<div class="container  my-4">
			<div class="row">
				<div class="col">

					<a href="eventiPropostiNegozi.jsp"><button
							class="btn btn-warning" type="submit" name="indietro"
							value="indietro">Indietro</button></a>
				</div>
				<div class = "col"></div>
				<div class="col">
					<a class="button" href="#popup1"><button class="btn btn-light"
							type="submit" name="COMPLETA " value="COMPLETA ">Conferma</button></a>
				</div>
			</div>
		</div>
	</div>

</body>
</html>