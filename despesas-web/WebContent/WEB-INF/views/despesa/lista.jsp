<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<script type="text/javascript" src="resources/js/jquery.js"></script>
</head>
<body>
	<a href="novaDespesa">Criar nova despesa</a>
	<br />
	<br />
	<table cellpadding="2" cellspacing="2">
		<tr>
			<th>Id</th>
			<th>Descri&ccedil;&atilde;o</th>
			<th>Pago?</th>
			<th>Data pagamento</th>
		</tr>
		<c:forEach items="${despesas}" var="despesa">
			<tr id="despesa_${despesa.id}">
				<td >${despesa.id}</td>
				<td>${despesa.descricao}</td>

				<c:if test="${despesa.pago eq true }">
					<td>Pago</td>
				</c:if>
				<c:if test="${despesa.pago eq false }">
					<td><a href="#" onClick="quitarAgora(${despesa.id})">Pagar</a></td>
				</c:if>

				<td><fmt:formatDate value="${despesa.dataPagamento.time}"
						pattern="dd/MM/yyyy" /></td>
				<td><a href="removeDespesa?id=${despesa.id}">Remover</a>
				<td><a href="mostraDespesa?id=${despesa.id}">Mostrar</a>
			</tr>
		</c:forEach>
	</table>

	<script type="text/javascript"> 
	function quitarAgora(id) 
	{ 
		$.post("quitarDespesa", {'id' : id}, function(resposta) { 
				//muda a linha da tabela pelo id 
				$("#despesa_"+id).html(resposta);
			}); 
		} 
	</script>
</body>
</html>