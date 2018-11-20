<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:url value="/entrada" var="linkEntradaServlet" />

<c:import url="cabecalho.jsp"></c:import>
<c:import url="menu.jsp"></c:import>

<a class="btn btn-primary" href="/site-artesanato/entrada?acao=NovaImagemForm&id=${produto.id_produto}" role="button">Editar Imagens</a> 

	<form action="${linkEntradaServlet}" method="post">
	<div class="form-group">
		<label for="nomeProduto">Nome</label> 
		<input type="text" class="form-control" id="nomeProduto" name="nome" value="${produto.nome_produto}"/>
	</div>	
	<div class="form-group">
		<label for="descricaoProduto">Descrição</label> 
		<textarea class="form-control" id="descricaoProduto"  name="descricao">${produto.descricao_produto}</textarea>
	</div>
	<div class="form-group">
		<label for="valorProduto">Valor</label> 
		<input type="text" class="form-control" id="valorProduto" name="valor" value="${produto.valor_produto}"/>
	</div>
	<div class="form-group">
		<label for="categoriaProduto">Categoria</label> 
		<select class="custom-select" id="categoriaProduto" name="categoria">
		  	<c:forEach items="${categorias}" var="categoria">
		  		<c:if test="${categoria.id_categoria == produto.categoria_produto }">
		  			<option selected value="${categoria.id_categoria }">${categoria.nome_categoria }</option>
		  	</c:if>
		  		<option value="${categoria.id_categoria }">${categoria.nome_categoria }</option>
		  </c:forEach>
		</select>
	</div>		
		<input type="hidden" name="id" value="${produto.id_produto }" />
		<input type="hidden" name="acao" value="AlteraProduto" />
		<button type="submit" class="btn btn-success">Salvar</button>
		<a class="btn btn-secondary" href="/site-artesanato/entrada?acao=MostraProduto&id=${produto.id_produto}" role="button">Voltar</a> 
	</form>
		
	

<c:import url="rodape.jsp"></c:import>