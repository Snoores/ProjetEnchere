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
									        </ul>
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
	$('.btn-search').on("click", function(e){
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
</script>