package com.rojo.ClinicaOdontologia.repository;

import com.rojo.ClinicaOdontologia.entity.Domicilio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDomicilioReporsitory extends JpaRepository<Domicilio, Integer> {
}
