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