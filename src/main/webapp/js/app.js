angular.module('app', []).config(function($routeProvider) {
    $routeProvider.
      when('/', {controller:VoteCtrl, templateUrl:'html/vote.html'}).
      otherwise({redirectTo:'/'});
  });