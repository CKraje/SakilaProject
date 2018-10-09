<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<form action="search-films">
			<input type="text" name="film_Name" placeholder="inserisci nome film">
			<button type="submit">Search Films by name</button>
		</form>
		<form action="actors-search">
			<input type="text" name="actorLastName"
				placeholder="inserisci cognome attore">
			<button type="submit">Search Actors</button>
		</form>
		<form action="categories-films">
			<select name="Genres">
				<c:forEach items="${listaCategoriesFilms}" var="categoria">
					<option ${categoria.categoryId == categoryId ? "selected":"" }
						value="${categoria.categoryId}">${categoria.name}</option>
				</c:forEach>
			</select>
			<button type="submit">Search Films By Category</button>
		</form>
	<c:if test="${!empty actorList }">
		<c:forEach items="${actorList}" var="attore">
			<a href="actors-films?actorId=${attore.actorId}">${attore.firstName}
				&nbsp;&nbsp; ${attore.lastName}</a>
			<br>
		</c:forEach>
	</c:if>
	<c:if test="${!empty listaFilms }">
	<table>
	<tr><td> Film Name</td><td>Film Description</td><td>Release Year</td></tr>
		<c:forEach items="${listaFilms}" var="film">
			<tr><td><a href="films-actors?filmId=${film.filmId}">${film.title}</a></td>
			<td>${film.description}</td><td>${film.releaseYear}</td></tr>
		</c:forEach>
		</table>
	</c:if>
</body>
</html>