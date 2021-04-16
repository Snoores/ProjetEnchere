<!DOCTYPE html>
<html>
<%@include file="templates/head.jspf" %>
	<body>
		<%@include file="templates/header.jspf" %>
		<div class="bloc-modifier-profil">
			<div class="container align-items-center">
				<div class="row">
					<div class="col-modifier-profil">
						<div class="col-md-3">
							<div class="img-prof">
								<img src="https://bootdey.com/img/Content/avatar/avatar7.png" alt="Profil">
							</div>
							<ul class="ul-profil">
								<li>Nom : ${pageContext.session.getAttribute('user').nom}</li>
								<li>Prenom : ${pageContext.session.getAttribute('user').prenom}</li>
								<li>Email : ${pageContext.session.getAttribute('user').email}</li>
							</ul>
						</div>
						<form method="POST" action="${pageContext.request.contextPath}/modification_profile">
							<div class="col-md-8 col-form">
								<div class="col-md-4">
									<div class="form-group">
			                        	<input type="text" class="form-control" name="pseudo" placeholder="Pseudo" value=""/>
			                    	</div>
			                    	<div class="form-group">
			                        	<input type="text" class="form-control" name="prenom" placeholder="Prénom" value=""/>
			                    	</div>
			                    	<div class="form-group">
			                        	<input type="phone" class="form-control" name="telephone" placeholder="Téléphone" value=""/>
			                    	</div>
			                    	<div class="form-group">
			                        	<input type="text" class="form-control" name="codePostal" placeholder="Code Postal" value=""/>
			                    	</div>
			                    	<div class="form-group">
			                        	<input type="password" class="form-control" name="mdpActuel" placeholder="Mot de passe actuel" value=""/>
			                    	</div>
			                    	<div class="form-group">
			                        	<input type="password" class="form-control" name="nouveauMdp" placeholder="Nouveau mot de passel" value=""/>
			                    	</div>
								</div>
								<div class="col-md-4 col-right">
									<div class="form-group">
			                        	<input type="text" class="form-control" name="nom" placeholder="Nom" value=""/>
			                    	</div>
			                    	<div class="form-group">
			                        	<input type="email" class="form-control" name="mail" placeholder="Mail" value=""/>
			                    	</div>
			                    	<div class="form-group">
			                        	<input type="text" class="form-control" name="rue" placeholder="Rue" value=""/>
			                    	</div>
			                    	<div class="form-group">
			                        	<input type="text" class="form-control" name="ville" placeholder="Ville" value=""/>
			                    	</div>
			                    	<div class="form-group">
			                        	<input type="password" class="form-control" name="confirmationMdp" placeholder="Confirmation" value=""/>
			                    	</div>
			                    	<div class="form-group">
			                        	<span>Credit : ${pageContext.session.getAttribute('user').credit}</span>
			                    	</div>
								</div>
							</div>
							<div class="col-btn">
								<button type="submit" class="btn btn-primary w-80">Enregistrer</button>
								<a class="btn btn-danger w-80" href="${pageContext.request.contextPath}/suppression_compte">Supprimer mon compte</a>
							</div>
						</form>
					</div>
				</div>					
			</div>
		</div>
	</body>
</html>