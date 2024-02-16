package com.cristianmartin.springaed.repositorio;

import com.cristianmartin.springaed.entidad.ArtistsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArtistsRepository extends JpaRepository<ArtistsEntity, String> {
    List<ArtistsEntity> findByartist(String artistName);
}
