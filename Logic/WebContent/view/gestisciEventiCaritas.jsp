<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="entity.EventTab"%>
<%@ page import="beanweb.GestisciEventiCaritasBoundary"%>

<%
Class.forName("com.mysql.jdbc.Driver");
%>
<%
if (request.getParameter("indietro") != null) {
%>
<jsp:forward page="homeCaritas.jsp" />
<%
}

if (request.getParameter("contatta") != null) {
%>
<jsp:forward page="contattaNegozio.jsp" />
<%
}
if (request.getParameter("cancella") != null) {
if (GestisciEventiCaritasBoundary.getInstance().cancellaEvento(request.getParameter("Id")) == true) {
	}
}

if(request.getParameter("accetta") != null){
	if(GestisciEventiCaritasBoundary.getInstance().confermaEvento(request.getParameter("accettaId")) == true){
		
	}
}

if(request.getParameter("Evento") != null){
	GestisciEventiCaritasBoundary.getInstance().creaEvento();
%>
<jsp:forward page="creaEventoGenerale.jsp" />
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

<title>GESTISCI EVENTI</title>
<link rel="stylesheet" href="../css/gestisciEventiCaritas.css">
<link rel="icon" sizes="64x64" href="../img/favicon.png">
</head>
<body>
	<div class="container">
		<form action="gestisciEventiCaritas.jsp" name="my" method="POST">

		
				<div class="container text-center">
					<h1>Gestisci Eventi</h1>
				</div>

				<div class = "container my-5 text-center">
				<div class="row">
						
						<div class="col">
							</br><button class="btn  btn-light" type="submit"   name = "cancella" value = "cancella">Elimina Evento</button>
							<input type="text" id = "Id" name= "Id"  placeholder="Inserisci l'ID degli eventi da eliminare">
						</div>
						<div class="col">
							</br><button class="btn btn-light" type="submit"  name= "contatta" value="contatta">Contatta Negozio</button>
						</div>
						<div class="col">
							</br><button class="btn  btn-light" type="submit"   name = "accetta" value = "accetta">Accetta Evento</button>
							<input type="text" id = "accettaId" name= "accettaId"  placeholder="Inserisci l'ID degli eventi da accettare">
						</div>
					</div>
			</div>
				

				
			

			<div class="content text-center">
				<table class="table table-hover">
				 <caption  style="visibility: hidden;">Eventi</caption>
					<thead>
						<tr>
							<th scope="col">ID EVENTO</th>
							<th scope="col">EVENTO</th>
							<th scope="col">NEGOZIO</th>
							<th scope="col">EMAIL NEGOZIO</th>
							<th scope="col">NOTE EVENTO</th>
							<th scope="col">IMPORTO</th>
							<th scope="col">STATO</th>
						</tr>
					</thead>
					<tbody>


						<%
						List<EventTab> list = GestisciEventiCaritasBoundary.getInstance().loadFormEvento();
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
								out.println(list.get(i).getNomeNegozio());
								%>
							
							</td>
							<td>
							<%
								out.println(list.get(i).getEmailNegozio());
								%>
							</td>
							<td>
								<%
								out.println(list.get(i).getNoteEvento());
								%>
							</td>
							<td>
								<%
								out.println(list.get(i).getImportoRaggiunto());
								%>/<%
								out.println(list.get(i).getPrezzoEvento());
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
				<div class="containter my-4">
					<div class = "row">
					<div class = "col">
						<button class="btn btn-warning" type="submit" name="indietro"
						value="indietro">Indietro</button>
						</div>
						<div class = "col"></div>
						<div class = "col"></div>
						<div class = "col">
						<button class="btn  btn-light" type="submit" name="Evento"
						value="Evento">Crea Evento</button>
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
	</div>
</body>
</html>