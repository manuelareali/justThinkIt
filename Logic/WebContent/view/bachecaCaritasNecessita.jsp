<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="entity.Necessita"%>
<%@ page import="beanweb.BachecaPersonaleBoundary"%>
<%
Class.forName("com.mysql.jdbc.Driver");

if (request.getParameter("indietro") != null) {
%>
<jsp:forward page="homeCaritas.jsp" />
<%
}

if (request.getParameter("crea") != null) {
	BachecaPersonaleBoundary.getInstance().creaNecessita();
%>
<jsp:forward page="creaNecessitaCaritas.jsp" />
<%
}

if (request.getParameter("eliminaNecessità") != null) {
if (BachecaPersonaleBoundary.getInstance().eliminaNecessita(request.getParameter("id_necessità")) == true) {
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

<title>BACHECA NECESSITA'</title>
<link rel="stylesheet" href="../css/bachecaCaritass.css">
<link rel="icon" sizes="64x64" href="../img/favicon.png">
</head>
<body>
	<div class="container">
		<form action="bachecaCaritasNecessita.jsp" name="my" method="POST">
			
				<div class="container text-center">
					<h1>Bacheca Necessità</h1>
				</div>
			
			
			<div class="container text-center my-5">
				<div class="row">
					<div class="col">
						<button class="btn  btn-light" type="submit"
							name="eliminaNecessità" value="eliminaNecessità">Elimina
							Necessità</button>
						<input type="text" id="id_necessità" name="id_necessità"
							placeholder="Inserisci l'ID della necessità da eliminare">
					</div>
					
					<div class="col">
						<button class="btn btn-light" type="submit" name="crea"
							value="crea">Crea Necessità</button>
					</div>
				</div>
			</div>

			
			<div class="content text-center ">
				<table class="table table-hover">
				<caption style="visibility: hidden;">Bacheca</caption>
					<thead>
						<tr>
							<th scope="col">ID NECESSITA'</th>
							<th scope="col">TIPOLOGIA</th>
							<th scope="col">DESCRIZIONE</th>
							<th scope="col">URGENZA</th>
						</tr>
					</thead>
					<tbody>
						<%
						List<Necessita> list = BachecaPersonaleBoundary.getInstance().loadFormBacheca();
						int i = 0;
						while (i < list.size()) {
						%>
						<tr>
							<td>
								<%
								out.println(list.get(i).getIdNece());
								%>
							</td>
							<td>
								<%
								out.println(list.get(i).getTipologia());
								%>
							</td>
							<td>
								<%
								out.println(list.get(i).getDescrizione());
								%>
							</td>
							<td>
								<%
								out.println(list.get(i).getUrgenza());
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

	<div class="container my-4">
				<button class="btn btn-warning" type="submit" name="indietro"
					value="indietro">Indietro</button>
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