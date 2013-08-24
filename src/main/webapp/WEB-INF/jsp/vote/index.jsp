<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Vote no Filme</title>
</head>
<body>

<c:forEach var="movie" items="${movies}">
   ID <c:out value="${movie.id}"/><p>
   movie <c:out value="${movie.name}"/><p>
   Genero <c:out value="${movie.genero}"/><p>
   Sinopse <c:out value="${movie.sinopse}"/><p>
   
   <br />
   <br />
</c:forEach>

</body>
</html>