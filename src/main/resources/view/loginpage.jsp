<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

<!DOCTYPE html>
<html>
<head>
<title>LoginPage</title>
</head>
<body>
<h1>Login Page </h1>

<form action="home" method="get">
<p>
User Name:<input type="text" name="UserName" placeholder="Enter user name">


Password:<input type="text" name="Password" placeholder="Enter password">
</p>
<input type="submit">
</form>

<a href="signUp">Sign Up</a>

</body>
</html>