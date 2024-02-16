package com.cristianmartin.springaed.repositorio;

import com.cristianmartin.springaed.entidad.GenresEntity;
import com.cristianmartin.springaed.entidad.ReviewsEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface ReviewsRepository extends PagingAndSortingRepository<ReviewsEntity, String> {
    Page findByScoreGreaterThanEqual(BigDecimal score, Pageable pageable);
    Page findBygenresByReviewid(GenresEntity genresByReviewid, Pageable pageable);
    Page findBygenresByReviewidAndScoreGreaterThanEqual(GenresEntity genresByReviewid, BigDecimal score, Pageable pageable);
}
