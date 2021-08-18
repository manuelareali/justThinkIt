<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="entity.EventTab"%>
<%@ page import="beanweb.GestisciEventiPropCaritas"%>

<%
Class.forName("com.mysql.jdbc.Driver");
%>
<%
if (request.getParameter("indietro") != null) {
%>
<jsp:forward page="homeNegozio.jsp" />
<%
}

if(request.getParameter("Proponi Offerta") != null){
	if (request.getParameter("Proponi OffertaId") != null){
		GestisciEventiPropCaritas.getInstance().proponi(Integer.parseInt(request.getParameter("Proponi OffertaId")));
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

<title>EVENTI PROPOSTI DALLE CARITAS</title>
<link rel="stylesheet" href="../css/gestisciEventiCaritass.css">
<link rel="icon" sizes="64x64" href="../img/favicon.png">
</head>
<body>
	<div class="container">
		<form action="eventiPropostiNegozi.jsp" name="my" method="POST">

		
				<div class="container text-center">
					<h1>Eventi proposti dalle Caritas</h1>
				</div>

				<div class = "container my-5 text-center">
				<div class="row">
						<div class="col">
							</br><button class="btn  btn-light" type="submit"   name = "Proponi Offerta" value = "Proponi Offerta">Proponi Offerta</button>
							<input type="text" id = "Proponi OffertaId" name= "Proponi OffertaId"  placeholder="Inserisci l'ID degli eventi da accettare">
						</div>
					</div>
			</div>
				

				
			

			<div class="content text-center">
				<table class="table table-hover">
				 <caption  style="visibility: hidden;">Eventi Proposti</caption>
					<thead>
						<tr>
							<th scope="col">ID EVENTO</th>
							<th scope="col">NOME EVENTO</th>
							<th scope="col">NOME CARITAS</th>
							<th scope="col">NOTE EVENTO</th>
							<th scope="col">TIPO</th>
						</tr>
					</thead>
					<tbody>


						<%
						List<EventTab> list = GestisciEventiPropCaritas.getInstance().loadFormEvento();
						int i = 0;
						while (i < list.size()) {
						%>
						<tr>
							<td>
								<%
								out.println(list.get(i).getId());
								%>
							
							<td>
								<%
								out.println(list.get(i).getNomeEvento());
								%>
							</td>
							<td>
								<%
								out.println(list.get(i).getNomeCaritas());
								%>
							
							<td>
								<%
								out.println(list.get(i).getNoteEvento());
								%>
							</td>
							<td>
								<%
								out.println(list.get(i).getTipoEvento());
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
	<div class="containter my-4">
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