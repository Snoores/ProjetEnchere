<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<%@include file="templates/head.jspf"%>
<body>
<div class="bloc-connection">
	<div class="container align-items-center">
		<div class="row">
            <div class="col-md-6 login-form">
                <h3>Se connecter</h3>
                <form>
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
                    <!-- <div class="form-check">
				    	<input type="checkbox" class="form-check-input" id="resterConnecte">
				    	<label class="form-check-label" for="resterConnecte">Se souvenir de moi</label>
				  	</div> -->
				  	<div class="form-group" style="margin-top: 40px;">
                        <!-- <input type="submit" class="btnSubmit" value="Login" /> -->
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
<%-- <style><%@include file="/resources/css/style.css"%></style> --%>