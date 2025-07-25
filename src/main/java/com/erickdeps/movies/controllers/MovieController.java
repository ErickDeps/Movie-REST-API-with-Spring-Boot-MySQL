package com.erickdeps.movies.controllers;

import com.erickdeps.movies.models.Movie;
import com.erickdeps.movies.repositories.MovieRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/movies")
public class MovieController {
    
    @Autowired    
    private MovieRepository movieRepository;
    
    // Listar todas las peliculas.
    @CrossOrigin // Permite la utilizacion de la ruta a través de una aplicacion tercera (pj. app en vue).
    @GetMapping
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }
    
    // Obtener una pelicula
    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Long id) {
        Optional<Movie> movie = movieRepository.findById(id);
        return movie.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    // Creacion de una nueva pelicula
    @CrossOrigin
    @PostMapping()
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie) {
        Movie savedMovie = movieRepository.save(movie);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedMovie);
    }
    
    // Borrar una pelicula
    @CrossOrigin
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long id) {
        
        // Si no existe la pelicula ...
        if(!movieRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        // Si sí existe...
        movieRepository.deleteById(id);
        return ResponseEntity.noContent().build();
        
    }
    
    // Actualizar una pelicula
    @CrossOrigin
    @PutMapping("/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable Long id, @RequestBody Movie updatedMovie) {
        
        // Si no existe la pelicula ...
        if(!movieRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        
        updatedMovie.setId(id);
        Movie savedMovie = movieRepository.save(updatedMovie);
        return ResponseEntity.ok(savedMovie);
        
    }
    
    // Accion de Rating
    @CrossOrigin
    @PatchMapping("/vote/{id}/{rating}")
    public ResponseEntity<Movie> voteMovie(@PathVariable Long id, @PathVariable double rating) {
        
        // Si no existe la pelicula ...
        if(!movieRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        
        Optional<Movie> optional = movieRepository.findById(id);
        Movie movie = optional.get();
        
        double newRating = ( movie.getVotes() * movie.getRating() + rating) / ( movie.getVotes() + 1);
        
        movie.setRating(newRating);
        movie.setVotes(movie.getVotes() + 1);
        
        Movie savedMovie = movieRepository.save(movie);
        return ResponseEntity.ok(savedMovie);
    }
    
}
