function VoteCtrl($scope, $window, $http) {
	var $ = jQuery;

	init = function() {
		$http.get('users/token').success(function(data) {
			$scope.user = {};
			$scope.user.id = data;
		});

		$http.get('movies').success(function(data) {
			$scope.iterator = new Iterator(createComparisons(data));
			$scope.comparison = $scope.iterator.next();
		});
	}();

	$scope.postVote = function(movie) {
		var vote = $.extend({}, {
			"user" : {
				"id" : $scope.user.id
			}
		},{
			"movie" : movie
		});

		$http.post("votes", {
			"vote" : vote
		}).success(function(data) {
			console.log(data);
		});

		if ($scope.iterator.hasNext()) {
			$scope.comparison = $scope.iterator.next();
		} else {
			$("#comparison").hide();
			$("#form").show();
		}
	};

	$scope.putUser = function(user) {
		$http.put("users", {
			"user" : $scope.user
		}).success(function(data) {
			$scope.rankingByUser = data;
			$("#form").hide();
			$("#ranking").show();
		});

		$http.get('ranking').success(function(data) {
			$scope.ranking = data;
		});
	};

}

function createComparisons(movies) {
	var comparisons = [];
	var length = movies.length - 1;

	while (length > 0) {
		for ( var i = 0; i < length; i++) {
			var comparison = new Object();
			comparison.first = movies[length];
			comparison.second = movies[i];

			comparisons.push(comparison);
		}
		length--;
	}

	shuffle(comparisons);

	return comparisons;
}

function shuffle(comparisons) {
	var i = comparisons.length, j, tempi, tempj;
	if (i == 0)
		return comparisons;
	while (--i) {
		j = Math.floor(Math.random() * (i + 1));
		tempi = comparisons[i];
		tempj = comparisons[j];
		comparisons[i] = tempj;
		comparisons[j] = tempi;
	}
}

function Iterator(comparisons) {
	var index = 0, data = comparisons;

	return {
		next : function() {
			var element = data[index];
			index += 1;
			return element;
		},
		hasNext : function() {
			return index < data.length;
		}
	};
};