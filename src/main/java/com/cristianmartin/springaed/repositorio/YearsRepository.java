package com.cristianmartin.springaed.repositorio;

import com.cristianmartin.springaed.entidad.YearsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface YearsRepository extends JpaRepository<YearsEntity, String> {
}
