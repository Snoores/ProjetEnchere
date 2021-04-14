<!DOCTYPE html>
<html>
<head>
    <%@include file="templates/head.jspf" %>
<body>
    <%@include file="templates/header.jspf" %>
    <div class="bloc-profile">
		<div class="container align-items-center">
			<div class="col-md-12 col-center">
	                <h3 class="h3-my-profile">Mon profil</h3>
                	<ul class="ul-my-profile">
                		<li>Pseudo : ${requestScope.user_profile.pseudo}</li>
                		<li>Nom : ${requestScope.user_profile.nom}</li>
                		<li>Prénom : ${requestScope.user_profile.prenom}</li>
                		<li>Email : ${requestScope.user_profile.email}</li>
                		<li>Téléphone : ${requestScope.user_profile.telephone}</li>
                		<li>Rue : ${requestScope.user_profile.rue}</li>
                		<li>Code postal : ${requestScope.user_profile.codePostal}</li>
                		<li>Ville : ${requestScope.user_profile.ville}</li>
						<li>Credit : ${requestScope.user_profile.credit}</li>
                	</ul>
				<c:if test="${requestScope.user_profile.noUtilisateur == sessionScope.user.noUtilisateur && sessionScope.user.noUtilisateur != 0}">
	                 <div class="col-12 d-flex justify-content-center mt-3">
		  				<a href="${pageContext.request.contextPath}/modification_profile" class="btn btn-secondary btn-modifier-profiles">Modifier</a>
		  			 </div>
				</c:if>
	        </div>
	    </div>
	</div>
</body>
</html>