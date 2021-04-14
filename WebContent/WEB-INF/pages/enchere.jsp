<!DOCTYPE html>
<html>
<%@include file="templates/head.jspf" %>
<body>
<%@include file="templates/header.jspf" %>
<div class="col-md-12 col-center">
    <H1 class="border-bottom">Detail de la vente</H1>
</div>
<div class="row">
    <div class="col-md-4 col-center mt-3">
        <img src="resources/img/img_article/article_${requestScope.article.noArticle}.jpg" width="200" height="200">
    </div>
    <div class="col-md-6 mt-2 px-5">
        <div class="row">
            <H3 class="font-weight-bold">${requestScope.article.nomArticle}</H3>
        </div>
        <div class="row">
            <div class="col">
                <p class="font-weight-bold"> Description : </p>
            </div>
            <div class="col">
                <p>${requestScope.article.description}</p>
            </div>
        </div>
        <div class="row">
            <div class="col">
                <p class="font-weight-bold"> Categorie : </p>
            </div>
            <div class="col">
                <p>${requestScope.article.categorie.libelle}</p>
            </div>
        </div>
        <div class="row">
            <div class="col">
                <p class="font-weight-bold"> Meilleure Offre : </p>
            </div>
            <div class="col">
                <p>${requestScope.meilleure_offre.montantEnchere} par ${requestScope.meilleure_offre.utilisateur.pseudo}</p>
            </div>
        </div>
        <div class="row">
            <div class="col">
                <p class="font-weight-bold"> Mise � Prix : </p>
            </div>
            <div class="col">
                <p>${requestScope.article.miseAPrix}</p>
            </div>
        </div>
        <div class="row">
            <div class="col">
                <p class="font-weight-bold"> Fin de l'ench�re: </p>
            </div>
            <div class="col">
                <p>${requestScope.article.dateFinEncheres}</p>
            </div>
        </div>
        <div class="row">
            <div class="col">
                <p class="font-weight-bold"> Retrait: </p>
            </div>
            <div class="col">
                <c:if test="${not empty requestScope.article.retrait}">
                    <div class="row">
                        <p>${requestScope.article.retrait.rue}</p>
                    </div>
                    <div class="row">
                        <p>${requestScope.article.retrait.codePostal} ${requestScope.article.retrait.ville}</p>
                        <p>${requestScope.article.retrait.codePostal} ${requestScope.article.retrait.ville}</p>
                    </div>
                </c:if>

                <c:if test="${empty requestScope.article.retrait}">
                    <div class="row">
                        <p>${requestScope.article.utilisateur.rue}</p>
                    </div>
                    <div class="row">
                        <p>${requestScope.article.utilisateur.codePostal} ${requestScope.article.utilisateur.ville}</p>
                    </div>
                </c:if>
            </div>
        </div>
        <div class="row">
            <div class="col">
                <p class="font-weight-bold"> Vendeur: </p>
            </div>
            <div class="col">
                <p>${requestScope.article.utilisateur.nom}</p>
            </div>
        </div>
        <div class="row">
            <div class="col-6">
                <p class="font-weight-bold"> Ma proposition: </p>
            </div>
            <div class="col">
                <input id=montant type=number min="${requestScope.meilleure_offre.montantEnchere + 1}"
                       max="${sessionScope.user.credit}" value="${requestScope.meilleure_offre.montantEnchere + 1}" size="5">
            </div>
            <div class="col">
                <button type="button" class="btn btn-dark">Ench�rir</button>
            </div>
        </div>
        <div class="row">
        </div>
    </div>
</div>
</body>
</html>