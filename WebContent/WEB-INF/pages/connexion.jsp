<!DOCTYPE html>
<html>
<%@include file="templates/head.jspf"%>
<body>
<%@include file="templates/header.jspf"%>
<div class="bloc-connection">
	<div class="container align-items-center">
		<div class="row">
            <div class="col-md-6 login-form">
                <h3>Se connecter</h3>
                <form method="POST" action="${pageContext.request.contextPath}/connexion">
                    <div class="form-group">
                        <input type="text" class="form-control" name="login" placeholder="Pseudo ou Email *" value="" required/>
                    </div>
                    <div class="form-group">
                        <input type="password" class="form-control" name="password" placeholder="Mot de passe *" value="" required/>
                    </div>
                    <div class="form-group forgot-remember">
                        <div class="forgot-password">
                        	<a href="#" class="ForgetPwd">Mot de passe oublié?</a>
                        </div>
                        <div class="remember-me">
                        	<input type="checkbox" class="form-check-input" id="resterConnecte">
	                        <label class="form-check-label" for="resterConnecte">Se souvenir de moi</label>
                        </div>
                    </div>
				  	<div class="form-group" style="margin-top: 40px;">
                        <button type="submit" class="btn btn-primary w-100">Connexion</button>
                    </div>
                </form>
                <div class="col-12 d-flex justify-content-center mt-3">
	  				<a href="${pageContext.request.contextPath}/inscription" class="btn btn-secondary w-100">Créer un compte</a>
	  			</div>
            </div>
        </div>
	</div>
</div>
</body>
</html>