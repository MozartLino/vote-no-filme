function VoteCtrl($scope, $window, $http) {
	var $ = jQuery;

	init = function() {
		$scope.votes = [];

		$http.get('movies').success(function(data) {
			$scope.iterator = new Iterator(createComparisons(data));
			$scope.comparison = $scope.iterator.next();
		});
	}();

	$scope.addVote = function(movie) {
		$scope.votes.push({movie : movie });	

		if ($scope.iterator.hasNext()) {
			$scope.comparison = $scope.iterator.next();
		} else {
			$scope.selection = "form";
		}	
	};

	$scope.postUser = function(user) {

		var userVotes = {
			"user": user,
			"votes" : $scope.votes
		};

		$http.post("users", {"userVotes" : userVotes})
		.success(function(data) {
			$scope.selection = "ranking";
			$scope.rankingByUser = data.rankingByUser;
			$scope.ranking = data.ranking;
		})
		.error(function(data) {
			$("#errors").empty();
			$.each(data.errors, function() {
				$("#errors").append(this.message + "<br />");
			});
		});
	};
}