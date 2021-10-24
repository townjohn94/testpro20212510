<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Стоимость производства оконных конструкций:</title>
</head>
<body>
<h1>Стоимость производства оконных конструкций:</h1>
<h2>Ваши введеные данные:</h2>
<p><strong>Высота: </strong>${ParA}</p>
<p><strong>Ширина: </strong>${ParB}</p>
<p><strong>Вид створок:</strong>${stvor_result}</p>
<p><strong>Стеклопакет:</strong>${steklo_result}</p>
<p><strong>Материал створок:</strong>${material_result}</p>
<p><strong>Цвет створок:</strong>${tsvet_result}</p>

<p><strong>Итоговая стоимость:</strong> ${result}</p>
<a href="Check.pdf"> Open PDF-file</a>	
<a href="Check.pdf" download> Download PDF-file</a>
<form action="${pageContext.request.contextPath}/Read" method="post" >
	<input type="submit" name="sign" value="Назад">
	</form>
<a href="<c:url value='/logout' />" style="position:relative;left: 45%">Logout</a>
</body>
</html>