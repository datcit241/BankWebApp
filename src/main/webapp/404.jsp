<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isErrorPage="true"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>404</title>
<style>
img {
	max-width: 400px;
}

.content {
	display: flex;
	flex-direction: column;
	align-items: center;
	text-align: center;
}

a {
	font-weight: 900;
	text-decoration: none;
	text-transform: uppercase;
}
</style>
</head>

<body>
	<main>
		<div class="content">
			<aside>
				<img src="images/404-error.jpg" alt="404 Image" />
			</aside>
			<main>
				<h1>Sorry!</h1>
				<p>This page or it doesn't exist.</p>
				<a href="index.jsp">Go back</a>
			</main>
		</div>
	</main>
</body>
</html>