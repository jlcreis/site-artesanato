<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:url value="/entrada" var="linkEntradaServlet" />

<c:import url="cabecalho.jsp"></c:import>
<c:import url="menu.jsp"></c:import>

<div class="card">
	<div class="card-body">
		<form action="${linkEntradaServlet}" method="post" name="novoProduto">
			<div class="form-group">
				<label for="nomeProduto">Nome</label> <input type="text"
					class="form-control" id="nomeProduto" name="nome" />
			</div>
			<div class="form-group">
				<label for="descricaoProduto">Descrição</label>
				<textarea class="form-control" id="descricaoProduto"
					name="descricao"></textarea>
			</div>
			<div class="form-group">
				<label for="valorProduto">Valor</label> <input type="text"
					class="form-control" id="valorProduto" name="valor" />
			</div>
			<div class="form-group">
				<label for="categoriaProduto">Categoria</label> <select
					class="custom-select" id="categoriaProduto" name="categoria">
					<option selected>Selecione uma categoria.</option>
					<c:forEach items="${categorias}" var="categoria">
						<option value="${categoria.id_categoria }">${categoria.nome_categoria }</option>
					</c:forEach>
				</select>
			</div>
			<input type="hidden" name="id" /> <input type="hidden" name="acao"
				value="NovoProduto" />
			<button type="submit" name="novoProduto" class="btn btn-success">Salvar</button>
			<a class="btn btn-secondary"
				href="/site-artesanato/entrada?acao=ListaProdutos"
				role="button">Voltar</a>
		</form>
	</div>
</div>


<c:import url="rodape.jsp"></c:import>