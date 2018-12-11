<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page import="java.util.List,br.com.projeto.app.ConstantesApp"%>
<c:url value="/entrada" var="linkEntradaServlet" />

<c:import url="public/cabecalho.jsp"></c:import>
<div class="py-5">
<div class="row">
<div class="col-md-4 offset-md-4">
<div class="card bg-danger text-white">
	<div class="card-body">
<%-- 		<h5 class="card-title">${ConstantesApp.NOME_SITE }</h5> --%>
		<img src="img/logo.jpg" class="img-fluid" alt="Responsive image">
		<form action="${linkEntradaServlet }" method="post">
			<div class="form-group">
				<label for="InputEmail">E-mail</label> <input class="form-control"
					type="email" id="InputEmail" name="login" placeholder="E-mail" />
			</div>
			<div class="form-group">
				<label for="InputSenha">Senha</label> <input class="form-control"
					type="password" id="InputSenha" name="senha" placeholder="Senha" />
			</div>
			<input type="hidden" name="acao" value="Login">

			<button type="submit" class="btn btn-primary">Entrar</button>
			<a class="btn btn-secondary" role="button" href="/site-artesanato">Cancelar</a>
		</form>
	</div>
</div>
</div>
</div>
</div>

<c:import url="public/rodape.jsp"></c:import>