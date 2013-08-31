<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="US-ASCII"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html ng-app>
<head>
	<link href="http://getbootstrap.com/2.3.2/assets/css/bootstrap-responsive.css" rel="stylesheet">
	<link href="http://getbootstrap.com/2.3.2/assets/css/bootstrap.css" rel="stylesheet">
	<link href=<c:url value="/css/style.css"/> rel="stylesheet">

	<title>Vote no Filme</title>
</head>
<body>

	<div class="container" ng-controller="VoteCtrl">
	
		<div class="animate-switch-container" ng-switch on="selection">
          <div ng-switch-when="form" ng-include="'html/form.html'"></div>
          <div ng-switch-when="ranking" ng-include="'html/ranking.html'"></div>
          <div ng-switch-default ng-include="'html/vote.html'" compile="html"></div>
      </div>
	</div>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.7/angular.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.7/angular-resource.min.js"></script>
	<script src="https://cdn.firebase.com/v0/firebase.js"></script>
	<script src="http://firebase.github.io/angularFire/angularFire.js"></script>
	<script src=<c:url value="/js/comparison.js"/>></script>
	<script src=<c:url value="/js/iterator.js"/>></script>
	<script src=<c:url value="/js/vote.js"/>></script>
</body>
</html>