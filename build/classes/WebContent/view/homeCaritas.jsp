<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="beanweb.CaritasHomeBoundary"%>

<%
if (request.getParameter("BACHECA") != null) {
	CaritasHomeBoundary.getInstance().visualizzaBacheca();
%>
<jsp:forward page="bachecaCaritasNecessita.jsp" />
<%
}
%>
<%
if (request.getParameter("GESTISCI DONAZIONI") != null) {
	CaritasHomeBoundary.getInstance().gestisciDonazioni();
%>
<jsp:forward page="gestisciDonazioniCaritas.jsp" />
<%
}
if(request.getParameter("MAPPA") != null){
	CaritasHomeBoundary.getInstance().cercaCaritas();
	%>
	<jsp:forward page="mappa.jsp" />
	<%
}
%>

<%
if (request.getParameter("GESTISCI TURNI") != null) {
	CaritasHomeBoundary.getInstance().gestisciTurni();
%>
<jsp:forward page="gestisciTurniCaritas.jsp" />
<%
}
%>

<%
if (request.getParameter("GESTISCI EVENTI") != null) {
	CaritasHomeBoundary.getInstance().gestisciEventi();
%>
<jsp:forward page="gestisciEventiCaritas.jsp" />
<%
}
if(request.getParameter("OK") != null){
	
	CaritasHomeBoundary.getInstance().deleteAccountButtonPressed();
%>
	<jsp:forward page="index.jsp"/>
<%	
}

if(request.getParameter("GESTISCI OFFERTE") != null){
	CaritasHomeBoundary.getInstance().gestisciOfferte();
%>
	<jsp:forward page="gestisciOfferte.jsp"/>
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

<title>HOME CARITAS</title>
<link rel="icon" sizes="64x64" href="../img/favicon.png">
<link rel="stylesheet" href="../css/homeCaritass.css">
</head>
<body>


	<div class=" container">
		<form action="homeCaritas.jsp" name="my" method="POST">
			<div class="row">
				<div class="col-sm-6 col-md-8">
					<div class="position-absolute top-0 start-0">

						<img src="../img/caritas.png" width="450px" height="300px"
							alt="...">
					</div>
				</div>
				
				<div class="col-6 col-md-4">
					<h1>Welcome Caritas</h1>
					<h2 class="fw-bold">
<%
out.println(CaritasHomeBoundary.getInstance().getNomeCaritas());
%>
</h2>

				</div>
				
			
	</div>

			
			<div class="container text-center my-5">	
				<div class = "row">
				<div class = "col">
					<button class="btn  btn-light" type="submit" name="BACHECA"
						value="BACHECA">BACHECA</button>
				</div>
				<div class = "col">
					<button class="btn  btn-light" type="submit" name="GESTISCI TURNI"
						value="GESTISCI TURNI">GESTISCI TURNI</button>
				</div>
				<div class = "col">
					<button class="btn  btn-light" type="submit" name="GESTISCI EVENTI"
						value="GESTISCI EVENTI">GESTISCI EVENTI</button>
				</div>
				</div>
				</div>
				<div class = "container text-center my-4">
				<div class = "row">
				<div class = "col">
					<button class="btn  btn-light" type="submit"
						name="GESTISCI DONAZIONI" value="GESTISCI DONAZIONI">
						GESTISCI DONAZIONI</button>
					</div>	
					<div class = "col">
					<button class="btn  btn-light" type="submit"
						name="GESTISCI OFFERTE" value="GESTISCI OFFERTE">
						GESTISCI OFFERTE NEGOZI</button>
					</div>	
					<div class = "col">
					<button class="btn  btn-light" type="submit"
						name="MAPPA" value="MAPPA">
						MAPPA</button>
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
							href="homeCaritas.jsp"><button class="btn btn-outline-light"
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
		
		
	</div>
</body>
</html>