<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:url value="/entrada" var="linkEntradaServlet" />

<c:import url="cabecalho.jsp"></c:import>
<c:import url="menu.jsp"></c:import>

	<form action="${linkEntradaServlet }" method="post">
		<div class="form-group">
		<label for="nomeCategoria">Nome da categoria</label> 
		<input type="text" class="form-control" id="nomeCategoria" name="nome_categoria"/>
	</div>	
		<input type="hidden" name="acao" value="NovaCategoria" /> 
		<button type="submit" class="btn btn-success">Salvar</button>
		<a class="btn btn-secondary" href="${linkEntradaServlet }?acao=ListaCategorias" role="button">Voltar</a> 
	</form>

<c:import url="rodape.jsp"></c:import>