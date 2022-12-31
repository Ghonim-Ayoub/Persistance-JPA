package com.movies.moviepersistance.repository;

import com.movies.moviepersistance.entities.Movie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;


@Repository
public class MovieRepository {
private static final Logger LOGGER = LoggerFactory.getLogger(MovieRepository.class);
    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public void persist(Movie movie) {
        LOGGER.trace("entityManager session contains "+entityManager.contains(movie));
        entityManager.persist(movie);
        LOGGER.trace("entityManager session contains "+entityManager.contains(movie));
    }

    public Movie find(Long id) {
        Movie result = entityManager.find(Movie.class, id);
        LOGGER.trace("The session contains our film "+entityManager.contains(result));
        return result;
    }
    public List<Movie> getAll(){
        return entityManager.createQuery("from Movie", Movie.class).getResultList();
    }
}
