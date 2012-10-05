package com.tom.mapreduce.movie;

public class Movie {

    private String      name;
    private double      oneToTenRating;
    private Integer     voteCount;

    public Movie(String name, double oneToTenRating, Integer voteCount) {
        this.name = name;
        this.oneToTenRating = oneToTenRating;
        this.voteCount = voteCount;
    }

    public String getName() {
        return name;
    }

    public double getOneToTenRating() {
        return oneToTenRating;
    }

    public Integer getVoteCount() {
        return voteCount;
    }
}
