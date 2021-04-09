<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="fr">
<%@include file="templates/head.jspf"%>
	<body class="m-2">
		<div class="bloc-home container align-items-center">
			<!-- <div class="container"> -->
				<div class="nav-center">
					<h1 class="h1-accueil">Enchères</h1>
					<img src="https://www.legalia.fr/wp-content/uploads/sites/2084/2016/12/enchere.png" height="300" width="300">
				</div>
					
				<div class="col-md-12 col-center">
					<div class="liste-encheres" style="margin-bottom:50px">
						<h2>Listes des enchères :</h2>
					</div>
					<div class="connection-btn">
						<a class="btn btn-primary" href="${pageContext.request.contextPath}/connection">Connexion</a>
						<a class="btn btn-secondary">Déconnection</a>
					</div>
				</div>
<!-- 		</div>
 -->		</div>
	</body>
</html>
<style><%@include file="/css/style.css"%></style>