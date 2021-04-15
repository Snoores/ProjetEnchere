<!DOCTYPE html>
<%@include file="templates/head.jspf" %>
<body>
<%@include file="templates/header.jspf" %>
<div class="container">
<div class="row gutters">
<div class="col-xl-3 col-lg-3 col-md-12 col-sm-12 col-12">
	<div class="card h-100">
		<div class="card-body">
			<div class="account-settings">
				<div class="user-profile">
					<div class="user-avatar">
						<img src="https://bootdey.com/img/Content/avatar/avatar7.png" alt="Maxwell Admin">
					</div>
					<h5>
						<p>${pageContext.session.getAttribute('user').nom}</p>
                		<p>${pageContext.session.getAttribute('user').prenom}</p>
                	</h5>
                	<h6>
                		<p>${pageContext.session.getAttribute('user').email}</p>
                	</h6>
				</div>
		   </div>
	   </div>
   	</div>
	<div class="col-xl-9 col-lg-9 col-md-12 col-sm-12 col-12">
		<div class="card h-100">
			<div class="card-body">
				<form method="POST" action="${pageContext.request.contextPath}/modification_profile">
					<div class="row gutters">
						<div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
							<h6 class="mb-2 text-primary">Details personnels</h6>
						</div>
						<div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
							<div class="form-group">
								<label for="fullName">Pseudo</label>
								<input type="text" class="form-control" name="pseudo" placeholder="Entrez votre pseudo">
							</div>
							<div class="form-group">
								<label for="fullName">Nom</label>
								<input type="text" class="form-control" name="Nom" placeholder="Entrez votre prenom">
							</div>
							<div class="form-group">
								<label for="fullName">Prenom</label>
								<input type="text" class="form-control" name="Prenom" placeholder="Entrez votre prenom">
							</div>
						</div>
						<div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
							<div class="form-group">
								<label for="eMail">Email</label>
								<input type="email" class="form-control" name="Email" placeholder="Entrez votre email">
							</div>
						</div>
						<div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
							<div class="form-group">
								<label for="phone">Telephone</label>
								<input type="text" class="form-control" name="telephone" placeholder="Entrez votre numero de telephone">
							</div>
						</div>
					</div>
					<div class="row gutters">
						<div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
							<h6 class="mt-3 mb-2 text-primary">Adresse</h6>
						</div>
						<div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
							<div class="form-group">
								<label for="Street">Rue</label>
								<input type="name" class="form-control" name="rue" placeholder="Entrez votre rue">
							</div>
						</div>
						<div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
							<div class="form-group">
								<label for="ciTy">Ville</label>
								<input type="name" class="form-control" name="ville" placeholder="Entrez votre ville">
							</div>
						</div>
						<div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
							<div class="form-group">
								<label for="zIp">Code Postal</label>
								<input type="text" class="form-control" name="code postal" placeholder="Entrez votre Code Postal">
							</div>
						</div>
					</div>
						</br>
						<div class="row gutters">
							<div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
								<div class="text-right">
									<a class="btn btn-secondary" href="">Annuler</a>
									<button class="btn btn-primary" type="button" id="submit" name="submit">Modifier</button>
									<a class="btn btn-secondary" href=""> Supprimer mon profil</button>
								</div>
							</div>
						</div>
				</form>
			</div>
		</div>
	</div>
</div>
</div>
</div>

<Style>
body {
	margin: 0;
	padding-top: 40px;
	color: #2e323c;
	background: #f5f6fa;
	position: relative;
	height: 100%;
}

.account-settings .user-profile {
	margin: 0 0 1rem 0;
	padding-bottom: 1rem;
	text-align: center;
}

.account-settings .user-profile .user-avatar {
	margin: 0 0 1rem 0;
}

.account-settings .user-profile .user-avatar img {
	width: 90px;
	height: 90px;
	-webkit-border-radius: 100px;
	-moz-border-radius: 100px;
	border-radius: 100px;
}

.account-settings .user-profile h5.user-name {
	margin: 0 0 0.5rem 0;
}

.account-settings .user-profile h6.user-email {
	margin: 0;
	font-size: 0.8rem;
	font-weight: 400;
	color: #9fa8b9;
}
</style>
</body>
</html>