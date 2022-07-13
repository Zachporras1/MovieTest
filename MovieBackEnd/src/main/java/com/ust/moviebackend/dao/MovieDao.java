package com.ust.moviebackend.dao;

import com.ust.moviebackend.model.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieDao {
//int insertMovie(int id, Movie movie);

int insertMovie(Movie movie);


int deleteMovie(int id);
int updateMovie(int id, Movie movie);

List<Movie> queryMovies();


Optional<Movie> queryMovies(int id);


}
