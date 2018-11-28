<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:url value="/entrada" var="linkEntradaServlet" />

<c:import url="cabecalho.jsp"></c:import>
<c:import url="menu.jsp"></c:import>

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
					<button type="button" class="btn btn-secundary"
						data-dismiss="modal">Cancelar</button>
					<button type="submit" name="salvaImagem" class="btn btn-success">Salvar</button>
				</div>
			</form>
		</div>
	</div>
</div>



	<c:forEach items="${listaImagens}" var="img">
    	<p><img alt="imagem" src="img/${img.nome_img }.jpg" style="width: 100px;">
    	
    	<a href="/site-artesanato/entrada?acao=RemoveImagemProduto&id_img=${img.id_img}&nome=${img.nome_img }&id=${id_produto}">X</a></p> 
    	
    </c:forEach>

	<form action="upload" method="post" enctype="multipart/form-data">
		<p>Nova Imagem: <input type="file" name="${id_produto}" accept="image/jpg"/></p>
		<input type="submit"/>
		
		<a href="/site-artesanato/entrada?acao=MostraProduto&id=${id_produto}">Ver Produto</a> 
	</form>
	    
<c:import url="rodape.jsp"></c:import>