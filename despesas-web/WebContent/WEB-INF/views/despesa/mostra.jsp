<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<body>
	<h3>Alterar despesa - ${despesa.id}</h3>
	<form action="alteraDespesa" method="post">
		<input type="hidden" name="id" value="${despesa.id}" />
		Descri&ccedil;&atilde;o:<br />
		<textarea name="descricao" cols="100" rows="5">${despesa.descricao}</textarea>
		<br /> Pago? <input type="checkbox" name="pago" value="true"
			${despesa.pago ? 'checked' : ''} /> <br /> Data de pagamento:<br />
		<input type="text" name="dataPagamento"
			value="<fmt:formatDate value="${despesa.dataPagamento.time}" pattern="dd/MM/yyyy" /> " />
		<br /> <br /> <input type="submit" value="Alterar" />
	</form>
</body>
</html>