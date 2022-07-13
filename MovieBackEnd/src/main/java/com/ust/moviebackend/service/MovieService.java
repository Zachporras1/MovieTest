package com.ust.moviebackend.service;

import com.ust.moviebackend.dao.MovieDao;
import com.ust.moviebackend.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    private MovieDao movieDao;

    @Autowired
    public MovieService( @Qualifier("MovieRepo") MovieDao movieDao) {
        this.movieDao = movieDao;
    }


    public int insertMovie(Movie movie){

        return movieDao.insertMovie(movie);
    }


   public int deleteMovie(int id){


        return movieDao.deleteMovie(id);
   }
    public int updateMovie(int id, Movie movie){

        return movieDao.updateMovie(id,movie);
    }




    public List<Movie> queryMovies(){

        return movieDao.queryMovies();
    }


    public Optional<Movie> queryMovies(int id){

        return movieDao.queryMovies(id);
    }

}
