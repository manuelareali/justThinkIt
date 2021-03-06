<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<jsp:useBean id="RegistrationShopBoundary" scope="request" class="beanweb.RegistrationShopBoundary"/>
<jsp:setProperty name="RegistrationShopBoundary" property="*"/>


<%
Class.forName("com.mysql.jdbc.Driver");
if (request.getParameter("OK") != null) {
	if(RegistrationShopBoundary.isNumeric(request.getParameter("RecapitoTel")) == true){
		if (request.getParameter("confermaPassword").equalsIgnoreCase(request.getParameter("Password"))) {
	if (request.getParameter("Tipologia").equalsIgnoreCase("Vestiti")) {
		if ((RegistrationShopBoundary.registraNegozioPressed("Vestiti", request.getParameter("NomeNegozio"),
				request.getParameter("Password"),
				request.getParameter("IndirizzoNeg") + " " + request.getParameter("Via") + " "
						+ request.getParameter("nCivico"),
				request.getParameter("RecapitoTel"), request.getParameter("Email"),
				request.getParameter("Citt?")) == true)) {
%>
<jsp:forward page="log.jsp" />
<%
}
} else if (request.getParameter("Tipologia").equalsIgnoreCase("Cibo")) {
if ((RegistrationShopBoundary.registraNegozioPressed("Cibo", request.getParameter("NomeNegozio"),
		request.getParameter("Password"),
		request.getParameter("IndirizzoNeg") + request.getParameter("Via") + " " + request.getParameter("nCivico"),
		request.getParameter("RecapitoTel"), request.getParameter("Email"), request.getParameter("Citt?")) == true)) {
%>
<jsp:forward page="log.jsp" />
<%
}

}
} else {
%>
<jsp:forward page="registrazioneShop.jsp" />
<%
}
}
}

if(request.getParameter("INDIETRO") != null){
%>
<jsp:forward page="registrazione.jsp" />
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

<title>REGISTARZIONE NEGOZIO</title>
<link rel="stylesheet" href="../css/formTutte.css">
<link rel="icon" sizes="64x64" href="../img/favicon.png">
</head>
<body>
	<div class="container">
		<div class="container text-center">
			<h1>Registrazione Negozio</h1>
		</div>
		<div class = "container my-5">
		<form class="row g-3 needs-validation"  action="registrazioneShop.jsp" name = "reg" method = "POST">
	
			
				
				<div class="col-md-4">
					<label for="validationCustom01" class="form-label">Nome Negozio
						</label> <input type="text" class="form-control" id = "NomeNegozio" name= "NomeNegozio" placeholder="es. Just">
				</div>

				<div class="col-md-4">
					<label for="validationCustom02" class="form-label">Password</label> <input
						type="password" class="form-control" id= "Password" name= "Password">
				</div>
				
				<div class="col-md-4">
					<label for="validationCustom03" class="form-label">Conferma Password</label> <input
						type="password" class="form-control"  id= "confermaPassword" name= "confermaPassword">
				</div>
				
			<div class="col-md-4">
					<label for="validationCustom04" class="form-label">Email</label> <input
						type="text" class="form-control" id="Email" name="Email"
						placeholder="es.caritasRoma@gmail.com" >
				</div>
				
						<div class="col-md-4">
					<label for="validationCustom05" class="form-label">Telefono</label>
					<input type="text" class="form-control" id="RecapitoTel"
						name="RecapitoTel" placeholder="es.34324234">
				</div>
				
				
				<div class="col-md-4">
					<label for="validationCustom06" class="form-label">Provincia</label>
					<input type="text" class="form-control"  id ="Citt?" name= "Citt?"  placeholder="es.Roma">
				</div>

				<div class="col-md-4">
					<label for="validationCustom06" class="form-label">Comune
						</label> <input type="text" class="form-control"
						id="IndirizzoCaritas" id ="IndirizzoNeg" name= "IndirizzoNeg"  placeholder="es.Ostia" >
				</div>

				<div class="col-md-4">
					<label for="validationCustom08" class="form-label">Via</label> <input
						type="text" class="form-control" id="Via" name="Via"
						placeholder="es. Luigi settembrini" >
				</div>

				<div class="col-md-4">
					<label for="validationCustom09" class="form-label">N Civico</label>
					<input type="text" class="form-control" id="nCivico" name="nCivico"
						placeholder="es.54">
				</div>

		
			
				
				
				  <div>
						<input class="form-check-input" type="checkbox"name="Tipologia" value="Cibo"> <label
							class="form-check-label" for="invalidCheck"> Cibo </label>
					</div>
				
				
				<div>
					
						<input class="form-check-input" type="checkbox" name="Tipologia" value="Vestiti"> <label
							class="form-check-label" for="invalidCheck"> Vestiti </label>
					</div>
				
				
				
				<div id="popup1" class="overlay">
			<div class="popup">

				<div class="content">
					<h3 class="fw-bold">Sei sicuro di voler confermare?</h3>
					<p>Se confermi non potrai pi? modificare i tuoi dati.</p>
					<div class="content text-center">
						<button class="btn btn-outline-light"
								type="submit" name="OK" value="OK">OK</button> <a
							href="registrazioneShop.jsp"><button class="btn btn-outline-light"
								type="submit" name="" value="">ANNULLA</button></a>
					</div>
				</div>

			</div>
		</div>
				
				
		
			
				
				</form>		
				</div>
						<div class = "container my-4">
				<div class="row">
					<div class="col-8">
						<a href= "registrazione.jsp"><button class="btn btn-warning" type="submit" name="INDIETRO"
								value="INDIETRO">Indietro</button></a>
					</div>
					
					<div class="col-4 text-center">
						<a class="button" href="#popup1"><button class="btn btn-light" type="submit"
							name="COMPLETA REGISTRAZIONE" value="COMPLETA REGISTRAZIONE">COMPLETA
							REGISTRAZIONE</button></a>
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

	
</body>
</html>