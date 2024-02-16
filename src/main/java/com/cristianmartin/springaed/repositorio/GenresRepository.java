package com.cristianmartin.springaed.repositorio;

import com.cristianmartin.springaed.entidad.GenresEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenresRepository extends JpaRepository<GenresEntity, String> {
    List<GenresEntity> findBygenreEquals(String genero);
}
