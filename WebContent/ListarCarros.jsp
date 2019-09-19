<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="Conexao.*, Model.Carro, java.util.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
		<title>Listagem de Carros</title>
	</head>
	<body>
		<div align="center">
			
			<table border="1">
			
			<tr>
				<th>Id</th>
				<th>Nome</th>
				<th>Placa</th>
				
				<th>...</th>
			</tr>
	
			<%
				
				List<Carro> carros = (List<Carro>)request.getAttribute("listaCarros");
				
				for (Carro c : carros)
				{
			%>
				<tr>
					<td>
						<%= c.getId() %>
					</td>
					<td>
						<%= c.getNome() %>
					</td>
					<td>
						<%= c.getPlaca() %>
					</td>
					
				</tr>
				<%
				}
				%>
			</table>
		</div>
		<a href="index.jsp">Home Page</a>
	</body>
</html>