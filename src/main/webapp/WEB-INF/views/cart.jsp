<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@	taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cart</title>
</head>
<body>
	<h1>Cart summary:</h1>

	<c:forEach items="${cart }" var="cart"><h3>
	ID: ${cart.getProduct().getId()},
	Name: ${cart.getProduct().getName()},
	Price: ${cart.getProduct().getPrice()} zł, 	
	Quantity: ${cart.getQuantity()}
	<a href="/SpringHomework_02/changeQuantity/plus/${cart.getProduct().getId()}">Dodaj produkt</a>
	<a href="/SpringHomework_02/changeQuantity/minus/${cart.getProduct().getId()}">Odejmij produkt</a>
	<a href="/SpringHomework_02/deleteFromCart?id=${cart.getProduct().getId()}&quantity=${cart.getQuantity()}">Usuń produkt</a>
	</h3>
	</c:forEach>
	<h2>W koszyku jest: ${cartSize} pozycji</h2>
	<h2>W koszyku jest: ${productQuantity} produktów.</h2>
	<h2>Wartość koszyka to: ${totalPrice}.</h2>

</body>
</html>