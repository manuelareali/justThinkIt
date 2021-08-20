<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="entity.Necessita"%>
<%@ page import="beanweb.BachecaBoundary"%>

<%
Class.forName("com.mysql.jdbc.Driver");

if (request.getParameter("CONTATTA CARITAS") != null) {
	BachecaBoundary.getInstance().creaEmail();
%>
<jsp:forward page="contatta.jsp" />
<%
}

if (request.getParameter("CREA DONAZIONE") != null) {
BachecaBoundary.getInstance().creaDonazione();
%>
<jsp:forward page="creaDonazioneMap.jsp" />
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

<title>BACHECA CARITAS</title>
<link rel="stylesheet" href="../css/bachecaCaritasMaps.css">
<link rel="icon" sizes="64x64" href="../img/favicon.png">
</head>
<body>
	<div class="container">
		<div class="container text-center">
			<h1>Bacheca della Caritas</h1>
		</div>
		<form action="bachecaCaritasMap.jsp" name="my" method="POST">
		
		<div class = "container my-4 text-center">
			<div class="row">
				<div class="col">
					<button class="btn  btn-light" type="submit"
						name="CONTATTA CARITAS" value="CONTATTA CARITAS">Contatta
						Caritas</button>
				</div>
		
				<div class="col">
					<button class="btn btn-light" type="submit" name="CREA DONAZIONE"
						value="CREA DONAZIONE">Crea Donazione</button>
				</div>
			</div>
			</div>


		



			
			<table class="table table-hover text-center">
			<caption style="visibility: hidden;">Bacheca</caption>
				<thead>
					<tr>
						<th scope="col">EMAIL CARITAS</th>
						<th scope="col">TIPOLOGIA</th>
						<th scope="col">URGENZA</th>
						<th scope="col">DESCRIZIONE</th>
					</tr>
				</thead>
				<tbody>


					<%
					List<Necessita> list = BachecaBoundary.getInstance().loadNecessita();
					int i = 0;
					while (i < list.size()) {
					%>
					<tr>
					<td>
							<%
							out.println(list.get(i).getEmail());
							%>
						</td>
						<td>
							<%
							out.println(list.get(i).getTipologia());
							%>
						</td>
						<td>
							<%
							out.println(list.get(i).getUrgenza());
							%>
						</td>
						<td>
							<%
							out.println(list.get(i).getDescrizione());
							%>
						</td>
					</tr>

					<%
					i++;
					}
					%>

				</tbody>
			</table>

			<!-- Optional JavaScript; choose one of the two! -->

			<!-- Option 1: Bootstrap Bundle with Popper -->
			<script
				src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
				integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
				crossorigin="anonymous"></script>

			

		</form>
		
		
			<div class = "my-5">
			<a href= "mappa.jsp"><button class="btn btn-warning" type="submit" name="INDIETRO"
					value="INDIETRO">Indietro</button></a>
			</div>
	</div>
</body>
</html>