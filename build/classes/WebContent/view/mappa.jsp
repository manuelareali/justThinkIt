<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="entity.CoordinateMap"%>

<%
Class.forName("com.mysql.jdbc.Driver");
%>

<jsp:useBean id="CercaCaritas" scope="application"	class="beanweb.CercaCaritas" />

<jsp:setProperty name="CercaCaritas" property="*" />


<%
List<CoordinateMap> caritas = CercaCaritas.getInstance().initMarkersCaritas();
List<CoordinateMap> evento = CercaCaritas.getInstance().initMarkersEvento();
List<CoordinateMap> donazione = CercaCaritas.getInstance().initMarkersDonazione();

%>

<!DOCTYPE html>
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


<link rel="stylesheet" href="../css/mappa.css" />
<meta name="viewport"
	content="initial-scale=1,maximum-scale=1,user-scalable=no" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/leaflet/1.3.1/leaflet.css" />
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/leaflet/1.3.1/leaflet.js" ></script>
<meta charset="ISO-8859-1">
<title>MAPPA</title>
<style>

</style>
</head>
<script type="text/javascript">
	var idMarker = 0;
	var hidden = false;
	var tipoUtente = "";
</script>

<body>
	
	<form action="mappa.jsp" name="reg" method="POST">
		
		<div class="header"></div>


		<%
		if (CercaCaritas.getInstance().trovaRuoloBean().equalsIgnoreCase("Volontario")) {
		%>
		<button class="btn  btn-light" id="donazione" name="donazione"
			style="visibility: hidden; position: absolute; top: 35%; left: 1%;">Crea Donazione</button>
		<button class="btn  btn-light" id="necessita" name="necessita"
			style="visibility: hidden; position: absolute; top: 42%; left: 1%;">Vedi Bacheca</button>
		<button class="btn  btn-light" id="turno" name="turno"
			style="visibility: hidden; position: absolute; top: 49%; left: 1%;">Prenota Turno</button>
		<button class="btn  btn-light" id="partecipaEvento" name="partecipaEvento"
			style="visibility: hidden; position: absolute; top: 35%; left: 1%;">Partecipa Evento</button>


		
			<button style="visibility: hidden;position: absolute; top: 35%; left: 1%;"  class="btn  btn-light" id = "Indicatore" name = "Indicatore" 
				onClick="updateLatLng(document.getElementById('latitude').value,document.getElementById('longitude').value,1)">Indicatore</button>
		<div class="my-3">	
			<label for="latitude">Latitude:</label> <input id="latitude" name = "latitude" value = "0"
				type="text" /> <label for="longitude">Longitude:</label> <input
				id="longitude" value = "0" name = "longitude" type="text" />
		</div>

		<div class="indietro">
			<button class="btn btn-warning" type="submit" name="INDIETRO" value="INDIETRO">Indietro</button>
		</div>
		<% 
		if(request.getParameter("INDIETRO") != null){
			%>
			<jsp:forward page="homeVolontario.jsp" />
			<%
		}
			
			%>
		<script>
			tipoUtente = "Volontario";
		</script>

		<%
		}

		if (CercaCaritas.getInstance().trovaRuoloBean().equalsIgnoreCase("Negozio")) {
		%>
		<button class="btn  btn-light" id="donazione" name="donazione"
			style="visibility: hidden; position: absolute; top: 35%; left: 1%; font-weight: bold">Crea Donazione</button>
		<button  class="btn  btn-light" id="necessita" name="necessita"
			style="visibility: hidden; position: absolute; top: 42%; left: 1%;">Vedi Bacheca</button>
	
		<button class="btn btn-light"   type= "submit"  id="promuoviEvento" name="promuoviEvento"
			style="visibility: hidden; position: absolute; top: 49%; left: 1%;">Promuovi Evento</button>
		
		
			<button class="btn  btn-light" id= "Indicatore" name = "Indicatore" 
				onClick="updateLatLng(document.getElementById('latitude').value,document.getElementById('longitude').value,1)" style="visibility: hidden; position: absolute; top: 35%; left: 1%;">Indicatore</button>
		<div class="my-3">	
			<label  for="latitudine">Latitude:</label> <input id="latitude" name = "latitude" value = "0"
				type="text" /> <label   for="longitudine">Longitude:</label> <input 
				 id="longitude" name = "longitude" value = "0" type="text" />
		</div>
	


		<div class="indietro">
			<button class="btn btn-warning" type="submit" name="INDIETRO" value="INDIETRO">Indietro</button>
		</div>
		<% 
		if(request.getParameter("INDIETRO") != null){
			%>
			<jsp:forward page="homeNegozio.jsp" />
			<%
		}
			
			%>
		<script>
			tipoUtente = "Negozio";
		</script>
		<%
		}
	
		if (CercaCaritas.getInstance().trovaRuoloBean().equalsIgnoreCase("Caritas")){
			%>
		<button class="btn  btn-light" id= "Indicatore" name = "Indicatore" 
				onClick="updateLatLng(document.getElementById('latitude').value,document.getElementById('longitude').value,1)" style="visibility: hidden; position: absolute; top: 35%; left: 1%;">Indicatore</button>
		<div class="my-3">	
			<label  for="latitudine">Latitude:</label> <input id="latitude" name = "latitude" value = "0"
				type="text" /> <label   for="longitudine">Longitude:</label> <input 
				 id="longitude" name = "longitude" value = "0" type="text" />
		</div>
		<div class="indietro">
			<button class="btn btn-warning" type="submit" name="INDIETRO" value="INDIETRO">Indietro</button>
		</div>
		<% 
		
		if(request.getParameter("INDIETRO") != null){
			%>
			<jsp:forward page="homeCaritas.jsp" />
			<%
		}
		
		
			%>
		<script>
			tipoUtente = "Caritas";
		</script>

<%} %>


		<div class="hidden">
			<input type="text" id="donazioneInput" name="donazioneInput">
			<input type="text" id="turnoInput" name="turnoInput"> <input
				type="text" id="eventoInput" name="eventoInput"> <input
				type="text" id="necessitaInput" name="necessitaInput"> <input
				type="text" id="promuoviInput" name="promuoviInput"> <input
				type="text" id="partecipaInput" name="partecipaInput">
				<input type="text" id="indicatoreInput" name="indicatoreInput">
		</div>


	</form>

	<div class = "containter my-5">
	<div  class = "map" id="map"  style = "z-index:0;"></div>
	</div>
	<div class="check">

		<div>
			<input type="radio" class="gaucher" id="1" name="1"
				onClick=" checkRadio(name, this)"  value="1">
			<label for="1">Caritas</label>
		</div>
		<div>
			<input type="radio" class="gaucher" id="2" name="2"
				onClick=" checkRadio(name, this)" value="2">
			<label for="2">Eventi</label>
		</div>

		<div>
			<input type="radio" class="gaucher" id="3" name="3"
				onClick=" checkRadio(name, this)" value="3">
			<label for="3">Donazioni</label>
		</div>
		<div>
			<input type="radio" class="gaucher" id="4" name="4"
				onClick=" checkRadio(name, this)" value="4">
			<label for="4">MioMarker</label>
		</div>
	</div>

<%

	if (request.getParameter("Indicatore") != null) {
		if(!request.getParameter("latitude").equalsIgnoreCase("0")){
			CercaCaritas.getInstance().initMarkerIndicatore(request.getParameter("latitude"),request.getParameter("longitude"));
		}

	}
	if (request.getParameter("promuoviEvento") != null) {
		String parametroPromuovi = request.getParameter("promuoviInput");
		if(parametroPromuovi == ""){			
	%>
	
	
	<%
	} else {
	CercaCaritas.getInstance().promuoviEvento(Integer.parseInt(parametroPromuovi));
	%>
	<jsp:forward page="promuoviEventoMap.jsp" />
	<%
		}
	}
	if (request.getParameter("donazione") != null) {
	String parametro = request.getParameter("donazioneInput");
	if(parametro == ""){
 	%>
		
	<%
	}else{	

		CercaCaritas.getInstance().creaDonazione(Integer.parseInt(parametro));
	%>
	<jsp:forward page="creaDonazioneMap.jsp" />
	<%
		}
	}
	if (request.getParameter("evento") != null) {
	String parametroEvento = request.getParameter("eventoInput");
	if(parametroEvento == ""){
	%>
	<%
	}else{
	
	CercaCaritas.getInstance().partecipaEvento(Integer.parseInt(parametroEvento));
	%>
	<jsp:forward page="partecipaEventoVolontario.jsp" />
	<%
	}
	}

	if (request.getParameter("turno") != null) {
	String parametroTurno = request.getParameter("turnoInput");
	if (parametroTurno == ""){
%>

<%		
	}else{
	
	CercaCaritas.getInstance().prenotaTurno(Integer.parseInt(parametroTurno));
	%>
	<jsp:forward page="prenotaTurnoMap.jsp" />
	<%
	}}
	if (request.getParameter("necessita") != null) {
	String parametroNecessita = request.getParameter("necessitaInput");
	if (parametroNecessita == ""){
%>

<%	
	}else{

	CercaCaritas.getInstance().vediNecessita(Integer.parseInt(parametroNecessita));
	%>
	<jsp:forward page="bachecaCaritasMap.jsp" />
	<%
	}
	}

	if (request.getParameter("partecipaEvento") != null) {
	String parametroPartecipa = request.getParameter("partecipaInput");
	if (parametroPartecipa == ""){
		%>
		<%
	}else{
	
	CercaCaritas.getInstance().partecipaEvento(Integer.parseInt(parametroPartecipa));
	%>
	<jsp:forward page="partecipaEventoVolontario.jsp" />
	<%
	}
	}
	String jsMarker = "";
	for (int i = 0; i < caritas.size(); i++) {
	String myY = caritas.get(i).getLongitudine();
	String myX = caritas.get(i).getLatitudine();

	int id = caritas.get(i).getIdMarker();
	jsMarker += "{\"geometry\": {\"type\": \"Point\",\"coordinates\": [" + myX + "," + myY
			+ "]},\"type\": \"Feature\",\"properties\": {\"popupContent\": \"Caritas\"},\"id\": " + id + " }";
	if (i != caritas.size() - 1) {
		jsMarker += ",";
	}
	}
	String jsMarkerEvento = "";
	for (int i = 0; i < evento.size(); i++) {
	String myY = evento.get(i).getLongitudine();
	String myX = evento.get(i).getLatitudine();
	int id = evento.get(i).getIdMarker();
	jsMarkerEvento += "{\"geometry\": {\"type\": \"Point\",\"coordinates\": [" + myX + "," + myY
			+ "]},\"type\": \"Feature\",\"properties\": {\"popupContent\": \"Evento\"},\"id\": " + id + " }";
	if (i != evento.size() - 1) {
		jsMarkerEvento += ",";
	}
	}

	String jsMarkerDonazioni = "";
	for (int i = 0; i < donazione.size(); i++) {
	String myY = donazione.get(i).getLongitudine();
	String myX = donazione.get(i).getLatitudine();
	int id = donazione.get(i).getIdMarker();
	jsMarkerDonazioni += "{\"geometry\": {\"type\": \"Point\",\"coordinates\": [" + myX + "," + myY
			+ "]},\"type\": \"Feature\",\"properties\": {\"popupContent\": \"Donazione\"},\"id\": " + id + " }";
	if (i != donazione.size() - 1) {
		jsMarkerDonazioni += ",";
	}
	}

	int idUte = CercaCaritas.getIdUte();
	%>
	<script>
		var caritasMarker = {
			"type" : "FeatureCollection",
			"features" : [
	<%=jsMarker%>
		]
		};

		var eventoMarker = {
			"type" : "FeatureCollection",
			"features" : [
	<%=jsMarkerEvento%>
		]
		};

		var donazioniMarker = {
			"type" : "FeatureCollection",
			"features" : [
	<%=jsMarkerDonazioni%>
		]
		};

		var map = L.map('map').setView([ 41.87, 12.47 ], 8);

		var baselayer1 = L
				.tileLayer(
						'http://{s}.tile.osm.org/{z}/{x}/{y}.png',
						{
							attribution : '&copy; <a href="http://osm.org/copyright">OpenStreetMap</a> contributors'
						}).addTo(map);

		var layerDonazioni = L.geoJSON(donazioniMarker);
		var layerEvento = L.geoJSON(eventoMarker);
		var layerCaritas = L.geoJSON(caritasMarker);

		var marker = L.marker([ 41.87, 12.47 ], {
			draggable : true
		}).addTo(map);
		marker.on('dragend', function(e) {
			updateLatLng(marker.getLatLng().lat, marker.getLatLng().lng);
		});
		map.on('click', function(e) {
			marker.setLatLng(e.latlng);
			updateLatLng(marker.getLatLng().lat, marker.getLatLng().lng);
		});

		function updateLatLng(lat, lng, reverse) {
			if (reverse) {
				marker.setLatLng([ lat, lng ]);
				map.panTo([ lat, lng ]);
			} else {
				document.getElementById('latitude').value = marker.getLatLng().lat;
				document.getElementById('longitude').value = marker.getLatLng().lng;
				map.panTo([ lat, lng ]);
			}
		}

		var layers = [ layerCaritas, layerEvento, layerDonazioni ];

		selId = null;

		var tipo;
		var id;

		function onClick(e) {
			tipo = e.layer.feature.properties.popupContent;

			if (tipo == "Caritas") {
				idMarker = e.layer.feature.id;
				document.getElementById("donazioneInput").value = idMarker;
				document.getElementById("turnoInput").value = idMarker;
				document.getElementById("necessitaInput").value = idMarker;
				document.getElementById("promuoviInput").value = idMarker;
			} else if (tipo == "Evento") {
				document.getElementById("partecipaInput").value = idMarker;
			}
			alert(e.layer.feature.properties.popupContent);
		}
		

		function processCheck(checkbox) {
			var checkId = checkbox.id;

			if (checkbox.checked) {
				if (selId != null) {
					map.removeLayer(layers[selId - 1]);
					document.getElementById(selId).checked = false;
				}

				layers[checkId - 1].addTo(map).on('click', onClick);
				selId = checkId;
			} else {
				map.removeLayer(layers[checkId - 1]);
				selId = null;
			}
		}

		
		function checkRadio(name, checkbox) {
			
			if (tipoUtente == "Volontario") {
				if (!hidden) {
					if (name == "1") {
						document.getElementById('donazione').style.visibility = 'visible';
						document.getElementById('necessita').style.visibility = 'visible';
						document.getElementById('turno').style.visibility = 'visible';
						document.getElementById('partecipaEvento').style.visibility = 'hidden';
						document.getElementById('Indicatore').style.visibility = 'hidden';
						document.getElementById("1").checked = true;
						document.getElementById("2").checked = false;
						document.getElementById("3").checked = false;
						document.getElementById("4").checked = false;
					}

					else if (name == "2") {
						document.getElementById('donazione').style.visibility = 'hidden';
						document.getElementById('necessita').style.visibility = 'hidden';
						document.getElementById('turno').style.visibility = 'hidden';
						document.getElementById('partecipaEvento').style.visibility = 'visible';
						document.getElementById('Indicatore').style.visibility = 'hidden';
						document.getElementById("1").checked = false;
						document.getElementById("2").checked = true;
						document.getElementById("3").checked = false;
						document.getElementById("4").checked = false;
					} else if (name == "3") {
						document.getElementById('donazione').style.visibility = 'hidden';
						document.getElementById('necessita').style.visibility = 'hidden';
						document.getElementById('turno').style.visibility = 'hidden';
						document.getElementById('Indicatore').style.visibility = 'hidden';
						document.getElementById('partecipaEvento').style.visibility = 'hidden';
						document.getElementById("1").checked = false;
						document.getElementById("2").checked = false;
						document.getElementById("3").checked = true;
						document.getElementById("4").checked = false;
					} else if (name == "4") {
						document.getElementById('donazione').style.visibility = 'hidden';
						document.getElementById('necessita').style.visibility = 'hidden';
						document.getElementById('turno').style.visibility = 'hidden';
						document.getElementById('partecipaEvento').style.visibility = 'hidden';
						document.getElementById('Indicatore').style.visibility = 'visible';
						document.getElementById("1").checked = false;
						document.getElementById("2").checked = false;
						document.getElementById("3").checked = false;
						document.getElementById("4").checked = true;
					}
				}
			}
			else if (tipoUtente == "Negozio") {
				if (!hidden) {
					if (name == "1") {
						document.getElementById('donazione').style.visibility = 'visible';
						document.getElementById('necessita').style.visibility = 'visible';
						document.getElementById('promuoviEvento').style.visibility = 'visible';
						document.getElementById('Indicatore').style.visibility = 'hidden';
						document.getElementById("1").checked = true;
						document.getElementById("2").checked = false;
						document.getElementById("3").checked = false;
						document.getElementById("4").checked = false;
					} else if (name == "2") {
						document.getElementById('donazione').style.visibility = 'hidden';
						document.getElementById('necessita').style.visibility = 'hidden';
						document.getElementById('promuoviEvento').style.visibility = 'hidden';
						document.getElementById('Indicatore').style.visibility = 'hidden';
						document.getElementById("1").checked = false;
						document.getElementById("2").checked = true;
						document.getElementById("3").checked = false;
						document.getElementById("4").checked = false;
					} else if (name == 3) {
						document.getElementById('donazione').style.visibility = 'hidden';
						document.getElementById('necessita').style.visibility = 'hidden';
						document.getElementById('promuoviEvento').style.visibility = 'hidden';
						document.getElementById('Indicatore').style.visibility = 'hidden';
						document.getElementById("1").checked = false;
						document.getElementById("2").checked = false;
						document.getElementById("3").checked = true;
						document.getElementById("4").checked = false;

					} else if (name == 4) {
						document.getElementById('donazione').style.visibility = 'hidden';
						document.getElementById('necessita').style.visibility = 'hidden';
						document.getElementById('promuoviEvento').style.visibility = 'hidden';
						document.getElementById('Indicatore').style.visibility = 'visible';
						document.getElementById("1").checked = false;
						document.getElementById("2").checked = false;
						document.getElementById("3").checked = false;
						document.getElementById("4").checked = true;
					}
				}
			}else if(tipoUtente == "Caritas"){
				if (!hidden) {
					if(name == 4){
						document.getElementById('Indicatore').style.visibility = 'visible';
						document.getElementById("4").checked = true;
					}
				}
				
			}
			processCheck(checkbox);
		}



	</script>


			<!-- Option 1: Bootstrap Bundle with Popper -->
			<script
				src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
				integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
				crossorigin="anonymous"></script>

	

</body>
</html>