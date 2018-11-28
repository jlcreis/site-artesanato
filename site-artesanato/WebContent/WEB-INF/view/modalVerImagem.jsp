<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page import="java.util.List,br.com.projeto.modelo.Imagem"%>
<!-- Modal verImagem -->
<div class="modal fade"
	id="verImagemModal_<c:out value="${param.id_img }"/>" tabindex="-1"
	role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Imagem</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<!-- 				<img class="img-thumbnail" alt="imagem" -->
				<%-- 					src="img/<c:out value="${param.nome_img }"/>.jpg" --%>
				<!-- 					style="width: 200rem;"> -->

				<!-- 				inicio carousel -->
				<div id="carouselExampleControls" class="carousel slide"
					data-ride="carousel">
					<div class="carousel-inner">
						<c:forEach items="${param.listaImagens }" var="imagem">
						<p>${imagem }</p>
<!-- 							<div class="carousel-item active"> -->
<%-- 								<img class="d-block w-100" src="img/${imagem.nome_img}.jpg" alt="Second slide"> --%>
<!-- 							</div> -->
						
						<a class="carousel-control-prev" href="#carouselExampleControls"
							role="button" data-slide="prev"> <span
							class="carousel-control-prev-icon" aria-hidden="true"></span> <span
							class="sr-only">Previous</span>
						</a> <a class="carousel-control-next" href="#carouselExampleControls"
							role="button" data-slide="next"> <span
							class="carousel-control-next-icon" aria-hidden="true"></span> <span
							class="sr-only">Next</span>
						</a>
						</c:forEach>
					</div>
				</div>


				<!-- 					fim carousel -->
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secundary" data-dismiss="modal">Voltar</button>
			</div>
		</div>
	</div>
</div>