package com.rojo.ClinicaOdontologia.service;

import com.rojo.ClinicaOdontologia.entity.Turno;

import java.util.List;
import java.util.Optional;

public interface ITurnoService {
    Turno guardarTurno(Turno turno);

    Optional<Turno> buscarPorId(Integer id);
    List<Turno> buscarTodos();

    void modificarTurno(Turno turno);

    void eliminarTurno(Integer id);
}
