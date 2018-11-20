<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url value="/entrada" var="linkEntradaServlet" />
<!-- Modal novaCategoria -->
<div class="modal fade" id="novaCategoria" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Adicionar
					Categoria</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<form action="${linkEntradaServlet }" method="post">
					<div class="form-group">
						<label for="nomeCategoria">Nome da categoria</label> <input
							type="text" class="form-control" id="nomeCategoria"
							name="nome_categoria" />
					</div>
					<input type="hidden" name="acao" value="NovaCategoria" />
					<div class="float-right">
						<button type="submit" class="btn btn-success">Salvar</button>
						<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Voltar</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>