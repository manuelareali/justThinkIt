<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="beanweb.EmailBoundary"%>
<%@ page import="beanweb.ShopHomeBoundary"%>

<%
Class.forName("com.mysql.jdbc.Driver");
	if(request.getParameter("OK")!=null){
		if(EmailBoundary.getInstance().sendMessage(ShopHomeBoundary.getInstance().getEmailShop(),request.getParameter("codice_destinatario"), request.getParameter("Messaggio"), request.getParameter("oggetto")) == true){
			
%>
<jsp:forward page="gestisciEventiNegozio.jsp" />
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
<link rel="stylesheet" href="../css/invioEmails.css">
<link rel="icon" sizes="64x64" href="../img/favicon.png">
</head>
<body>
	<div class="container">
		<form action="contattaCaritasNegozio.jsp" name="my" method="POST">

			<div class="container text-center">
				<h1>Contatta la nostra Caritas ti risponderemo appena possibile!</h1>
			</div>

			<div class="container text-center my-5">
				<div class="row">
					<div class="col">
						<input type="text" id="<%out.println(ShopHomeBoundary.getInstance().getEmailShop()); %>" name="<%out.println(ShopHomeBoundary.getInstance().getEmailShop()); %>"
							placeholder="<%out.println(ShopHomeBoundary.getInstance().getEmailShop()); %>" />
					</div>
					<div class="col">
						<input type="text" id="codice_destinatario"
							name="codice_destinatario" placeholder="Destinatario" />
					</div>
					<div class="col">
						<input type="text" id="oggetto" name="oggetto"
							placeholder="Oggetto" />
					</div>

				</div>

				<div class="container text-center my-5">
					<textarea id="Messaggio" name="Messaggio"
						placeholder="Scrivi qui il tuo messaggio."></textarea>
				</div>


			</div>


	<div id="popup7" class="overlay">
			<div class="popup">

				<div class="content">
					<h3 class="fw-bold">Sei sicuro di voler inviare l'email?</h3>
					<p>Verifica che l'indirizzo del destinatario sia corretto.</p>
					<div class="content text-center">
						<button class="btn btn-outline-light"
								type="submit" name="OK" value="OK">OK</button>
							<button class="btn btn-outline-light"
								type="submit" name="" value="">ANNULLA</button>
					</div>
				</div>

			</div>
		</div>

			
</form>


		<div class="container my-4">
			<div class="row">
				<div class="col">
					<a class="button" href="gestisciEventiNegozio.jsp"><button
							class="btn btn-warning" type="submit" name="INDIETRO"
							value="INDIETRO">Indietro</button></a>
				</div>
				<div class="col"></div>
				<div class="col"></div>
				<div class="col">
					<a class="button" href="#popup7"><button type="submit"
							class="btn btn-light" name="INVIA" value="INVIA">INVIA</button></a>
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