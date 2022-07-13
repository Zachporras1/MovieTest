package com.ust.moviebackend.api;


import com.ust.moviebackend.model.Movie;
import com.ust.moviebackend.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "movies/")
@CrossOrigin(origins = "http://localhost:4200")
public class MovieController {

    @Autowired
    private MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    public int insertMovie(@RequestBody Movie movie){

        return movieService.insertMovie(movie);
    }

    @PutMapping(value = "{id}")
    public int updateMovie(@PathVariable("id") int id,  @RequestBody Movie movie){

        return movieService.updateMovie(id,movie);
    }


    @DeleteMapping(value = "{id}")
    public int deleteMovie(@PathVariable("id") int id){

        return movieService.deleteMovie(id);
    }

    @GetMapping
    List<Movie> queryMovies(){

        return movieService.queryMovies();
    }

    @GetMapping(value = "{id}")
    Optional<Movie> queryMovies(@PathVariable("id") int id){

        return movieService.queryMovies(id);
    }


}
