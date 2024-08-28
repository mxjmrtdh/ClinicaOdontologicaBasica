package com.rojo.ClinicaOdontologia.repository;

import com.rojo.ClinicaOdontologia.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPacienteRepository extends JpaRepository<Paciente, Integer> {
}
