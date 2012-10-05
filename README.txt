MapReduce Kata

Goal: Introduce a Hadoop like implementation of MapReduce - write the logic without
needing a hadoop install to experiment.

The map reduce algorithm requires two methods to be implemented for each problem.

* Map: this method takes the raw data and maps it to a dimension and a fact.
  dimension: how we want to aggregate the data (eg. Year, Customer)
  fact: a multi-valued, attributed to each dimension (eg. highest votes, order amount

* Reduce: total or aggregate all the values for a given dimension/key

This Kata has three problems:

1) WordCount - hello world map reduce
   - Fix implementation so that WordCountTest passes
   - WordCountMapperReducer needs additional logic in the map and reduce methods.

2) MovieRatingsByYear
   - Fix implementation so that MovieRatingByYearTest passes

3) Code a map reduce implementation to find the year with the highest average movie rating.
   What was the best year for movies?
   The full data set can be found on the web:

