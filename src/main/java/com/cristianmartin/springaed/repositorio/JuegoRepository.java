package com.cristianmartin.springaed.repositorio;

import com.cristianmartin.springaed.entidad.JuegoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JuegoRepository extends JpaRepository<JuegoEntity, String> {
    List<JuegoEntity> findBytitulo(String titulo);
}
