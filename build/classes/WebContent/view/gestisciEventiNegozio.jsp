<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="entity.EventTab"%>
<%@ page import="beanweb.GestisciEventiBoundary"%>

<%
Class.forName("com.mysql.jdbc.Driver");
%>
<%
if (request.getParameter("cancella") != null) {
	if (GestisciEventiBoundary.getInstance().eliminaEvento(request.getParameter("evento")) == true) {
%>

<%
}
}
%>
<%
if (request.getParameter("INDIETRO") != null) {
%>
<jsp:forward page="homeNegozio.jsp" />
<%
}
%>

<%
if (request.getParameter("contatta") != null) {
%>
<jsp:forward page="contattaCaritasNegozio.jsp" />
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

<title>GESTISCI EVENTI NEGOZIO</title>
<link rel="stylesheet" href="../css/gestisciEventiShop.css">
<link rel="icon" sizes="64x64" href="../img/favicon.png">
</head>
<body>
	<div class="container">
		<div class="container text-center">
			<h1>Gestione degli Eventi</h1>
		</div>
		<form action="gestisciEventiNegozio.jsp" name="my" method="POST">
		
		<div class= "container text-center my-5">
			<div class="row">
				<div class="col">
					<button class="btn  btn-light" type="submit" name="contatta"
						value="contatta">Contatta Caritas</button>
				</div>
					<div class="col">
					<button class="btn btn-light" type="submit" name="cancella"
						value="cancella">Elimina Evento</button>
					<input type="text" id="evento" name="evento"
						placeholder="Inserisci l'ID dell'evento da eliminare">
				</div>
				</div>
			</div>


		

			<div class="indietro">
				<button class="btn btn-warning" type="submit" name="INDIETRO"
					value="INDIETRO ">Indietro</button>
			</div>

			<div class="content text-center">
			<table class="table table-hover">
			<caption  style="visibility: hidden;">Eventi</caption>
				<thead>
					<tr>
						<th scope="col">ID EVENTO</th>
						<th scope="col">EVENTO</th>
						<th scope="col">CARITAS</th>
						<th scope="col">NOTE EVENTO</th>
						<th scope="col">IMPORTO RAGGIUNTO</th>
						<th scope="col">STATO EVENTO</th>
					</tr>
				</thead>
				<tbody>


					<%
					List<EventTab> list = GestisciEventiBoundary.getInstance().loadShopBoundary();
					int i = 0;
					while (i < list.size()) {
					%>
					<tr>
						<td>
							<%
							out.println(list.get(i).getId());
							%>
						</td>
						<td>
							<%
							out.println(list.get(i).getNomeEvento());
							%>
						</td>
						<td>
							<%
							out.println(list.get(i).getNomeCaritas());
							%>
						</td>
						<td>
							<%
							out.println(list.get(i).getNoteEvento());
							%>
						</td>
						<td>
							<%
							out.println(list.get(i).getImportoRaggiunto()+"/"+list.get(i).getPrezzoEvento());
							%>
						</td>
						<td>
							<%
							out.println(list.get(i).getStatoEvento());
							%>
						</td>
					</tr>

					<%
					i++;
					}
					%>
					
				</tbody>
			</table>
			</div>

			<!-- Optional JavaScript; choose one of the two! -->

			<!-- Option 1: Bootstrap Bundle with Popper -->
			<script
				src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
				integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
				crossorigin="anonymous"></script>

		

		</form>
	</div>
</body>
</html>