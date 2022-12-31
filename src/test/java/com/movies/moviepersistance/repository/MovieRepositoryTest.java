package com.movies.moviepersistance.repository;

import com.movies.moviepersistance.config.PersistanceConfig;
import com.movies.moviepersistance.entities.Movie;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {PersistanceConfig.class})
@SqlConfig(dataSource = "dataSourceH2", transactionManager = "transactionManager")
@Sql({"/datas/datas-test.sql"})
public class MovieRepositoryTest {

    @Autowired
    private MovieRepository movieRepository;

    @Test
    public void save_nominalCase(){
        Movie Momento = new Movie();
        Momento.setName("Momento");
        movieRepository.persist(Momento);
    }
    @Test
    public void find_nominalCase(){
        Movie avatar = movieRepository.find(-2L);
        assertThat(avatar.getName()).as("This is not our film").isEqualTo("Avatar");
    }
    @Test
    public void getAll_nominalCase(){
        List<Movie> movies = movieRepository.getAll();
        assertThat(movies).as("Our movies not found").hasSize(2);
    }
}
