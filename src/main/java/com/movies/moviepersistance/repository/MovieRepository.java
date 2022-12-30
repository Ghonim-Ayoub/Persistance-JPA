package com.movies.moviepersistance.repository;

import com.movies.moviepersistance.entities.Movie;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class MovieRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public void persist(Movie movie) {
        entityManager.persist(movie);
    }

    public List<Movie> getAll(){
        throw new UnsupportedOperationException();
    }
}
