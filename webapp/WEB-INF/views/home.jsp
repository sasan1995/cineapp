<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<spring:url value="/resources" var="urlPublic" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bienvenido a Cineapp</title>
</head>
<body>
	<%--
		<h1>Lista de Peliculas</h1>

	<ol>
		<c:forEach items="${peliculas }" var="pelicula">
			<li>${pelicula }</li>
		</c:forEach>
	</ol>
	 --%>

	<div class="card">
		<div class="card-header">Lista de Peliulas</div>
		<div class="card-body">

			<table class="table table-striped table-bordered table-hover">
				<thead>
					<tr>
						<th>Id</th>
						<th>Titulo</th>
						<th>Duracion</th>
						<th>Clasificacion</th>
						<th>Genero</th>
						<th>imagen</th>
						<th>Fecha de estreno</th>
						<th>estatus</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${peliculas }" var="pelicula">
						<tr>
							<td>${pelicula.id}</td>
							<td>${pelicula.titulo}</td>
							<td>${pelicula.duracion}</td>
							<td>${pelicula.clasificacion}</td>
							<td>${pelicula.genero}</td>
							<td><img src="${urlPublic}/images/${pelicula.imagen}"></td>
							<td><fmt:formatDate value="${pelicula.fechaEstreno}"
									pattern=" dd-MM-yyyy" /></td>
							<td>
								<c:choose>
									<c:when test="${pelicula.estatus=='Activa'}">
										<span class="badge badge-success">Activa</span>
									</c:when>
									<c:otherwise>
										<span class="badge badge-danger">Inactiva</span>
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

</body>
</html>