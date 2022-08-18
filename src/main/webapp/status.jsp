<%--<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" errorPage="error.jsp"%>--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Status</title>
	<link
			href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
			rel="stylesheet"
			integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
			crossorigin="anonymous">
	<link rel="stylesheet" type="text/css"
		  href="https://cdn.jsdelivr.net/npm/toastify-js/src/toastify.min.css">
	<link rel="stylesheet" href="css/style.css">

</head>
<%
	String status = String.valueOf(request.getAttribute("status"));
	if (status.equals("true")) {
		status = "SUCCESSFUL";
	} else {
		status = "FAILED";
	}
	String action = (String) request.getAttribute("action");
	double money = (double) request.getAttribute("money");
%>
<body onload="access()">
<main style="text-align: center; margin-top: 50px">
	<h3 id="action" style="color: red"><%=action%> <%=status%></h3>
	<br> <a href="homepage.jsp" class="btn btn-primary">Back</a>
	<p id="money" style="display: none"><%=money%></p>
</main>

<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"
		integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB"
		crossorigin="anonymous"></script>
<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"
		integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13"
		crossorigin="anonymous"></script>
<script type="text/javascript "
		src="https://cdn.jsdelivr.net/npm/toastify-js "></script>

<script type="text/javascript">
	function access() {
		var value = document.getElementById("money").innerHTML;
		var action = document.getElementById("action").innerHTML;
		var number = parseFloat(value);
		if (action == "WITHDRAW") {
			if (number > 0) {
				Toastify({
					text : "Your Withraw is " + number + " VND",
					duration : 3000
				}).showToast();
				console.log(number + " 2");

			} else if (number <= 0) {
				Toastify({
					text : "Your Withdraw Amount Invalid!",
					duration : 3000
				}).showToast();
				console.log(number + " 3");
			}
		}
	}
</script>

</body>
</html>