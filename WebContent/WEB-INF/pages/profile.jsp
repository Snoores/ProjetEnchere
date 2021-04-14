<!DOCTYPE html>
<html>
<head>
    <%@include file="templates/head.jspf" %>
<body>
    <%@include file="templates/header.jspf" %>
    <div class="bloc-profile">
		<div class="container align-items-center">
			<div class="col-md-12 col-center">
	                <h3 class="h3-my-profile">Mon profile</h3>
                	<ul class="ul-my-profile">
                		<li>Pseudo : william-penna</li>
                		<li>Nom : Pennaneach</li>
                		<li>Prénom : William</li>
                		<li>Email : w.pennaneach@test.fr</li>
                		<li>Téléphone : 0606060606</li>
                		<li>Rue : le test</li>
                		<li>Code postal : 29500</li>
                		<li>Ville : Ergué Gabéric</li>
                	</ul>
	                 <div class="col-12 d-flex justify-content-center mt-3">
		  				<a href="${pageContext.request.contextPath}/modifier-profile" class="btn btn-secondary btn-modifier-profiles">Modifier</a>
		  			</div>
	        </div>
	    </div>
	</div>
</body>
</html>