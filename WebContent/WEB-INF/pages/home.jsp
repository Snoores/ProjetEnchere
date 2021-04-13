<!doctype html>
<html lang="fr">
<%@include file="templates/head.jspf"%>
	<body>
	<%@include file="templates/header.jspf"%>
		<div class="bloc-home container align-items-center">
			<div class="col-md-12 col-center">
			  	<h1>Liste des enchères</h1>
			  	<div class="tbl-header">
			    	<table cellpadding="0" cellspacing="0" border="0">
			      		<thead>
					        <tr>
					          	<th>Nom de l'encherisseur</th>
						        <th>Article</th>
						        <th>Début de l'enchère</th>
						        <th>Fin de l'enchère</th>
						        <th>Prix initial</th>
						        <th>Montant de l'enchère</th>
			        		</tr>
			      		</thead>
			    	</table>
			  	</div>
			  	<div class="tbl-content">
			    	<table cellpadding="0" cellspacing="0" border="0">
			      		<tbody>
			      			<c:forEach var="enchere" items="${encheres }">
						        <tr>
							        <td>${enchere.utilisateur.nom }</td>
							        <td>${enchere.articleVendu.nomArticle }</td>
							        <td>${enchere.articleVendu.dateDebutEncheres }</td>
							        <td>${enchere.articleVendu.dateFinEncheres }</td>
							        <td>${enchere.articleVendu.miseAPrix }</td>
							        <td>${enchere.montantEnchere }</td>
						        </tr>
				    		</c:forEach>
			      		</tbody>
			    	</table>
			  	</div>
			</div>
		</div>
	</body>
</html>