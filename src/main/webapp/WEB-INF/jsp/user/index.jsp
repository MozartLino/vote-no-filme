<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="US-ASCII"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="app">
<head>
<title>Vote no Filme</title>
<link href="http://getbootstrap.com/2.3.2/assets/css/bootstrap-responsive.css" rel="stylesheet">
<link href="http://getbootstrap.com/2.3.2/assets/css/bootstrap.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.7/angular.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.7/angular-resource.min.js"></script>
<script src="https://cdn.firebase.com/v0/firebase.js"></script>
<script src="http://firebase.github.io/angularFire/angularFire.js"></script>
<link href=<c:url value="/css/style.css"/> rel="stylesheet">
<script src=<c:url value="/js/jquery-2.0.3.min.js"/>></script>
<script src=<c:url value="/js/app.js"/>></script>
<script src=<c:url value="/js/vote.js"/>></script>

</head>

<body>
	<div class="container" >
		<div ng-view></div>
	</div>
</body>
</html>