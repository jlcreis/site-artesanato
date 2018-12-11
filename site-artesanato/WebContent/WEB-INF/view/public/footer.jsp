<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List,br.com.projeto.app.ConstantesApp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Footer -->
<footer class="border-top bg-danger pt-4">
	<div class="row">
		<div class="col-md">
			<div class="container-fluid text-center text-white text-md-left">
				<h5 class="text-uppercase">${ConstantesApp.NOME_SITE}</h5>
				<p>Colocar aqui o endereço.</p>
				<p>Colocar aqui os meios de contato.</p>
			</div>
		</div>
		<div class="col-md-auto">
			<div class="container">
				<c:import url="localizacao.html" />
			</div>
		</div>
	</div>

	<!-- Copyright -->
	<div class="footer-copyright text-white text-center border-top py-3">
		© 2018 Copyright: João Luiz</div>
	<!-- Copyright -->

</footer>
<!-- Footer -->