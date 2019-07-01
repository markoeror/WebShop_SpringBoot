<%@page import="com.comtrade.entity.Kategorije"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<fieldset>
		<legend>Kreiraj Kategoriju</legend>
		
		<form:form action="/kategorija/kreiraj" modelAttribute="kategorija"
			method="post">

			<tr>
			<td>Naziv <form:input path="naziv" /></td>
			<br>

			<td><input type="submit" value="Kreiraj kategoriju"></td>
			<br>

			</tr>



		</form:form>
	</fieldset>

	<fieldset>
		<legend>Lista Kategorija</legend>

		<table>
		
		<%List<Kategorije> listaKategorija=(List<Kategorije>) request.getAttribute("listaKategorija"); %>
		<select name="listaKategorija">
		<%for(Kategorije temp:listaKategorija) {%>
		<option value="<%=temp.getId()%>"><%=temp.getNaziv() %></option>
		
		<%}%>
		</select>
		</table>






	</fieldset>
</body>
</html>