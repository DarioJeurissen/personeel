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
	<h1>Menu</h1>
	<h2><a href="
		<spring:url var='url' value='/hierarchie'>werknemershierachie
		</spring:url>">
		</a>
	</h2>
	
	<h2><a href="
	<c:url value="/hierarchie">Werknemershiërarchie</c:url>">Werknemershierachie</a></h2>
	<h2><a href="<c:url value='/jobtitels'>Jobtitels</c:url>">Jobtitels</a></h2>
	</div>
</body>
</html>