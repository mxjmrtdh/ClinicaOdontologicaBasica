package com.rojo.ClinicaOdontologia.repository;

import com.rojo.ClinicaOdontologia.entity.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IOdontologoRepository extends JpaRepository<Odontologo, Integer> {
        List<Odontologo> findBynumeroMatricula(Integer numeroMatricula);

        @Query("Select o from Odontologo o where LOWER(o.nombre) LIKE LOWER(CONCAT('%',:parteNombre,'%'))")
        List<Odontologo> buscarPorParteNombre(String parteNombre);
    }

