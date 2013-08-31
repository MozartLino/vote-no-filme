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