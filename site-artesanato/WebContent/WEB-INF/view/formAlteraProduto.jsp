<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:url value="/entrada" var="linkEntradaServlet" />

<c:import url="cabecalho.jsp"></c:import>
<c:import url="menu.jsp"></c:import>

<style type="text/css">
 	.img{
		object-fit: cover;
		width: auto!important;
		height: 400px; 
		display: block;
	    margin-left: auto;
	    margin-right: auto;
 	}
 	
</style>


<div class="card">
	<div class="card-body">
		<h5 class="card-title">Imagens</h5>
		<!-- Button trigger modal novaImagem -->
		<button type="button" class="btn btn-primary" data-toggle="modal"
			data-target="#novaImagemModal">Adicionar</button>
		<c:forEach items="${listaImagens}" var="img">
		<!-- Button trigger modal ver Imagem -->
			<img data-toggle="modal" data-target="#verImagemModal_${img.nome_img }"
				class="img-thumbnail" alt="imagem" src="img/${img.nome_img }.jpg"
				style="width: 100px; height: 100px;">
			<!-- Modal verImagem -->
			<div class="modal fade" id="verImagemModal_${img.nome_img }" tabindex="-1"
				role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
				<div class="modal-dialog modal-lg" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="exampleModalLabel">Imagem: ${img.nome_img }</h5>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<div class="modal-body">
							<img class="img" alt="imagem"
								src="img/${img.nome_img }.jpg">
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secundary"
								data-dismiss="modal">Voltar</button>
							<a class="btn btn-danger" role="button"
								href="/site-artesanato/entrada?acao=RemoveImagemProduto&id_img=${img.id_img}&nome=${img.nome_img }&id=${produto.id_produto}">Remover</a>
						</div>
					</div>
				</div>
			</div>
			</c:forEach>
	</div>
</div>



<!-- Modal novaImagem -->
<div class="modal fade" id="novaImagemModal" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<form action="upload" method="post" name="salvaImagem"
				enctype="multipart/form-data">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Nova imagem:</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<p>
						<input type="file" name="${produto.id_produto}" accept="image/jpg" />
					</p>
				</div>
				<div class="modal-footer">
					<button type="submit" name="salvaImagem" class="btn btn-success">Salvar</button>
					<button type="button" class="btn btn-secundary"
						data-dismiss="modal">Cancelar</button>
				</div>
			</form>
		</div>
	</div>
</div>

<div class="card">
	<div class="card-body">
		<form action="${linkEntradaServlet}" method="post">
			<div class="form-group">
				<label for="nomeProduto">Nome</label> <input type="text"
					class="form-control" id="nomeProduto" name="nome"
					value="${produto.nome_produto}" />
			</div>
			<div class="form-group">
				<label for="descricaoProduto">Descrição</label>
				<textarea class="form-control" id="descricaoProduto"
					name="descricao">${produto.descricao_produto}</textarea>
			</div>
			<div class="form-group">
				<label for="valorProduto">Valor</label> <input type="text"
					class="form-control" id="valorProduto" name="valor"
					value="${produto.valor_produto}" />
			</div>
			<div class="form-group">
				<label for="categoriaProduto">Categoria</label> <select
					class="custom-select" id="categoriaProduto" name="categoria">
					<option selected value="${produto.categoria.id_categoria }">${produto.categoria.nome_categoria }</option>
					<c:forEach items="${categorias}" var="categoria">
						<%-- 		  		<c:if test="${categoria.id_categoria == produto.categoria_produto }"> --%>
						<%-- 		  			<option selected value="${produto.categoria.id_categoria }">${produto.categoria.nome_categoria }</option> --%>
						<%-- 		  	</c:if> --%>
						<option value="${categoria.id_categoria }">${categoria.nome_categoria }</option>
					</c:forEach>
				</select>
			</div>
			<input type="hidden" name="id" value="${produto.id_produto }" /> <input
				type="hidden" name="acao" value="AlteraProduto" />
			<button type="submit" class="btn btn-success">Salvar</button>
			<a class="btn btn-secondary"
				href="/site-artesanato/entrada?acao=MostraProduto&id=${produto.id_produto}"
				role="button">Voltar</a>
		</form>
	</div>
</div>


<c:import url="rodape.jsp"></c:import>