package com.cristianmartin.springaed.repositorio;

import com.cristianmartin.springaed.entidad.LabelsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LabelsRepository extends JpaRepository<LabelsEntity, String> {
}
