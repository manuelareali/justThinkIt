<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="beanweb.ShopHomeBoundary"%>

<%
	if (request.getParameter("GESTISCI EVENTI") != null){
		ShopHomeBoundary.getInstance().gestisciEventi();
%>
	<jsp:forward page="gestisciEventiNegozio.jsp"/>
<%
}

	if(request.getParameter("GESTISCI EVENTI PROP CARITAS") != null){
		ShopHomeBoundary.getInstance().gestisciEventiPropCaritas();
	
%>
	<jsp:forward page="eventiPropostiNegozi.jsp"/>
<%
	}
%>
	
<%
	if(request.getParameter("cercaCaritas") != null){
		ShopHomeBoundary.getInstance().cercaCaritas();
%>
		<jsp:forward page="mappa.jsp"/>
<%	
	}

if(request.getParameter("OK") != null){
	
	ShopHomeBoundary.getInstance().deleteAccountButtonPressed();
%>
	<jsp:forward page="index.jsp"/>
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

<title>HOME NEGOZIO</title>
<link rel="icon" sizes="64x64" href="../img/favicon.png">
<link rel="stylesheet" href="../css/homeShops.css">
</head>
<body>
	<div class="container">
		<form action = "homeNegozio.jsp" name ="my" method = "POST">




			<div class="row">
				<div class="col-sm-6 col-md-8">
					<div class="position-absolute top-0 start-0">

						<img src="../img/caritas.png" width="450px" height="300px"
							alt="...">
					</div>
				</div>
				<div class="col-6 col-md-4">
					<h1 >Welcome Shop</h1>
					<h2 class="fw-bold" >
<%
out.println(ShopHomeBoundary.getInstance().getNomeShop());
%></h2>

				</div>
			</div>



			<div class="container text-center my-5">
				<div class = "row">
				<div class = "col">
					<button class="btn  btn-light" type="submit" name= "cercaCaritas" value="cercaCaritas">MAPPA</button>
				</div>
				<div class = "col">	
					<button class="btn  btn-light" type="submit"  name= "GESTISCI EVENTI" value="GESTISCI EVENTI">GESTISCI EVENTI</button>
				</div>
				<div class = "col">	
					<button class="btn  btn-light" type="submit"  name= "GESTISCI EVENTI PROP CARITAS" value="GESTISCI EVENTI PROP CARITAS">EVENTI PROPOSTI DALLA CARITAS</button>
				</div>
				</div>
			</div>


	<div id="popup2" class="overlay">
			<div class="popup">

				<div class="content">
					<h3 class="fw-bold">Sei sicuro di voler eliminare il tuo account?</h3>
					<p>Se eliminerai l'account perderai le tue attività.</p>
					<div class="content text-center">
						<button class="btn btn-outline-light"
								type="submit" name="OK" value="OK">OK</button> <a
							href="homeNegozio.jsp"><button class="btn btn-outline-light"
								type="submit" name="" value="">ANNULLA</button></a>
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
		<div class = "row">
			<div class="col">
			<div class="container text-center">
				<a class="button" href="#popup1"><button
						class="btn btn-outline-primary" type="submit" name="LOGOUT"
						value="LOGOUT">ESCI</button></a>
			</div>
		</div>
		
				<div class = "col">
			<div class="container text-center">
				<a class="button" href="#popup2"><button style ="font-size:18px"class="btn btn-outline-primary" type="submit"  name= "ELIMINA" value="ELIMINA">ELIMINA ACCOUNT</button></a>
			</div>
			</div>
		
			</div>
		<div id="popup1" class="overlay">
			<div class="popup">

				<div class="content">
					<h3 class="fw-bold">Sei sicuro di voler uscire?</h3>
					<p>Se uscirai dovrai effettuare un nuovo accesso.</p>
					<div class="content text-center">
						<a href="index.jsp"><button class="btn btn-outline-light"
								type="submit" name="" value="">OK</button></a> <a
							href="homeCaritas.jsp"><button class="btn btn-outline-light"
								type="submit" name="" value="">ANNULLA</button></a>
					</div>
				</div>

			</div>
		</div>
	</div>
</body>
</html>