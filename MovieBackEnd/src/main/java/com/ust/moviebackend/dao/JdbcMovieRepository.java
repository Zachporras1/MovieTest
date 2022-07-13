package com.ust.moviebackend.dao;

import com.ust.moviebackend.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository("MovieRepo")
public class JdbcMovieRepository implements MovieDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int insertMovie(Movie movie) {

        String sql= "INSERT INTO movies (title,duration,genre,rating) VALUES(?,?,?,?)";

        return jdbcTemplate.update(sql, movie.getTitle(),movie.getDuration(),movie.getGenre(),movie.getRating());

    }

    @Override
    public int deleteMovie(int id) {

        String sql= "DELETE FROM movies WHERE id=?";
        return jdbcTemplate.update(sql,id);

    }

    @Override
    public int updateMovie(int id, Movie movie) {
        String sql= "UPDATE movies SET title=?,duration=?,genre=?,rating=? WHERE id=?";

        return jdbcTemplate.update(sql,movie.getTitle(),movie.getDuration(),movie.getGenre(),movie.getRating(),id);
    }



    @Override
    public List<Movie> queryMovies() {
        String sql= "SELECT * FROM movies";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Movie.class));
    }

    @Override
    public Optional<Movie> queryMovies(int id) {

        Movie movie=null;

        try{
            String sql= "SELECT * FROM movies WHERE id=?";
            movie=jdbcTemplate.queryForObject(sql,BeanPropertyRowMapper.newInstance(Movie.class),id);
            return Optional.ofNullable(movie);
        }
        catch(IncorrectResultSizeDataAccessException e){
            return Optional.ofNullable(movie);
        }

    }
}
