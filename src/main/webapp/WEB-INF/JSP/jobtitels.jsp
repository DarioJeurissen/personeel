<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='v' uri='http://vdab.be/tags'%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<!doctype html>
<html lang='nl'>
<head>
<v:head title='Personeel' />
</head>
<body>
	<div class="center">
	<h1>Jobtitels</h1>
	<c:forEach items='${jobtitels}' var='titel'>
		<spring:url var='url' value='/jobtitels/{id}'>
			<spring:param name='id' value='${titel.id}' />
		</spring:url>
		<a href='${url}'>${titel}</a><br>
	</c:forEach>
	<h1>${jobtitel}</h1>
	<ul>
		<c:forEach items='${jobtitel.werknemers}' var='werknemer'>
			<li>
				<spring:url var='url' value ='/hierarchie/{id}'>
					<spring:param name='id' value='${werknemer.id}'/>
				</spring:url>
				<a href="${url}">${werknemer.naam}</a>
			</li>
		</c:forEach>
	</ul>
	</div>
</body>
</html>