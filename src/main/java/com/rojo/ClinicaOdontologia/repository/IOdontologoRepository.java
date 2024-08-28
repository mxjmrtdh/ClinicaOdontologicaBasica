package com.rojo.ClinicaOdontologia.repository;

import com.rojo.ClinicaOdontologia.entity.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOdontologoRepository extends JpaRepository<Odontologo, Integer> {
}
