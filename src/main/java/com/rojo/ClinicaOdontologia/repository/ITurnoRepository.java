package com.rojo.ClinicaOdontologia.repository;

import com.rojo.ClinicaOdontologia.entity.Turno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITurnoRepository extends JpaRepository<Turno, Integer> {
}
