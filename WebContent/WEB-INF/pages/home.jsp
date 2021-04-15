<!doctype html>
<html lang="fr">
<%@include file="templates/head.jspf"%>
	<body>
	<%@include file="templates/header.jspf"%>
		<div class="bloc-home container align-items-center">
			<div class="col-md-12 col-center">
			  	<h1>Liste des enchères</h1>
			  	<div class="tbl-content">
			  	<div class="filter">
			  		<div class="col-md-6">
			  			<div class="search-bar">
						  	<div class="form-outline search-bar-input">
						  		<span class="input_icon"><i class="fas fa-search"></i></span>
						    	<input id="search-input" type="search" class="form-control" placeholder="Le nom de l'article contient"/>
						  	</div>
						  </div>
						<select class="form-select select-option" aria-label="Default select example">
							  <option hidden selected value="">Choisir une catégorie</option>
							<c:forEach var="categorie" items="${categories }">
							  <option value="${categorie.libelle }">${categorie.libelle }</option>
							</c:forEach>
						</select>
			  		</div>
			  		<div class="col-md-6">
			  			<a class="btn btn-primary btn-search">Rechercher</a>
			  		</div>
			  	</div>
			  <c:if test="${pageContext.session.getAttribute('user').noUtilisateur != null
                && pageContext.session.getAttribute('session') == 'on'}">
			  	<div class="check-filter">
			  		<div class="col-md-4 col-check">
			  			<div class="check-option-achat">
			  				<input class="form-check-input check-input-achat" type="radio" value="achat" name="filter" checked >
		                    <label class="form-check-label" for="achat-filter">
		                        Achats
		                    </label>
							<div class="check-sous-option">
				  				<input class="input-achat" type="checkbox" name="optAchatEnchO">
								<label class="form-check-label-achat" for="optEnchO">Enchères ouvertes</label>
							</div>
							<div class="check-sous-option">
				  				<input class="input-achat" type="checkbox" name="optAchatEnchEC">
								<label class="form-check-label-achat" for="optEnchEC">Mes enchères en cours</label>
							</div>
                        	<div class="check-sous-option">
                        		<input class="input-achat" type="checkbox" name="optAchatEnchR">
								<label class="form-check-label-achat" for="optEnchR"> Mes enchères en remportées</label>
                        	</div>
			  			</div>
			  		</div>
			  		<div class="col-md-4 col-check">
			  			<div class="check-option-vente">
		  					<input class="form-check-input check-input-vente" type="radio" value="enchere" name="filter">
		                    <label class="form-check-label" for="vente-filter" >
		                        Mes ventes
		                    </label>
		                    <div class="check-sous-option">
	                            <input class="input-vente" type="checkbox" name="opVentetEnchO" disabled>
	                            <label class="form-check-label-vente">
	                                Enchères ouvertes
	                            </label>
                        	</div>
                        	<div class="check-sous-option">
	                            <input class="input-vente" type="checkbox" name="opVentetEnchEC" disabled>
	                            <label class="form-check-label-vente">
	                                Mes enchères en cours
	                            </label>
                        	</div>
                        	<div class="check-sous-option">
	                            <input class="input-vente" type="checkbox" name="opVentetEnchR" disabled>
	                            <label class="form-check-label-vente">
	                                Mes enchères en remportées
	                            </label>
                        	</div>
			  			</div>
			  		</div>	
			  	</div>
			</c:if>
			  	<div class="products">
			  		<div class="container">
			  			<div class="row">
			  				<c:forEach var="enchere" items="${encheres }">
							  	<div class="col-md-6 product-identity ${fn:replace(enchere.articleVendu.nomArticle,' ', '_')} ${fn:replace(enchere.articleVendu.categorie.libelle,' ', '_')}">
							  		<div class="wrapper">
									    <div class="product-img">
									      <img src="http://bit.ly/2tMBBTd" height="320" width="227">
									    </div>
									    <div class="product-info">
									      <div class="product-text">
									        <h1 class="name-product">${enchere.articleVendu.nomArticle }</h1>
									        <ul class="description-product">
									        	<li>Prix: ${enchere.montantEnchere } points</li>
									        	<fmt:parseDate value="${enchere.articleVendu.dateFinEncheres }" pattern="yyyy-MM-dd" var="parsedDate" type="date" />
												<fmt:formatDate value="${parsedDate}" var="newParsedDate" type="date" pattern="dd/MM/yyyy" />
									        	<li>Fin de l'enchere: ${newParsedDate }</li>
									        	<li>Vendeur: ${enchere.utilisateur.nom }</li>
									        	<c:if test="${enchere.articleVendu.etatVente == 'CR'}">
									        		<li>Enchère créée</li>
									        	</c:if>
									        	<c:if test="${enchere.articleVendu.etatVente == 'EC'}">
									        		<li>Enchère en cours</li>
									        	</c:if>
									        	<c:if test="${enchere.articleVendu.etatVente == 'TE'}">
									        		<li>Enchère terminée</li>
									        	</c:if>
									        	<c:if test="${enchere.articleVendu.etatVente == 'RE'}">
									        		<li>Retrait effectué</li>
									        	</c:if>
									        </ul>
									        <c:if test="${pageContext.session.getAttribute('user').noUtilisateur != null && pageContext.session.getAttribute('session') == 'on'}">
									        	<a class="text-center" href="${pageContext.request.contextPath}/enchere?id=${enchere.articleVendu.noArticle}"><button class="btn btn-primary mb-3">Voir l'enchère</button></a>
									      	</c:if>
									      </div>
									    </div>
									  </div>
							  	</div>
							</c:forEach>
						</div>
					</div>
				 </div>
			</div>
		</div>
	</body>
</html>
<script>
	$('.btn-search').on("click", function(){
		$(".product-identity").css("display","none");
		
		var search = $('#search-input').val();
		search = search.replace(" ","_");
		var categorie = $('.select-option').val();
		categorie = categorie.replace(" ","_");
		
		console.log(search);
		if(search == '' && categorie == ''){
			$(".product-identity").css("display","block");
		}else if(search != '' && categorie == ''){
			$(".product-identity[class*="+search+"]").css("display","block");
		}else if(search == '' && categorie != ''){
			$(".product-identity[class*="+categorie+"]").css("display","block");
		}else if(search != '' && categorie != ''){
			$(".product-identity[class*="+search+"]").css("display","block");
			$(".product-identity[class*="+categorie+"]").css("display","block");
		}
	});
	
	$('.check-input-achat').on("click", function(){
		console.log("achat");
		$('.input-vente').prop( "disabled", true );
		$('.input-achat').prop( "disabled", false );
		$('.input-vente').prop( "checked", false );
		$('.form-check-label-achat').css("opacity","1");
		$('.form-check-label-vente').css("opacity","0.5");
	});
	
	$('.check-input-vente').on("click", function(){
		console.log("vente");
		$('.input-vente').prop( "disabled", false );
		$('.input-achat').prop( "disabled", true );
		$('.input-achat').prop( "checked", false );
		$('.form-check-label-achat').css("opacity","0.5");
		$('.form-check-label-vente').css("opacity","1");
	});
</script>