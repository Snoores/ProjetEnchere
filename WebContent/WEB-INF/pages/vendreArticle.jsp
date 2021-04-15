<!DOCTYPE html>
<html>
<%@include file="templates/head.jspf" %>
	<body>
		<%@include file="templates/header.jspf" %>
		<div class="bloc-vente">
			<div class="container align-items-center">
				<div class="row">
					<div class="col-md-6">
		            	<img src="http://bit.ly/2tMBBTd">
		            </div>
		            <div class="col-md-6">
		                <h3>Nouvelle vente</h3>
		                <form method="POST" action="${pageContext.request.contextPath}/vendre_article">
		                    <div class="form-group">
		                        <input type="text" class="form-control" name="article" placeholder="Article *" value="" required/>
		                    </div>
		                    <div class="form-group">
		                        <input type="text-area" class="form-control" name="description" placeholder="Description *" value="" required/>
		                    </div>
		                    <div class="form-group">
		                        <select class="form-select select-option" name="categorie">
									  <option hidden selected value="">Choisir une catégorie</option>
									<c:forEach var="categorie" items="${categories }">
									  <option value="${categorie.libelle }">${categorie.libelle }</option>
									</c:forEach>
								</select>
		                    </div>
		                    <div class="form-group">
		                       <label for="photo">Choisir une image:</label>
		
								<input type="file" name="photo" accept="image/png, image/jpeg" value="">
		                    </div>
		                    <div class="form-group">
		                    	<label for="photo">Mise a prix :</label>
		                        <input id=montant type=number value="" size="5" name="miseAPrix">
		                    </div>
		                    <div class="form-group">
		                        <input type="date" class="form-control" name="dateDebut" value="" required/>
		                    </div>
		                    <div class="form-group">
		                        <input type="date" class="form-control" name="dateFin" value="" required/>
		                    </div>
		                    <div class="retrait-article">
		                    	<p>Retrait : </p>
			                    <div class="form-group">
			                        <input type="text" class="form-control" name="rue" placeholder="Rue *" value="${pageContext.session.getAttribute('user').rue}" required/>
			                    </div>
			                    <div class="form-group">
			                        <input type="text" class="form-control" name="codePostal" placeholder="Pode postal *" value="${pageContext.session.getAttribute('user').codePostal}" required/>
			                    </div>
			                    <div class="form-group">
			                        <input type="text" class="form-control" name="ville" placeholder="Ville *" value="${pageContext.session.getAttribute('user').ville}" required/>
			                    </div>
			                </div>
						  	<div class="form-group form btn" style="margin-top: 20px;">
		                        <button type="submit" class="btn btn-primary w-50">Enregistrer</button>
		                        <a class="btn btn-secondary w-50 btn-annuler">Annuler</a>
		                    </div>
		                </form>
		            </div>
		        </div>
			</div>
		</div>
	</body>
</html>

<script>
	$('.btn-annuler').on("click", function(){
		$('input').val('');
	});
</script>