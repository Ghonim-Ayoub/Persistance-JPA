package com.movies.moviepersistance.repository;

import com.movies.moviepersistance.config.PersistanceConfig;
import com.movies.moviepersistance.entities.Movie;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {PersistanceConfig.class})
public class MovieRepositoryTest {

    @Autowired
    private MovieRepository movieRepository;

    @Test
    public void save_nominalCase(){
        Movie Momento = new Movie();
        Momento.setName("Momento");
        movieRepository.persist(Momento);
    }
}
