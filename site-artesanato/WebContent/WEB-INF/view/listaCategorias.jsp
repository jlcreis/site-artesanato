<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ page import="java.util.List,br.com.projeto.modelo.Categoria"%>


<c:import url="cabecalho.jsp"></c:import>
<c:import url="menu.jsp"></c:import>

<div class="row align-items-center">
	<div class="col">
		<h1 class="display-4">Categorias</h1>
	</div>
	<div class="col-6">
	${mensagem }
		<c:if test="${mensagem != null}">
			<div class="alert alert-info" role="alert">${mensagem }</div>
		</c:if>
	</div>
	<div class="col">
		<ul class="nav justify-content-end">
			<li class="nav-item">
				<!-- Modal Button novaCategoria -->
				<button type="button" class="btn btn-outline-secondary" data-toggle="modal"
					data-target="#novaCategoria">Adicionar Categoria</button> <c:import
					url="modalNovaCategoria.jsp"></c:import>
			</li>
		</ul>
	</div>
</div>

<ul class="list-group">
	<c:forEach items="${categorias}" var="categoria">
		<li class="list-group-item"><span class="lead">${categoria.nome_categoria }</span>
			<div class="btn-group float-right">
				<!-- Modal Button alteraCategoria -->
				<button type="button" class="btn btn-outline-secondary btn-sm"
					data-toggle="modal"
					data-target="#alteraCategoria_${categoria.id_categoria}">
					Editar</button>
				<!-- Modal Button removeCategoria -->
				<button type="button" class="btn btn-outline-secondary btn-sm"
					data-toggle="modal"
					data-target="#removeCategoria_${categoria.id_categoria}">
					Remover</button>
			</div>
		</li>
		<c:import url="modalAlteraCategoria.jsp" charEncoding="UTF-8">
			<c:param name="nome_categoria" value="${categoria.nome_categoria}" />
			<c:param name="id_categoria" value="${categoria.id_categoria}" />
		</c:import>
		<!-- Modal removeCategoria -->
		<div class="modal fade" id="removeCategoria_${categoria.id_categoria}"
			tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
			aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">Atenção!</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						Tem certeza que deseja remover a categoria <strong>${categoria.nome_categoria }</strong>
						?
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Não</button>
						<a class="btn btn-danger" role="button"
							href="/site-artesanato/entrada?acao=RemoveCategoria&id=${categoria.id_categoria}">Sim</a>
					</div>
				</div>
			</div>
		</div>
	</c:forEach>
</ul>

<c:import url="rodape.jsp"></c:import>