
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url value="/entrada" var="linkEntradaServlet" />
<!-- Modal alteraCategoria -->
<div class="modal fade"
	id="alteraCategoria_<c:out value="${param.id_categoria}"/>"
	tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
	aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Edição de
					categoria</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<form action="${linkEntradaServlet}" method="post"
					name="editaCategoria_<c:out value="${param.id_categoria}"/>">
					<div class="form-group">
						<label for="nomeCategoria">Nome da categoria</label> <input
							type="text" class="form-control" id="nomeCategoria" name="nome"
							value="<c:out value="${param.nome_categoria}"/>" />
					</div>
					<input type="hidden" name="id"
						value="<c:out value="${param.id_categoria}"/>" /> <input
						type="hidden" name="acao" value="AlteraCategoria" />
					<button
						name="editaCategoria_<c:out value="${param.id_categoria}"/>"
						type="submit" class="btn btn-success">Salvar</button>

					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Voltar</button>
				</form>
			</div>
		</div>
	</div>
</div>