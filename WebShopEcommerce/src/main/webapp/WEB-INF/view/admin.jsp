<%@page import="com.comtrade.service.ArtikalServiceImp"%>
<%@page import="com.comtrade.service.ArtikalService"%>
<%@page import="com.comtrade.entity.Artikal"%>
<%@page import="com.comtrade.entity.Kategorije"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		
	<fieldset>
		<legend>Kreiraj Kategoriju</legend>
		
		<form:form action="/kategorija/kreiraj" modelAttribute="kategorija"
			method="post">
			<tr>
			<td>Naziv <form:input path="naziv" /></td>			
			<td><input type="submit" value="Kreiraj kategoriju"></td>
			</tr>
		</form:form>
	</fieldset>
	
	<fieldset>
		<legend>Kreiraj Artikal</legend>
		
		<table>
			<%List<Kategorije> listaKategorija=(List<Kategorije>) request.getAttribute("listaKategorija"); %>
			<form:form action="/artikal/kreiraj" modelAttribute="artikal" method="post" enctype="multipart/form-data">
			<input type="hidden" id="id" name="idKat" value="1" >
			<tr>
			<td><select name="tipKategorije"  id="categoryComboBox" onchange="findIdCombo()" >
			<%for(Kategorije temp:listaKategorija) {%>
			<option value="<%=temp.getId()%>"><%=temp.getNaziv() %></option>		
			<%}%>
			</select>	</td>
			<td>Naziv <form:input path="naziv" /></td>
			<td>Cena <form:input path="cena" /></td>		
			<td>BarKod <form:input path="barkod" /></td>
			<td><input type="file" name="file">				
			<td><input type="submit" value="Kreiraj artikal" ></td>
			</tr>

	<%-- 	<form:select path="kategorija" onclick="kategorija/" >
   	 	<form:options items="${listaKategorija}"  itemLabel="naziv" itemValue="id" />
		</form:select>
 --%>
	</form:form>			
</table>
	</fieldset>
	

		<fieldset>
		<legend> Add Product</legend>
		
		<%List<Artikal> listaArtikala= (List<Artikal>) request.getAttribute("listaArtikala"); %>
		<form:form action="/artikal/dodaj" modelAttribute="artikalDodaj" method="post" >
		<input type="hidden" id="idProd" name="idProd" value="1" >
		Izaberite artikal:  <select name="artikalId" id="productComboBox" onchange="findIdComboP() ">	
		<%	for (Artikal a : listaArtikala) {	%>	
		<option value="<%=a.getId()%>" ><%=a.getNaziv()%>		
		</option>
		
		<%}%>
		</select>	
		
		<br>	
		<!-- <input type="text" name="kolicinaA" placeholder="unesite kolicinu"> -->
		
		<td>Kolicina  <form:input path="kolicina" /></td>
		<input type="submit" value="Unesi">
		</form:form>
		</fieldset>




		<%-- <form:form action="/artikal/listaArtikalaZaK" modelAttribute="kategorijaArtikala" method="post" >
		Izaberite kategoriju: 	
		<%	for (Kategorije k : listaKategorija) {	%>	
		<form:hidden path="id" />
		<form:button name="<%=k.getNaziv() %>" value="<%=k.getNaziv() %>"><%=k.getNaziv() %></form:button>
		
		
		
		
		<%}%>
		
		</form:form> --%>

		



	
	<script type="text/javascript">
	function findIdCombo() {
		var id = document.getElementById("categoryComboBox");
		var idCategory = id.options[id.selectedIndex].value;
		document.getElementById("id").value = idCategory;
		console.log(idCategory);}	
	function findIdComboP() {
		var id = document.getElementById("productComboBox");
		var idProduct = id.options[id.selectedIndex].value;
		document.getElementById("idProd").value = idProduct;
		console.log(idProduct);
		/*  alert(idProduct);  */
		
	}
	</script>
	
</body>
</html>