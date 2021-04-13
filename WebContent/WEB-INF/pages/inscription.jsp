<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   

<!DOCTYPE html>
<html>
<%@include file="templates/head.jspf"%>
<body>
<%@include file="templates/header.jspf"%>
<div class="bloc-inscription">
	<div class="container align-items-center">
		<div class="row">
            <div class="col-md-6 login-form">
                <h3>Créer un compte</h3>
                <form method="POST" action="${pageContext.request.contextPath}/inscription">
                    <div class="form-group">
                        <input type="text" class="form-control" name="login" placeholder="Pseudo *" value="" required/>
                    </div>
                    <div class="form-group">
                        <input type="text" class="form-control" name="nom" placeholder="Nom *" value="" required/>
                    </div>
                    <div class="form-group">
                        <input type="text" class="form-control" name="prenom" placeholder="Prénom *" value="" required/>
                    </div>
                    <div class="form-group">
                        <input type="email" class="form-control" name="email" placeholder="Email *" value="" required/>
                    </div>
                    <div class="form-group">
                        <input type="phone" class="form-control" name="telephone" placeholder="Téléphone *" value="" required/>
                    </div>
                    <div class="form-group">
                        <input type="text" class="form-control" name="rue" placeholder="Rue *" value="" required/>
                    </div>
                    <div class="form-group">
                        <input type="text" class="form-control" name="code-postal" placeholder="Code Postal *" value="" required/>
                    </div>
                    <div class="form-group">
                        <input type="text" class="form-control" name="ville" placeholder="Ville *" value="" required/>
                    </div>
                    <div class="form-group">
                        <input type="password" class="form-control" name="mdp" placeholder="Mot de passe *" value="" required/>
                    </div>
                    <div class="form-group">
                        <input type="password" class="form-control" name="mdp-confirmation" placeholder="Confirmer votre mot de passe *" value="" required/>
                    </div>
				  	<div class="form-group" style="margin-top: 40px;">
                        <button type="submit" class="btn btn-primary w-100">Inscription</button>
                    </div>
                </form>
            </div>
        </div>
	</div>
</div>
</body>
</html>