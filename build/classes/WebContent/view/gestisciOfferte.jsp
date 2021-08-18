<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="entity.Offerte"%>
<%@ page import="beanweb.GestioneOfferteCaritas"%>

<%
Class.forName("com.mysql.jdbc.Driver");
%>
<%
if (request.getParameter("indietro") != null) {
%>
<jsp:forward page="homeCaritas.jsp" />
<%
}


if(request.getParameter("accettaOfferta") != null){
	GestioneOfferteCaritas.getInstance().accetta(request.getParameter("accettaId"));
%>

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

<title>GESTIONE OFFERTE NEGOZI </title>
<link rel="stylesheet" href="../css/gestisciEventiCaritas.css">
<link rel="icon" sizes="64x64" href="../img/favicon.png">
</head>
<body>
	<div class="container">
		<form action="gestisciOfferte.jsp" name="my" method="POST">

		
				<div class="container text-center">
					<h1>Gestione Offerte dei Negozi</h1>
				</div>

				<div class = "container my-5 text-center">
				<div class="row">
						
					
						<div class="col">
							</br><button class="btn  btn-light" type="submit"   name = "accettaOfferta" value = "accettaOfferta">Accetta Evento</button>
							<input type="text" id = "accettaId" name= "accettaId"  placeholder="Inserisci l'ID degli eventi da accettare">
						</div>
					</div>
			</div>
				

				
			

			<div class="content text-center">
				<table class="table table-hover">
				 <caption  style="visibility: hidden;">Offerte</caption>
					<thead>
						<tr>
							<th scope="col">ID EVENTO</th>
							<th scope="col">NOME EVENTO</th>
							<th scope="col">NOME NEGOZIO</th>
							<th scope="col">PREZZO EVENTO</th>
							<th scope="col">NOTE EVENTO</th>
							<th scope="col">DATA EVENTO</th>
						</tr>
					</thead>
					<tbody>


						<%
						List<Offerte> list = GestioneOfferteCaritas.getInstance().loadOfferte();
						int i = 0;
						while (i < list.size()) {
						%>
						<tr>
							<td>
								<%
								out.println(list.get(i).getEvento());
								%>
							
							<td>
								<%
								out.println(list.get(i).getNomeEvento());
								%>
							</td>
							<td>
								<%
								out.println(list.get(i).getNomeNegozio());
								%>
							
							<td>
								<%
								out.println(list.get(i).getPrezzo() );
								%>
							</td>
							<td>
								<%
								out.println(list.get(i).getNote());
								%>
							</td>

							<td>
								<%
								out.println(list.get(i).getData()) ;
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