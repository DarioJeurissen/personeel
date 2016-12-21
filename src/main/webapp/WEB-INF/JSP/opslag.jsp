<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='v' uri='http://vdab.be/tags'%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form'%>
<!doctype html>
<html lang='nl'>
<head>
<v:head title='Personeel' />
</head>
<body>
	<div class="center">
	<h1>Opslag voor ${werknemer.naam}</h1>
	<h2>Huidige Salaris</h2>
	<h3>${werknemer.salaris}</h3>
	<form:form action='${opslag}' commandName='opslagForm' method='post'>
		<form:label path='bonus'>Opslag:
		<form:errors path='bonus'/></form:label>
		<form:input path='bonus' autofocus='autofocus' required='required' min='1' />
		<p><input type='submit' value='Opslag'></p>
	</form:form>
	${error}
	</div>
</body>
</html>