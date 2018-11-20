<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ page import="java.util.List,br.com.projeto.modelo.Produto" %>

<c:import url="cabecalho.jsp"></c:import>
<c:import url="menu.jsp"></c:import>

	<h1>Produtos</h1>
	<p><a href="/site-artesanato/entrada?acao=NovoProdutoForm">Novo Produto</a></p>
	<ul>
		<c:forEach items="${produtos}" var="produto">
			<li> 
				${produto.nome_produto } - ${produto.valor_produto }
				<a href="/site-artesanato/entrada?acao=MostraProduto&id=${produto.id_produto}">Mostrar</a> 
				<a href="/site-artesanato/entrada?acao=RemoveProduto&id=${produto.id_produto}">Remover</a> 
			</li>
		</c:forEach>
	</ul>

<c:import url="rodape.jsp"></c:import>