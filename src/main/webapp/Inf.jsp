<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Информация о разработчиках:</title>
</head>
<body>
<h1>Номера зачетных книжек указаны ниже:</h1>
<p><strong>Модератор подгруппы: Батыров Денис Дамирович - 19130633</strong></p>
<p><strong>1-й участник подгруппы: Мингареев Радмир Адикович - 19130639</strong></p>
<p><strong>2-й участник подгруппы: Насыров Аскар Русланович - 19130620</strong></p>
<p><strong>3-й участник подгруппы: Погудина Милена Константиновна - 19130635</strong></p>
<form action="${pageContext.request.contextPath}/Read" method="post">
	<input type="submit" name="sign" value="Назад">
	</form>
</body>
</html>