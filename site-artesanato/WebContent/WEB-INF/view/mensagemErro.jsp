<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="cabecalho.jsp"></c:import>
<c:import url="menu.jsp"></c:import>

<div class="container">
<div class="alert alert-warning" role="alert">
  <h4 class="alert-heading">Erro</h4>
  <p>${mensagem }</p>
  <hr>
  <p class="mb-0"><a href="/site-artesanato/entrada?acao=ListaCategorias">Voltar</a></p>
</div>
</div>

<%-- <c:import url="public/footer.jsp"></c:import> --%>
<c:import url="rodape.jsp"></c:import>