<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List,br.com.projeto.modelo.Produto"%>

<c:import url="WEB-INF/view/cabecalho.jsp"></c:import>
<c:import url="WEB-INF/view/menu.jsp"></c:import>

<style type="text/css">

.teste {
	 object-fit:cover;
	height: 400px;
}
.teste1{
	width: 600px;
}

</style>

<div id="carouselExampleControls" class="carousel slide teste1" data-ride="carousel">
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img class="d-block w-100  teste" src="img/IMG_20181120_171956_59523.jpg" alt="Primeiro Slide">
    </div>
    <div class="carousel-item">
      <img class="d-block w-100  teste" src="img/IMG_20181120_172001_16050.jpg" alt="Segundo Slide">
    </div>
    <div class="carousel-item">
      <img class="d-block w-100  teste" src="img/IMG_20181121_104309_72773.jpg" alt="Terceiro Slide">
    </div>
  </div>
  <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="sr-only">Anterior</span>
  </a>
  <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="sr-only">Próximo</span>
  </a>
</div>

<c:import url="WEB-INF/view/rodape.jsp"></c:import>