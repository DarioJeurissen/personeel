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
		<h1>Werknemer ${werknemer.naam}</h1>
		<table>
			<tr>
				<th>Voornaam</th>
				<td>${werknemer.voornaam}</td>
			</tr>
			<tr>
				<th>Familienaam</th>
				<td>${werknemer.familienaam}</td>
			</tr>
			<tr>
				<th>Email Adres</th>
				<td>${werknemer.email}</td>
			</tr>
			<tr>
				<th>Salaris</th>
				<td>${werknemer.salaris}</td>
			</tr>
			<tr>
				<th>Jobtitel</th>
				<td><spring:url var='url' value='/jobtitels/{id}'>
						<spring:param name='id' value='${werknemer.jobtitel.id}' />
					</spring:url> <a href='${url}'>${werknemer.jobtitel}</a></td>
			</tr>
			<c:if test='${not empty werknemer.chef}'>
				<tr>
					<th>Chef</th>
					<td><spring:url var='url' value='/hierarchie/{id}'>
							<spring:param name='id' value='${werknemer.chef.id}' />
						</spring:url> <a href='${url}'>${werknemer.chef}</a></td>
				</tr>
			</c:if>
			<c:if test='${not empty werknemer.ondergeschikten}'>
				<tr>
					<th>Ondergeschikten</th>
					<td><c:forEach items='${werknemer.ondergeschikten}' var='w'>
							<spring:url var='url' value='/hierarchie/{id}'>
								<spring:param name='id' value='${w.id}' />
							</spring:url>
							<a href='${url}'>${w.naam}</a>
							<br>
						</c:forEach></td>
				</tr>
			</c:if>
			<tr>
				<th>Foto</th>
				<td><img alt='fout'
					src='<c:url value="/images/${werknemer.id}.jpg"/>'></td>
			</tr>
			<tr>
				<td>Opslag</td>
				<td><spring:url var='url' value='/opslag/{id}'>
						<spring:param name='id' value='${werknemer.id}' />
					</spring:url> <a href='${url}'>Klik hier</a></td>
			</tr>
		</table>
	</div>
</body>
</html>