<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add to cart</title>
</head>
<body>
<form:form action="addtocart" modelAttribute="product" method="post">
		<h2>
			Product id:
			<input type="number" name="id" step="1" />
		</h2>
		<br />
		<h2>
			Product name:
			<input type="text" name="name" />
		</h2>
		<h2>
			Product price:
			<input type="number" name="price" step="0.1" />
		</h2>
		<br />
		<h2>Quantity <input type="number" name="quantity" step="1" /></h2>
		<br/>
		<input type="submit" value="Send">
	</form:form>

</body>
</html>