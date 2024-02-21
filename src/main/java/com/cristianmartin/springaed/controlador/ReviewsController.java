package com.cristianmartin.springaed.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;


@RestController
@RequestMapping("reviews")
public class ReviewsController {
/*
    @Autowired
    ReviewsRepository repositorio;

    @Autowired
    GenresRepository repositorioGenres;

    // http://127.0.0.1:8080/reviews
    @GetMapping
    Page getAllReviews(@RequestParam(required = false) BigDecimal score, @RequestParam(required = false) String genero, Pageable pageable) {

        List<GenresEntity> generoEncontrado = null;

        // buscar el genero en la tabla de genre
        if (genero != null) {
            generoEncontrado = repositorioGenres.findBygenreEquals(genero);
        }

        // le paso el genero pero no funciona devuelve vacio
        if (genero != null && score != null) {
            return repositorio.findBygenresByReviewidAndScoreGreaterThanEqual(generoEncontrado.get(0),score,pageable);
        }
        if (genero != null) {
            return repositorio.findBygenresByReviewid(generoEncontrado.get(0), pageable);
        }
        if (score != null) {
            return repositorio.findByScoreGreaterThanEqual(score,pageable);
        }

        return repositorio.findAll(pageable);
    } */
}

