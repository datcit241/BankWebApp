<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" errorPage="error.jsp"%>
<%--<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>--%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Registration</title>
<link rel="stylesheet" href="style.css">
</head>


<body>
	<main  style="display: grid">
		<div class="container">

			<div class="screen">

				<div class="screen__content">

					<form action="RegisterServlet" method="post" class="login">

						<h1 id="title">Registration</h1>
						<div class="login__field">
							<i class="login__icon fas fa-user"></i> <input type="text"
								class="login__input" id="customer-name" name="customer-name"
								placeholder="Full Name" aria-describedby="customer-name ">
						</div>
						<div class="login__field">
							<i class="login__icon fas fa-lock"></i> <input type="text"
								class="login__input" id="customer-address"
								name="customer-address" aria-describedby="customer-address"
								placeholder="Address">
						</div>

						<div class="login__field">
							<i class="login__icon fas fa-lock"></i> <input type="text"
								class="login__input" id="customer-phone" name="customer-phone"
								aria-describedby="customer-phone" placeholder="Phone number">
						</div>
						<button class="button login__submit ">
							<span class="button__text" id="submit-button">Submit</span>
						</button>

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