<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List,br.com.projeto.app.ConstantesApp"%>

<nav class="navbar navbar-expand-lg navbar-dark bg-danger sticky-top">
	<a href="/site-artesanato" class="navbar-brand">
	<img src="${ConstantesApp.LOGO }" height="30" alt="Lu's Arte">
	</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active"><a class="nav-link"
				href="/site-artesanato/entrada?acao=Home">Home <span
					class="sr-only">(current)</span>
			</a></li>
			<li class="nav-item dropdown"><a class="nav-link dropdown-toggle"
				href="#" id="navbarCategoira" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
				Categorias</a>
				<div class="dropdown-menu" aria-labelledby="navbarCategoria">
          			<a class="dropdown-item" href="/site-artesanato/entrada?acao=ListaCategorias">Listar</a>
          			<a class="dropdown-item" href="/site-artesanato/entrada?acao=NovaCategoriaForm">Adicionar</a>
        		</div>
			</li>
			<li class="nav-item dropdown"><a class="nav-link dropdown-toggle"
				href="#" id="navbarProduto" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
				Produtos</a>
				<div class="dropdown-menu" aria-labelledby="navbarProduto">
          			<a class="dropdown-item" href="/site-artesanato/entrada?acao=ListaProdutos">Listar</a>
          			<a class="dropdown-item" href="/site-artesanato/entrada?acao=NovoProdutoForm">Adicionar</a>
        		</div>
			</li>
		</ul>
		<span class="navbar-text">Usu�rio: ${usuarioLogado.nome}</span>
		<c:import url="logout-parcial.jsp"/>
	</div>
</nav>