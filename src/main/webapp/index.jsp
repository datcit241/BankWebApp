<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" errorPage="error.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Login Page</title>
<link rel="stylesheet" href="style.css">
</head>

<body>
	<main style="display: grid">
		<div class="container">

			<div class="screen">

				<div class="screen__content">

					<form action="LoginServlet" method="post" class="login">
						<h1 id="title">Log in</h1>
						<div class="login__field">
							<i class="login__icon fas fa-user"></i> <input type="text"
								class="login__input" name="id" placeholder="User name" id="id"
								value="">
						</div>
						<div class="login__field">
							<i class="login__icon fas fa-lock"></i> <input type="password"
								class="login__input" name="password" placeholder="Password"
								id="password" value="">
						</div>
						<button class="button login__submit">
							<span class="button__text" id="submit-button">Log In Now</span> <i
								class="button__icon fas fa-chevron-right"></i>
						</button>

						<p id="changepass">
							<a href="change_password.jsp">Change password</a>
						</p>

					</form>
				</div>
				<div class="screen__background">
					<span class="screen__background__shape screen__background__shape4"></span>
					<span class="screen__background__shape screen__background__shape3"></span>
					<span class="screen__background__shape screen__background__shape2"></span>
					<span class="screen__background__shape screen__background__shape1"></span>
				</div>
			</div>
		</div>
	</main>
</body>

</html>