<!DOCTYPE html>
<html>
<meta http-equiv="refresh" content="5;url=${pageContext.request.contextPath}/accueil" />

<%@include file="templates/head.jspf"%>

<body>
	<%@include file="templates/header.jspf"%>

	<div class="col-12 d-flex justify-content-center mt-3">
		<h1>Vous avez bien été déconnecté du site</h1>
	</div>
	<div class="col-12 d-flex justify-content-center mt-3">
		<div h3> Vous allez être redirigé vers la page d'accueil </div>
	</div>
	<div class="col-12 d-flex justify-content-center mt-3">
		<p>Si la redirection ne marche pas, cliquez sur ce <a href="${pageContext.request.contextPath}/accueil">lien</a></p>
	</div>

</body>
</html>