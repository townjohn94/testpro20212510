<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script>


<!--
function myFunction1(e) {
	document.getElementById("priceForParB").value = e.target.value
}
--!>


function myFunction2(e) {
	document.getElementById("priceSteklo").value = e.target.value
}
function myFunction3(e) {
	document.getElementById("priceMaterial").value = e.target.value
}
function myFunction4(e) {
	document.getElementById("priceTsvet").value = e.target.value
}
function myFunction5(e) {
	var x = document.getElementById("kk").value;
	var x1 = document.getElementById("priceForParB").value = x*1.5;
	 var cb = document.getElementById("checkbox_check");
	  if (cb.checked) {
		  document.getElementById("priceForParB").value = x*1.5;
	  } else {
		  document.getElementById("priceForParB").value = x1/1.5;
	  }
}
</script>
<meta charset="UTF-8">
<title>Калькулятор стоимости оконных конструкций</title>
</head>
<body>
<h1 style="position:relative;text-align:center">Калькулятор стоимости производства оконных конструкций</h1>
<form action="${pageContext.request.contextPath}/JavaCalc" method="post">
<label style="position:relative;left: 45%">Варианты створок:</label>
		<select id="kk" name="VarStvor" required onchange="myFunction1(event);" style="position:relative;left: 45%">
    <option selected disabled =""></option>
    <option value="${ varstv1 }">Одностворчатое</option>
    <option value="${ varstv2 }">Двухстворчатое</option> 
    <option value="${ varstv3 }">Трехстворчатое</option>
    <option value="${ varstv4 }">Двухстворчатое с фрамугой</option>
    <option value="${ varstv5 }">Трехстворчатое с фрамугой</option>
   </select>
  <p><label style="position:relative;left: 34%;">Стеклопакет:</label>
		<select name="priceSteklo" required onchange="myFunction2(event);"  style="position:relative;left: 34%;width:8%">
    <option selected disabled =""></option>
    <option value="${ stekl1 }">Однокамерный</option>
    <option value="${ stekl2 }">Двухкамерный</option>
    <option value="${ stekl3 }">Трехкамерный</option>
   </select>
   <label style="position:relative;left: 38.5%">Стоимость стеклопакета:</label>
		<input id="priceSteklo" readonly size="15" style="position:relative;left: 38.5%">
</p>
    <p><label style="position:relative;left: 34%">Материал створок:</label>
		<select name="priceMaterial" required onchange="myFunction3(event);" style="position:relative;left: 34%;width:8%" >
    <option selected disabled =""></option>
   <option value="${ mat1 }">Дерево</option>
   <option value="${ mat2 }">Металл</option>
   <option value="${ mat3 }">ПВХ</option>
   <option value="${ mat4 }">Дерево-металл</option>
   <option value="${ mat5 }">ПВХ-металл</option>
   </select> 
   <label style="position:relative;left: 35%">Стоимость материала створок:</label>
		<input id="priceMaterial" readonly size="15" style="position:relative;left:35%">
</p>
    <p><label style="position:relative;left: 34%">Цвет створок:</label>
		<select name="priceTsvet" required onchange="myFunction4(event);" style="position:relative;left: 34%;width:6%">
    <option selected disabled =" "></option>
    <option value="${ tsvet1 }">Черный</option>
    <option value="${ tsvet2 }">Белый</option>
    <option value="${ tsvet3 }">Цветной</option>
   </select> 
    <label style="position:relative;left: 36.9%">Стоимость цвета створок:</label>
		<input id="priceTsvet"  readonly size="15" style="position:relative;left: 36.9%">
</p>
<p> <label style="position:relative;left: 40%">Высота:</label>
		<input type="a" min="500"  name="ParA"  required style="position:relative;left: 40%"> </p>
<p> <label style="position:relative;left: 37%">Ширина:</label>
		<input type="b" min="500"  name="ParB"  readonly style="position:relative;left: 37%"> </p>
		
		
		<!--
<p><label style="position:relative;left: 41.5%">Срочный заказ:</label>
        <input type ="checkbox" onclick="myFunction5(event);" id="checkbox_check" name="check" style="position:relative;left: 41.5%"> </p>
        --!>
        
        
	<input style="position:relative;left: 45%" type="submit" value=" Рассчитать ">
	</form>
	<form action="${pageContext.request.contextPath}/Spravka.jsp" method="post">
	<input style="position:relative;left: 45%" type="submit" value=" Справка ">
	</form>
	<a href="<c:url value='/logout' />" style="position:relative;left: 45%">Logout</a>
	</body>
</html>
