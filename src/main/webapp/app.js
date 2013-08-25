angular.module('app', []).config(function($routeProvider) {
    $routeProvider.
      when('/', {templateUrl:'vote.html'}).
      otherwise({redirectTo:'/'});
  });