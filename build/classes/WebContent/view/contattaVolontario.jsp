<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="beanweb.EmailBoundary"%>

<%
Class.forName("com.mysql.jdbc.Driver");
	if(request.getParameter("INVIA")!=null){
		if(EmailBoundary.getInstance().sendMessage(request.getParameter("codice_mittente"),request.getParameter("codice_destinatario"), request.getParameter("messaggio"), request.getParameter("Oggetto")) == true){
			
%>
<jsp:forward page="homeCaritas.jsp" />
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

<title>CONTATTA</title>
<link rel="stylesheet" href="../css/email.css">
<link rel="icon" sizes="64x64" href="../img/favicon.png">
</head>
<body>
	<div class="container">
		<form action="contattaCaritasMap.jsp" name="my" method="POST">

			<div class="container text-center">
				<h1>Contattami ti risponderò appena possibile!</h1>
			</div>

			<div class="container text-center my-5">
				<div class="row">
					<div class="col">
						<input type="text" id="codice_mittente" name="codice_mittente"
							placeholder="Mittente" />
					</div>
					<div class="col">
						<input type="text" id="codice_destinatario"
							name="codice_destinatario" placeholder="Destinatario" />
					</div>
					<div class="col">
						<input type="text" id="Oggetto" name="Oggetto"
							placeholder="Oggetto" />
					</div>

				</div>

				<div class="container text-center my-5">
					<textarea id="messaggio" name="messaggio"
						placeholder="Scrivi qui il tuo messaggio."></textarea>
				</div>


			</div>


			<div class="invia">
				<button type="submit" class="btn btn-light" name="INVIA"
					value="INVIA">INVIA</button>
			</div>
</form>
<div class="box">
			<div class="container text-center">
				<a class="button" href="#popup1"><button
						class="btn btn-warning" type="submit" name="indietro"
						value="indietro">Indietro</button></a>
			</div>
		</div>
		<div id="popup1" class="overlay">
			<div class="popup">

				<div class="content">
					<h3 class="fw-bold">Sei sicuro di voler tornare indietro?</h3>
					<p>Se torni indietro perderai le modifiche effettuate.</p>
					<div class="content text-center">
						<a href="gestisciDonazioniCaritas.jsp"><button class="btn btn-outline-light"
								type="submit" name="" value="">OK</button></a> <a
							href="contattaVolontario.jsp"><button class="btn btn-outline-light"
								type="submit" name="" value="">ANNULLA</button></a>
					</div>
				</div>

			</div>
		</div>
			<script
				src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
				integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
				crossorigin="anonymous"></script>

		

		
	</div>
</body>
</html>