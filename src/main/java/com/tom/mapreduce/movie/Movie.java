package com.tom.mapreduce.movie;

public class Movie {

    private String      name;
    private float       oneToTenRating;
    private Integer     voteCount;
    private Integer     releaseYear;

    public Movie(String     name,
                 float      oneToTenRating,
                 Integer    voteCount,
                 Integer    releaseYear) {
        this.name           = name.trim();
        this.oneToTenRating = oneToTenRating;
        this.voteCount      = voteCount;
        this.releaseYear    = releaseYear;
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

    public Integer getReleaseYear() {
        return releaseYear;
    }

    @Override
    public String toString() {
        return String.format("%s|year=%d|rating=%.1f|votes=%d",
                             name, releaseYear, oneToTenRating, voteCount);
    }

}
