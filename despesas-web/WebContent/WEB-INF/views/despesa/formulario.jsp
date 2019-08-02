<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>Adiciona despesas</h3>	
	<form:errors path="despesa.descricao" cssStyle="color:red"/>	
	<br />
	<br />	
	<form action="adicionaDespesa" method="post">
		Descrição: <br />
		<textarea rows="5" cols="100" name="descricao"></textarea>
		<br /> <input type="submit" value="Adicionar" />
	</form>
</body>
</html>