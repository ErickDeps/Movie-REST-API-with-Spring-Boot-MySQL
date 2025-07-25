package com.erickdeps.movies.repositories;

import com.erickdeps.movies.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long>{
    
}
