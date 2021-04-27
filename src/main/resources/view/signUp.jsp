<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

<!DOCTYPE html>
<html>
<head>
<title>SignUp</title>
</head>
<body>
<h1>Sign Up</h1>


<form action="home" method="post">
<p>
User Name:<input type="text" name="User Name" placeholder="Enter user name">

Password:<input type="text" name="Password" placeholder="Enter password">

Confirm Password:<input type="text" name="ConfirmedPassword" placeholder="Re Enter password">
</p>
<input type="submit">
</form>

<a href="loginIn">Back to Login Page</a>



</body>
</html>